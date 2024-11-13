package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.UserEntity;
import com.task.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("logIn")
public class UserController {
	@Autowired
    UserService userService;
	
	@PostMapping
	public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity userEntity) {
		UserEntity user= userService.create(userEntity);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAll(){
		List<UserEntity> list=userService.getAllUser();
		if(list != null) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> findById( @PathVariable("id") int id){
		UserEntity userEntity=userService.getById(id);
		if(userEntity != null)
		  return ResponseEntity.ok(userEntity);
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> update( @PathVariable("id") int id,@Valid @RequestBody UserEntity userEntity){
		UserEntity updated= userService.update(id, userEntity);	
		if(updated != null)
		   return ResponseEntity.ok(updated);
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id ){
		userService.delete(id);
		return ResponseEntity.ok("Deleted Successfully");
	}
	
}
