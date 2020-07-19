package com.ravi.rest.webservices.restfulwebservices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    //Type 1: URI Versioning
    /*
    Pro: Easy, API Documentation is simple, caching can be implemented, Can be called simply from browser
    Cons: URI Pollution
    * */
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Ravi Prasad");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Ravi", "Prasad"));
    }


//    Type 2: Parameter Versioning
/*
Pro: API Documentation is simple, caching can be implemented, Can be called simply from browser
/persion/param?version-1
Con: Uri Pollution
 * */
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Ravi Prasad");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Ravi", "Prasad"));
    }


    //Type 3:(Custom) Header Versioning
    /*
    Need some plug in or postman/soapui to call by including header, caching can't be implemented, Uri pollution prevented
    * */
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Ravi Prasad");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Ravi", "Prasad"));
    }

    //Type 4: Media Type Versioning, Content Negotiation, Mime type, Accept headers
    /*
    Need some plug in or postman/soapui to call by including header, caching can't be implemented, Uri pollution prevented
    @GetMapping(value = "/person/produces", produces = "application/ravi.company.app-v1+json")
    */

    public PersonV1 producesV1() {
        return new PersonV1("Ravi Prasad");
    }

    @GetMapping(value = "/person/produces", produces = "application/ravi.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Ravi", "Prasad"));
    }
}
