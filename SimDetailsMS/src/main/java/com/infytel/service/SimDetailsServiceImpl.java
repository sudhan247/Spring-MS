package com.infytel.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infytel.domain.SimDetails;
import com.infytel.dto.SimDetailsDTO;
import com.infytel.repository.SimCardRepository;

@Service("SimDetailsService")
public class SimDetailsServiceImpl implements SimDetailsService{
	
	@Autowired
	private SimCardRepository repository;
	
	@Override
	public List<SimDetails> getallSimDetails(){
		return repository.findAll();
	}

	@Override
	public void insertSimDetails(SimDetailsDTO sim) {
		repository.saveAndFlush(SimDetailsDTO.prepareSimDetailsEntity(sim));
		
	}
	@Override
	public void statusUpdate(String status,int simId) {
		repository.statusUpdate(status, simId);
	}
}
