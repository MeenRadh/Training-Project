package com.app.MaidBureauSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.MaidBureauSystem.model.User;
import com.app.MaidBureauSystem.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService regService;
	@PostMapping("/registration")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception  {
		String tempUserName = user.getUserName();
		if(tempUserName != null & !"".equals(tempUserName)) {
			User userObj =  regService.fetchUserByUserName(tempUserName);
			if(userObj != null) {
				throw new Exception("User with " +tempUserName+ " already exists");
			}
		}
		User userObj = null;
		userObj = regService.saveUser(user);
		return userObj;
	}
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempUserName = user.getUserName();
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempUserName != null && tempPassword != null){
			userObj = regService.fetchUserByUserNameAndPassword(tempUserName, tempPassword);
		}
		if(userObj == null) {
			throw new Exception("Invalid Credentials");
		}
		return userObj;

	}
}
