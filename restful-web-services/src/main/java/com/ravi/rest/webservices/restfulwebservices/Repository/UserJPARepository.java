package com.ravi.rest.webservices.restfulwebservices.Repository;

import com.ravi.rest.webservices.restfulwebservices.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User,Integer> {

}
