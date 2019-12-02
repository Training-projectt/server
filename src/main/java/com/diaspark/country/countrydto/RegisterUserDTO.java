package com.diaspark.country.countrydto;

import javax.validation.constraints.NotNull;

public class RegisterUserDTO {
	 @NotNull(message = "first Name can not null")
	private String firstName;
	
	 @NotNull(message = "lastName can not null")
	private String lastName;
	
	 @NotNull(message = "userName can not null")
	private String userName;
	 
	 @NotNull(message = "password can not null")
	private String password;
	 @NotNull(message = "emailId can not null")
	private String emailId;
	 @NotNull(message = "mobileNumber can not null")
	private Long mobileNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
