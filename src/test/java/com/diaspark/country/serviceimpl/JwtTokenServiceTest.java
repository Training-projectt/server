package com.diaspark.country.serviceimpl;

import org.junit.*;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.diaspark.country.entity.UserEntity;
import com.diaspark.country.repository.UsersRepository;

@RunWith(MockitoJUnitRunner.class)

public class JwtTokenServiceTest {

	@Mock
	private UsersRepository usersRepository;

	@Before
	public void setUp() throws Exception {  
		MockitoAnnotations.initMocks(this);
	}
 
	@Test
	public void userRepoTest() {
		String userName = "anoop2.jain";
		UserEntity mockUser = new UserEntity();
		mockUser.setUserName("anoop2.jain");
		mockUser.setPassword("12345678");
		mockUser.setEmailId("anoop");
		mockUser.setFirstName("anoop");
		mockUser.setLastName("jain");
		mockUser.setId((long) 1);
		Mockito.when(usersRepository.findUserDAOByUserName(userName)).thenReturn(mockUser);
	}

}
