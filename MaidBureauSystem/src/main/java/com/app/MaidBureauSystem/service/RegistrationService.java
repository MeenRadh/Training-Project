package com.app.MaidBureauSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.MaidBureauSystem.model.User;
import com.app.MaidBureauSystem.repository.RegistrationRepository;


@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository regRepo;

	public User saveUser(User user) {
		return regRepo.save(user);
	}
	public User fetchUserByUserName(String userName) {
		return regRepo.findByUserName(userName);
	}
	public User fetchUserByUserNameAndPassword(String userName, String password) {
		return regRepo.findByUserNameAndPassword(userName,password);
	}
}
