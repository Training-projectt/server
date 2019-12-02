package com.diaspark.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.diaspark.country.countrydto.RegisterUserDTO;
import com.diaspark.country.exception.InvalidDataException;
import com.diaspark.country.service.UserService;


@RestController

public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public RegisterUserDTO matchlist(@RequestBody RegisterUserDTO registerUserDTO) {
		if(registerUserDTO.getEmailId() == " " || registerUserDTO.getFirstName() == " " || registerUserDTO.getLastName() == "" || registerUserDTO.getMobileNumber() == null || registerUserDTO.getPassword() == "" || registerUserDTO.getUserName() == "" || registerUserDTO.getUserName() == null){
			throw new InvalidDataException(" there is missing argument in sign up. check whether all value passed or not");
		}
		return userService.registerUser(registerUserDTO);
	}
}
  