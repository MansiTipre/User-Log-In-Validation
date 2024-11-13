package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.UserEntity;


public interface UserRepo extends JpaRepository<UserEntity,Integer > {
    
}