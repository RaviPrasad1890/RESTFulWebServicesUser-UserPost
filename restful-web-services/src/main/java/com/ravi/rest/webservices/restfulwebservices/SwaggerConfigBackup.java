package com.ravi.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Configuration
//@EnableSwagger2
public class SwaggerConfigBackup {
/*
    //Overriding default values of var in ApiInfo class with my values
    //It will help me to put my own information and definition in Swagger API doc
    public static final Contact DEFAULT_CONTACT = new Contact("Ravi Kumar Prasad",
            "https://github.com/RaviPrasad1890", "ravi.prasad.1890@gmail.com");

    public static final ApiInfo DEFAULT=new ApiInfo("My Title","My Description",
            "My Version 1.0",
            "www.demo.com",DEFAULT_CONTACT, "Apache 2.0",
            "http://www.apache.org",new ArrayList());
    
    private static  Set<String> JSON_XML = new HashSet<>();



    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }


    //After adding this method with swagger dependency in pom, we will be
    //able to see swagger doc
    //Go to: localhost:8080/v2/api-docs
    //localhost:8080/swagger-ui.html
    @Bean
    public Docket api(){
        //return new Docket(DocumentationType.SWAGGER_2);//For default info

        //Configuring default info in swagger doc
        JSON_XML.add("application/JSON");
        JSON_XML.add("application/xml");

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).
                produces(JSON_XML).
                consumes(JSON_XML);

    }

    /*
    public ApiInfo(String title, String description, String version,
    String termsOfServiceUrl, Contact contact, String license,
    String licenseUrl, Collection<VendorExtension> vendorExtensions) {
        this.title = title;
        this.description = description;
        this.version = version;
        this.termsOfServiceUrl = termsOfServiceUrl;
        this.contact = contact;
        this.license = license;
        this.licenseUrl = licenseUrl;
        t
     */
}
