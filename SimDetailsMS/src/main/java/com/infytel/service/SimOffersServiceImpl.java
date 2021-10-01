package com.infytel.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.domain.SimOffers;
import com.infytel.dto.SimOffersDTO;
import com.infytel.repository.SimOfferRepository;

@Service("SimOffersService")
public class SimOffersServiceImpl implements SimOffersService{
	
	@Autowired
	private SimOfferRepository repository;
	
	@Override
	public List<SimOffers> getallSimOffers(){
		return repository.findAll();
	}
	
	@Override
	public void insertSimOffers(SimOffersDTO offer) {
		repository.saveAndFlush(SimOffersDTO.prepareSimOffersEntity(offer));
	}

}
