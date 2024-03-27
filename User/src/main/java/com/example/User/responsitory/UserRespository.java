package com.example.User.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User.entity.User;

public interface UserRespository extends JpaRepository<User, Integer>{
	
}
