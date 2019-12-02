package com.diaspark.country.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.diaspark.country.countrydto.RegisterUserDTO;
import com.diaspark.country.entity.UserEntity;
import com.diaspark.country.exception.DuplicateDataException;
import com.diaspark.country.mapper.EntityToDTOMapper;
import com.diaspark.country.service.UserService;
import com.diaspark.country.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	  @Autowired
	  private UsersRepository usersRepository;
	
	  
	  @Autowired
	  private EntityToDTOMapper entityToDTOMapper;
	  
	  @Autowired
		private PasswordEncoder bcryptEncoder;
	@Override
	public RegisterUserDTO registerUser(RegisterUserDTO registerUserDTO) {
	
		UserEntity savedUser = new UserEntity();
		UserEntity userDAO = new UserEntity();
		userDAO.setFirstName(registerUserDTO.getFirstName());
		userDAO.setLastName(registerUserDTO.getLastName());
		userDAO.setUserName(registerUserDTO.getUserName());
		userDAO.setEmailId(registerUserDTO.getEmailId());
		userDAO.setMobileNumber(registerUserDTO.getMobileNumber());
		userDAO.setPassword(bcryptEncoder.encode(registerUserDTO.getPassword()));
	try{
		savedUser =  usersRepository.save(userDAO);
	} 
	catch (Exception e) {

		throw new DuplicateDataException("this username is already exist : " + registerUserDTO.getUserName());
	}
		RegisterUserDTO RegisterUserDTO = entityToDTOMapper.buildRegisterUserDTO(savedUser);
		
		return RegisterUserDTO;
	}

}
