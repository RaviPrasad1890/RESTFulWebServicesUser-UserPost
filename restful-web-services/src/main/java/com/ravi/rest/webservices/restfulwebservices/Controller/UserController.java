package com.ravi.rest.webservices.restfulwebservices.Controller;

import com.ravi.rest.webservices.restfulwebservices.Exception.UserNotFoundException;
import com.ravi.rest.webservices.restfulwebservices.Model.User;
import com.ravi.rest.webservices.restfulwebservices.Repository.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;


import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userdaoService;

    @GetMapping(path="/user")
    public List<User> getAllUser(){
        return userdaoService.findAll();
    }

    /*
    @GetMapping(path="/user/{id}")
    public User getUser(@PathVariable Integer id){
        User user=userdaoService.findById(id);
        if(null==user){
            throw new UserNotFoundException("UserId "+id+" Doesn't Exist");
        }
        return userdaoService.findById(id);
    }
    */

    //HATEOS: Hypertext/Hypermedia As The Engine of Application State
    //Same above normal get method which used to return user as a response of specific if
    //Now in addition to that suppose I want to send a link in response,
    // of resource from where we can get all users information
    //,i.e.,/user
    @GetMapping("/user/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        User user = userdaoService.findById(id);
        if (user== null)
            throw new UserNotFoundException("id-" + id);

        EntityModel<User> model = new EntityModel<>(user);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.
                linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUser());
        model.add(linkTo.withRel("all-users"));
        return model;
    }

    /*
    ResponseEntity: ResponseEntity represents an HTTP response, including headers, body, and status.
    While @ResponseBody puts the return value into the body of the response, ResponseEntity also allows us to add headers and status code.
     */
    @PostMapping(path="/user")
    public ResponseEntity<Object> postUser(@Valid @RequestBody User user){
        User savedUser=userdaoService.saveUser(user);
        //To get URI of resource which was build
        ///user/{id}
        URI location =ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").buildAndExpand(savedUser.getId()).
                toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        User user=userdaoService.deleteUserById(id);
        if(null==user){
            throw new UserNotFoundException("UserId "+id+" Doesn't Exist");
        }
    }

}
