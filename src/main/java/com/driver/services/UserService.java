package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setFirstName("test");
        user.setLastName("test");

        userRepository3.save(user);
        return user;
    }

    public void deleteUser(int userId){
        try {
            User user = userRepository3.findById(userId).get();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password){
        User user = null;
        try {
            user = userRepository3.findById(id).get();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        user.setPassword(password);
        userRepository3.save(user);
        return user;
    }
}
