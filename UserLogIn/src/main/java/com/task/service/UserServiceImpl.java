package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.model.UserEntity;
import com.task.repository.UserRepo;
import com.task.service.exceptions.DuplicateEntryException;
import com.task.service.exceptions.ResourseNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserEntity create(UserEntity userEntity) {
		try {
//			UserEntity created= userRepo.save(userEntity);
//			return created;
			
			return userRepo.save(userEntity);
			
		}catch (DuplicateEntryException e) {
			throw new DuplicateEntryException("Email already exists...");
		}
		
	}

	@Override
	public List<UserEntity> getAllUser() {
		List<UserEntity> getAll= userRepo.findAll();
		return getAll;
	}

	@Override
	public UserEntity getById(int id) {
	/*	UserEntity user = userRepo.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("User Dose not exists with ID "+id)
				);
		return user;
	*/
		return userRepo.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("User Dose not exists with ID "+id)
				);
	}

	@Override
	public UserEntity update(int id, UserEntity userEntity) {
		UserEntity user = userRepo.findById(id).orElseThrow(
				()-> new ResourseNotFoundException("User dose not exists with ID "+id)
				);
		user.setEmail(userEntity.getEmail());
		user.setName(userEntity.getName());
		user.setPassword(userEntity.getPassword());
		
//		UserEntity updated= userRepo.save(user);
//		return updated;
		
		try {
			return userRepo.save(user);
		}catch (DuplicateEntryException e) {
			throw new DuplicateEntryException("Email already exists...");
		}
	}

	@Override
	public void delete(int id) {
		UserEntity user= userRepo.findById(id).orElseThrow(
				()-> new ResourseNotFoundException("User dose not exists with ID "+id)
				);
		
		userRepo.deleteById(id);
	}
      
}
