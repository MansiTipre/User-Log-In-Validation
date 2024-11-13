package com.task.model;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserLogIn")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
       private int id;
	
	@NotBlank(message = "Name should not be blank")
       private String name;
	
	@NotBlank(message = "Name should not be blank")
	@Email(message = "Enter a valid email...")
	@Column(unique = true)
       private String email;
	
	@NotBlank(message = "Password is required!")
	@Size(min = 5,message = "Password must contain atleast 5 character ")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=]).{5,}",
	         message = "Password must contain atleast one digit, one uppercase,"
	         		+ "one lowercase and one speacial character")
       private String password;
}
