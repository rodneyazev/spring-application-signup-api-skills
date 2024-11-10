package com.application.signup.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignupDTO(
		
		@NotNull(message="Username cannot be empty.")
		@Size(min=3, max=250, message="Username must be at least 3 characters")
		String username,
		
		@NotNull(message="Email cannot be empty.")
		@Email(message="Email must be a well-formed address")
		@Size(max=250)
		String email,
		
		@NotNull(message="Password cannot be empty.")
		@Pattern(regexp="^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,250}$",
				 message="Password must have at least: \n" +
						 "- Minimum 8 characters in length. \n" +
						 "- One lowercase letter. \n" +
						 "- One uppercase letter. \n" +
						 "- One numeric digit \n" +
						 "- One special character.")
		String password,
				
		@Size(max=250)
		String phone_number
		
) {}
