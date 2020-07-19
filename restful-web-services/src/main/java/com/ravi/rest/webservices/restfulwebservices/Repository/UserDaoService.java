package com.ravi.rest.webservices.restfulwebservices.Repository;

import com.ravi.rest.webservices.restfulwebservices.Model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users= new ArrayList<>();
    private static int userCount=3;

    static{
        users.add(new User(1,"Ravi",new Date()));
        users.add(new User(2,"Kumar",new Date()));
        users.add(new User(3,"Prasad",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        if(null==user.getId()){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findById(Integer id){
       for(User user:users){
           if(id==user.getId()){
               return user;
           }
        }
       return null;
    }

    public User deleteUserById(Integer id){
        Iterator<User> userItertaor= users.iterator();
        while(userItertaor.hasNext()){
            User user=userItertaor.next();
            if(id==user.getId()){
                userItertaor.remove();
                return user;
            }
        }
        return null;
    }
}
