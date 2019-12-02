package com.diaspark.country.service;

import java.util.List;

import com.diaspark.country.countrydto.MatchDetailsDTO;
import com.diaspark.country.countrydto.MatchScheduleDTO;
import com.diaspark.country.entity.ScheduleEntity;

public interface MatchService {
	MatchScheduleDTO addMatchlist(MatchScheduleDTO matchScheduleDTO);

	List<ScheduleEntity>  deleteOneRecord(Long id);
	 MatchScheduleDTO updateMatchSchedule(Long id,String countryName,String matchType,String matchDate,String matchStatus);
	
	 List<MatchScheduleDTO> retrieveallMatchlDetails(int pageNumber,MatchDetailsDTO matchDetailsDTO);
}
