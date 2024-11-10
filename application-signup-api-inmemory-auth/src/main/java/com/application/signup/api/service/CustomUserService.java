package com.application.signup.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.application.signup.api.dto.SignupDTO;
import com.application.signup.api.exception.ResourceNotFoundException;
import com.application.signup.api.model.Roles;
import com.application.signup.api.model.RoleEnum;
import com.application.signup.api.model.Users;
import com.application.signup.api.repository.RoleRepository;
import com.application.signup.api.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Validated
@Transactional
public class CustomUserService {
	
	BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder();
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public ResponseEntity<String> signupCreateUser(@Valid SignupDTO signupDTO) {
		Optional<Roles> optionalRole = roleRepository.findByName(RoleEnum.USER);
		Users user = Users.builder()
			.email(signupDTO.email())
			.username(signupDTO.username())
			.password(passwordEnconder.encode(signupDTO.password()))
			.role(optionalRole.get())
			.phone_number("")
		.build();
		userRepository.save(user);
		log.info("{\"username\":\"{}\",\"email\":\"{}\"} user profile created.", signupDTO.username(), signupDTO.email()); 
		return ResponseEntity.status(HttpStatus.CREATED).body("User profile created.");
	}
	
	public List<Users> signupFindAll() {
		return userRepository.findAll();
	}
	
	public Optional<Users> signupFindById(long id) {
		return Optional.of(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User profile not found.")));
	}
	
	public ResponseEntity<String> signupUpdateUser(long id, @Valid SignupDTO signupDTO) {
		Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User profile not found."));
		String old_value = String.format( "{\"username\":\"%s\",\"email\":\"%s\"}", user.getUsername(), user.getEmail());
		user.setEmail(signupDTO.email());
		user.setUsername(signupDTO.username());
		user.setPassword(passwordEnconder.encode(signupDTO.password()));
		user.setPhone_number(signupDTO.phone_number());
		userRepository.save(user);
		log.info("{} user profile updated to {\"username\":\"{}\",\"email\":\"{}\"}.", old_value, signupDTO.username(), signupDTO.email()); 
		return ResponseEntity.status(HttpStatus.OK).body("User profile updated.");
	}
	
	public ResponseEntity<String> signupDeleteById(long id) {
		Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User profile not found."));
		userRepository.deleteById(id);
		log.info("{\"username\":\"{}\",\"email\":\"{}\"} user profile deleted.", user.getUsername(), user.getEmail());
		return ResponseEntity.status(HttpStatus.OK).body("User profile deleted.");
	}
	
}
