package com.infytel.service;

import java.util.List;
import com.infytel.domain.SimOffers;
import com.infytel.dto.SimOffersDTO;

public interface SimOffersService {
	public List<SimOffers> getallSimOffers();
	public void insertSimOffers(SimOffersDTO offer);
}
