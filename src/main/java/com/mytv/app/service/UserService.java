package com.mytv.app.service;

import java.util.List;

import com.mytv.app.model.User;


public interface UserService {

    User getUserById(int id);
    
    List<User> getUserByEmail(String email);
    
    List<User> getUserByfName(String fname);
    
    List<User> getUserBylName(String lname);

    List<User> getUserByService(String service);

}
