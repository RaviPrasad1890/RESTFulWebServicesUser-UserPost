package com.ravi.rest.webservices.restfulwebservices.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    /*
    Note:
    * Don't print user in post while printing object,
    * otherwise post will print user than user will print post and so on
    * */
    //Many Post for one user
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
