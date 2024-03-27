package com.example.Product.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Product.entity.User;

public interface UserResponsitory extends JpaRepository<User, Integer>{

}
