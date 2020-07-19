package com.ravi.rest.webservices.restfulwebservices.Repository;

import com.ravi.rest.webservices.restfulwebservices.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJPARepository  extends JpaRepository<Post,Integer> {

    List<Post> findByDescription(String description);
}
