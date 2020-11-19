package com.app.MaidBureauSystem.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.MaidBureauSystem.model.User;


public interface RegistrationRepository extends CrudRepository<User,Integer>{

	public User findByUserName(String userName);
	public User findByUserNameAndPassword(String userName,String password);
}
