package com.mytv.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytv.app.exception.ResourceNotFoundException;
import com.mytv.app.handler.UserHelper;
import com.mytv.app.model.User;
import com.mytv.app.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public User getUserById(int id) {

        Optional<User> userOpt = userRepository.getUserById(id);
        
        if (!userOpt.isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }
        
        return userOpt.get();
	}
	
	@Override
	public List<User> getUserByEmail(String email) {

		List<User> userList = userRepository.getUserByEmail(email);
		
		UserHelper.isListEmpty(userList);
        
		return userList;
	}
	
	@Override
	public List<User> getUserByfName(String fname) {

        List<User> userList = userRepository.getUserByfName(fname);
        
        UserHelper.isListEmpty(userList);
        
        return userList;
	}
	
	@Override
	public List<User> getUserBylName(String lname) {

        List<User> userList = userRepository.getUserBylName(lname);
        
        UserHelper.isListEmpty(userList);
        
        return userList;
	}
	
	@Override
	public List<User> getUserByService(String service) {

        List<User> userList = userRepository.getUserByService(service);
        
        UserHelper.isListEmpty(userList);
        
        return userList;
	}
}
