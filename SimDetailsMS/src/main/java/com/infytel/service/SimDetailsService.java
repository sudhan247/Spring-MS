package com.infytel.service;

import java.util.List;
import com.infytel.domain.SimDetails;
import com.infytel.dto.SimDetailsDTO;

public interface SimDetailsService {
	public List<SimDetails> getallSimDetails();
	public void insertSimDetails(SimDetailsDTO sim);
	public void statusUpdate(String status,int simId);
}
