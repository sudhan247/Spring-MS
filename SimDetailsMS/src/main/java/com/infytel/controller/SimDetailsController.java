package com.infytel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import javax.validation.Valid;
import com.infytel.domain.SimDetails;
import com.infytel.domain.SimOffers;
import com.infytel.dto.ErrorMessage;
import com.infytel.dto.SimDetailsDTO;
import com.infytel.dto.SimOffersDTO;
import com.infytel.service.SimDetailsService;
import com.infytel.service.SimOffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@EnableAutoConfiguration
@RibbonClient(name="custribbon")
@RequestMapping("/simdetails")
public class SimDetailsController {
		@Autowired
		SimDetailsService service;
		
		@Autowired
		SimOffersService offerservice;
		
		
//		@GetMapping
//		public String feedSimDetails()
//		{
//			SimDetailsDTO sim1 = new SimDetailsDTO(1,1234567891L,1234567891234L,"active");
//			SimDetailsDTO sim2 = new SimDetailsDTO(2,1234567892L,1234567891235L,"inactive");
//			service.insertSimDetails(sim1);
//			service.insertSimDetails(sim2);
//			return "SimDetails feed successful";
//		}
		
//		@GetMapping
//		public String feedSimOffers()
//		{
//			SimOffersDTO sim1 = new SimOffersDTO(1,100,100,120,10,"Free calls and data",1);
//			SimOffersDTO sim2 = new SimOffersDTO(2,150,50,100,15,"Free calls",2);
//			offerservice.insertSimOffers(sim1);
//			offerservice.insertSimOffers(sim2);
//			return "SimOffers feed successful";
//		}
//		
		
		@PostMapping(consumes="application/json")
		public ResponseEntity<Object> checksimdetails(@Valid @RequestBody SimDetailsDTO simDTO, Errors errors){
			if (errors.hasErrors()) {
				// collecting the validation errors of all fields together in a String delimited
				// by commas
				String response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
						.collect(Collectors.joining(","));
				ErrorMessage error = new ErrorMessage();
				error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
				error.setMessage(response);
				return ResponseEntity.ok(error);
			} 
			else {
				for(SimDetails each_sim_info :service.getallSimDetails()) {
					if (each_sim_info.getServiceNumber() == simDTO.getServiceNumber() && each_sim_info.getSimNumber() == simDTO.getSimNumber()) {
						if(each_sim_info.getSimStatus().equals("active")) {
							return ResponseEntity.ok("SIM already active");
						}
						else {
							
							for(SimOffers each_offer_info : offerservice.getallSimOffers()) {
								if(each_offer_info.getSimId() == each_sim_info.getSimId())
									return ResponseEntity.ok(each_offer_info.toString());
							}
							
						}
					}
				}
				return ResponseEntity.ok("Invalid details, please check again SIM number/Service number!");
			}
			
		}
}
