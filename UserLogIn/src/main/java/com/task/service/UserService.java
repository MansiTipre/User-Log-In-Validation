package com.task.service;

import java.util.List;

import com.task.model.UserEntity;

public interface UserService {

	public UserEntity create(UserEntity userEntity);

	public List<UserEntity> getAllUser();

	public UserEntity getById(int id);

	public UserEntity update(int id, UserEntity userEntity);

	public void delete(int id);

}
