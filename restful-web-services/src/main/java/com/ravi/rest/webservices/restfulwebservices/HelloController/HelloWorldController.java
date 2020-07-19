package com.ravi.rest.webservices.restfulwebservices.HelloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path="/helloworld")
    public String helloWorld(){
        return "HelloWorld!";
    }

    @GetMapping(path="/helloworld-bean")
    public HelloWorld getBean(){
        return new HelloWorld("Hi There!!","Whats's Up?");
    }

    @GetMapping(path="/helloworld-bean/pathvariabledemo/{name}")
    public HelloWorld getBeanWithPathVar(@PathVariable String name){
        return new HelloWorld(String.format("Heloooo %s",name),(",Whats Up!"));
    }
}
