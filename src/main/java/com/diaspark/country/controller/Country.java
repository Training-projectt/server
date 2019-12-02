package com.diaspark.country.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.diaspark.country.countrydto.MatchDetailsDTO;
import com.diaspark.country.countrydto.MatchScheduleDTO;
import com.diaspark.country.entity.ScheduleEntity;
import com.diaspark.country.exception.InvalidDataException;
import com.diaspark.country.service.MatchService;



@RestController

public class Country {

	@Autowired 
	private MatchService service;
	
	 


	/* adding New data */ 

	@PostMapping("/matchlist")
	public MatchScheduleDTO addMatchlist(@RequestBody MatchScheduleDTO matchScheduleDTO) {
		if(matchScheduleDTO.getCountryName() == "" || matchScheduleDTO.getMatchDate() == "" || matchScheduleDTO.getMatchStatus() == "" || matchScheduleDTO.getMatchType() == ""){
			throw new InvalidDataException(" some value is missing ");
		}
		if(matchScheduleDTO.getCountryName() == null || matchScheduleDTO.getMatchDate() == null || matchScheduleDTO.getMatchStatus() == null || matchScheduleDTO.getMatchType() == null){
			throw new InvalidDataException("  missing argument");
		}
		return service.addMatchlist(matchScheduleDTO);
	}
	
/*	http://localhost:8080/match1?pageNumber=10
 * fetch all data it take pageno. and a dto in body
*/	
	
	@PostMapping("/match")
	public List<MatchScheduleDTO> matchSchedulelist(@RequestParam(required = true) int pageNumber,@RequestBody MatchDetailsDTO matchDetailsDTO) {
		

		return service.retrieveallMatchlDetails(pageNumber, matchDetailsDTO);
	}


	/*
	 * delete one row of data by id 
	 * http://localhost:8080/removerow/28?pageNumber=10
	 */
	@DeleteMapping("removerow/{id}")
	public List<ScheduleEntity>  deleteOneRecord(@PathVariable("id") Long id
			) {
		return service.deleteOneRecord(id);
	}



	/*
	 * http://localhost:8080/update/10?countryName=USA&matchType=test&matchDate=
	 * 20/12/2021
	 * http://localhost:8080/update/10?countryName=USA&matchType=test&matchDate=
	 * http://localhost:8080/update/10?countryName=USA&matchType=&matchDate=20/
	 * 12/2021
	 */ @PutMapping("/update/{id}")
	public MatchScheduleDTO updateMatchSchedule(@PathVariable("id") Long id,
			@RequestParam(value = "countryName", required = false) String countryName,
			@RequestParam(value = "matchType", required = false) String matchType,
			@RequestParam(value = "matchDate", required = false) String matchDate,
			@RequestParam(value = "matchStatus", required = false) String matchStatus) {
	
		return service.updateMatchSchedule(id, countryName, matchType, matchDate, matchStatus);
	}

 


}
