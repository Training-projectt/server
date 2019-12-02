package com.diaspark.country.serviceimpl;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;




import com.diaspark.country.countrydto.RegisterUserDTO;
import com.diaspark.country.entity.UserEntity;
import com.diaspark.country.mapper.EntityToDTOMapper;
import com.diaspark.country.repository.UsersRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceInplTest {
	
	 @InjectMocks
	  private UserServiceImpl userServiceImpl;
	
	@Mock
	 private UsersRepository usersRepository;
	
	  @Mock
	 private EntityToDTOMapper entityToDTOMapper;
	
	  @Mock 
	  private PasswordEncoder bcryptEncoder; 
	
	  @Before
	    public void setUp() throws Exception {
	         MockitoAnnotations.initMocks(this);
	    }
	@Test
	public void registerationTest(){
		UserEntity userDAO = new UserEntity();
		userDAO.setFirstName("anoop");
		userDAO.setLastName("jain");
		userDAO.setUserName("anoop.jain");
		userDAO.setPassword("12345678");
		userDAO.setEmailId("anoopjain@gmail.com");
		userDAO.setMobileNumber((long) 1234567890);
		
		RegisterUserDTO registerUserDTO = new RegisterUserDTO();
		registerUserDTO.setEmailId("anoopjain@gmail.com");
		registerUserDTO.setFirstName("anoop");
		registerUserDTO.setLastName("jain");
		registerUserDTO.setMobileNumber((long) 743844333);
		registerUserDTO.setPassword("12345678");
		registerUserDTO.setUserName("anoop.jain");
		
	

		
		Mockito.when(usersRepository.save(userDAO)).thenReturn(userDAO);
	
		Mockito.when(entityToDTOMapper.buildRegisterUserDTO(userDAO)).thenReturn(registerUserDTO);
	Mockito.when(userServiceImpl.registerUser(registerUserDTO)).thenReturn(registerUserDTO);
	}

}
