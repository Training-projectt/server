package com.diaspark.country.controllertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.diaspark.country.exception.InvalidDataException;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountryTest {

	  private String baseUrl = "http://localhost:8080";

	    private String endpointToThrowException = "/matchlist";

	    @Autowired
	    private TestRestTemplate testRestTemplate;

	    @Test(expected = InvalidDataException.class)
	    public void greetingShouldReturnDefaultMessage() throws Exception {
	       
	        assertThat(this.testRestTemplate.getForObject(baseUrl + endpointToThrowException,
	                String.class)).contains("Hello World");
	    }
}
 