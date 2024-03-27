package com.example.User.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.entity.User;
import com.example.User.responsitory.UserRespository;

@Service
public class UserServiceIml implements UserService {
	@Autowired
	UserRespository userRespository;
	
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<>();
		users = userRespository.findAll();
		System.out.println(users);
		return users;

	}
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRespository.save(user);
	} 
}
