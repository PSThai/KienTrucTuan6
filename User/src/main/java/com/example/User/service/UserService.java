package com.example.User.service;

import java.util.List;

import com.example.User.entity.User;

public interface UserService {
	
	public List<User> findAllUser();

	public void addUser(User user);
	
}
