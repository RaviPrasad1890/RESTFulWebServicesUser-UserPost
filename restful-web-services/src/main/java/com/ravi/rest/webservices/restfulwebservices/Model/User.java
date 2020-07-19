package com.ravi.rest.webservices.restfulwebservices.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

//Annotation related to swagger, for giving user desc in swagger api doc
@ApiModel(description = "My User Description")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Size(min = 2)
    @ApiModelProperty(notes="Name should be min of 2 characters, desc added for swagger doc")
    private String name;

    @Past
    @ApiModelProperty(notes="Date can't be in future, desc added for swagger doc")
    private Date birthDate;

    //MappedBy will ensure to create relationship column in post for user
    //we dont want to create relationship column in both table
    //in this case it should be created in Post table for user
    //mappedBy="value" where value is name of filed or column in Post
    //One User with many post
    @OneToMany(mappedBy="user")
    private List<Post> posts;

    public User(){

    }
    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
