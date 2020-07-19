package com.ravi.rest.webservices.restfulwebservices.Controller;

import com.ravi.rest.webservices.restfulwebservices.Model.Post;
import com.ravi.rest.webservices.restfulwebservices.Repository.PostJPARepository;
import com.ravi.rest.webservices.restfulwebservices.Repository.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostJPARepository postRepo;

    @GetMapping("/post")
    public List<Post> getAllPost(){
        return postRepo.findAll();

    }

    @GetMapping("/checknull/post")
    public List<Post> nullPost(){
        return postRepo.findByDescription(null);

    }
}
