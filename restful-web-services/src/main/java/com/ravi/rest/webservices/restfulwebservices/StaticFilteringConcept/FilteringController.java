package com.ravi.rest.webservices.restfulwebservices.StaticFilteringConcept;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean getSomeBean(){
        return new SomeBean("ValueOne","Value2","ValueThree");
    }
}
