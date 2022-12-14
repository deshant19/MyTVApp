package com.mytv.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytv.app.exception.ResourceNotFoundException;
import com.mytv.app.handler.UserHelper;
import com.mytv.app.model.User;
import com.mytv.app.service.UserService;


@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id") int id) {
    	LOGGER.info("getUserById method started.");
    	
    	if (!UserHelper.isPositiveInt(id)) {
			return new ResponseEntity<String>("User id should be a positive integer.", HttpStatus.BAD_REQUEST);
        }
    	
        User user = userService.getUserById(id);
        LOGGER.info("getUserById method executed.");
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/email/{emailId}")
    public ResponseEntity<List<User>> getUserByEmail(@PathVariable(name = "emailId") String email) {
    	LOGGER.info("getUserByEmail method started.");
    	if (UserHelper.isNullOrBlank(email)) {
			throw new ResourceNotFoundException("User email must not be null.");
        }
    	
    	List<User> users = userService.getUserByEmail(email);
    	LOGGER.info("getUserByEmail method executed.");
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/fname/{fname}")
    public ResponseEntity<List<User>> getUserByfName(@PathVariable(name = "fname") String fname) {
    	LOGGER.info("getUserByfName method started.");
    	if (UserHelper.isNullOrBlank(fname)) {
			throw new ResourceNotFoundException("User first name must not be null.");
        }
    	
        List<User> users = userService.getUserByfName(fname);
        LOGGER.info("getUserByfName method executed.");
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/lname/{lname}")
    public ResponseEntity<List<User>> getUserBylName(@PathVariable(name = "lname") String lname) {
    	LOGGER.info("getUserBylName method started.");
    	if (UserHelper.isNullOrBlank(lname)) {
			throw new ResourceNotFoundException("User last name must not be null.");
        }
    	
        List<User> users = userService.getUserBylName(lname);
        LOGGER.info("getUserBylName method executed.");
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/service/{service}")
    public ResponseEntity<List<User>> getUserByService(@PathVariable(name = "service") String service) {
    	LOGGER.info("getUserByService method started.");
    	if (UserHelper.isNullOrBlank(service)) {
			throw new ResourceNotFoundException("Service parameter must not be null.");
        }
    	
        List<User> users = userService.getUserByService(service);
        LOGGER.info("getUserByService method executed.");
        return ResponseEntity.ok(users);
    }
    
    @RequestMapping (value = "/**", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<String> wrongPathResponseHandler() {
	    return new ResponseEntity<String>("Bad request.", HttpStatus.BAD_REQUEST);
	}

}
