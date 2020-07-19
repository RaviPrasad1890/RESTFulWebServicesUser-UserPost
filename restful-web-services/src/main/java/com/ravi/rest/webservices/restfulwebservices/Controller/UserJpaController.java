package com.ravi.rest.webservices.restfulwebservices.Controller;

import com.ravi.rest.webservices.restfulwebservices.Exception.UserNotFoundException;
import com.ravi.rest.webservices.restfulwebservices.Model.Post;
import com.ravi.rest.webservices.restfulwebservices.Model.User;
import com.ravi.rest.webservices.restfulwebservices.Repository.PostJPARepository;
import com.ravi.rest.webservices.restfulwebservices.Repository.UserDaoService;
import com.ravi.rest.webservices.restfulwebservices.Repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaController {

    @Autowired
    private UserJPARepository userRepo;

    @Autowired
    private PostJPARepository postRepo;

    @GetMapping(path="jpa/user")
    public List<User> getAllUser(){
        return userRepo.findAll();
    }


    @GetMapping(path="jpa/user/{id}")
    public User getUser(@PathVariable Integer id){
        Optional<User> user=userRepo.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("UserId "+id+" Doesn't Exist");
        }
        return user.get();
    }

    /*
    ResponseEntity: ResponseEntity represents an HTTP response, including headers, body, and status.
    While @ResponseBody puts the return value into the body of the response,
    ResponseEntity also allows us to add headers and status code.
     */

    @PostMapping(path="jpa/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser=userRepo.save(user);
        //To get URI of resource which was build
        //jpa/user/{id}
        URI location =ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").buildAndExpand(savedUser.getId()).
                toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="jpa/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        userRepo.deleteById(id);
    }

    @GetMapping("/jpa/user/{id}/post")
    public List<Post> retreiveAllUserPost(@PathVariable int id){
        Optional<User> user=userRepo.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("UserId "+id+" Doesn't Exist");
        }
        return user.get().getPosts();
    }

    @PostMapping("/jpa/user/{id}/post")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id,@RequestBody Post post){
        Optional<User> userOptional=userRepo.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("UserId "+id+" Doesn't Exist");
        }
        User user= userOptional.get();
        post.setUser(user);
        postRepo.save(post);
        URI location =ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").buildAndExpand(post.getId()).
                toUri();
        return ResponseEntity.created(location).build();
    }


}
