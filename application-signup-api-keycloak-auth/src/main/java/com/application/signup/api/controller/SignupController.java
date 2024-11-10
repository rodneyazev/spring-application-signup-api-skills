package com.application.signup.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.signup.api.dto.SignupDTO;
import com.application.signup.api.model.Users;
import com.application.signup.api.service.CustomUserService;

@RestController
@RequestMapping("/api/signup/users")
public class SignupController {
	
	@Autowired
	CustomUserService userService;
	
	@PostMapping
	ResponseEntity<String> createUser(@RequestBody SignupDTO signupDTO) {
		return userService.signupCreateUser(signupDTO);
	}
	
	@GetMapping("/{id}")
	Optional<Users> findById(@PathVariable long id) {
		return userService.signupFindById(id);
	}
	
	@GetMapping
	List<Users> findAll() {
		return userService.signupFindAll();
	}
	
	@PutMapping("/{id}")
	ResponseEntity<String> update(@PathVariable long id, @RequestBody SignupDTO signupDTO) {
		return userService.signupUpdateUser(id, signupDTO);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteUser(@PathVariable long id) {
		return userService.signupDeleteById(id);
	}
	
}
