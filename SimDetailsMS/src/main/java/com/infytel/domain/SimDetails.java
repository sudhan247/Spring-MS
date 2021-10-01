package com.infytel.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.infytel.dto.SimDetailsDTO;

@Entity
public class SimDetails {
	@Id
	private int simId;
	private long serviceNumber;
	private long simNumber;
	private String simStatus;
	
	public SimDetails() {};
	
	public SimDetails(int simId, long serviceNumber, long simNumber, String simStatus) {
		super();
		this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
	}
	
	@Override
	public String toString() {
		return "SimDetails [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + "]";
	}
	
	public int getSimId() {
		return simId;
	}

	public void setSimId(int simId) {
		this.simId = simId;
	}

	public long getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public long getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(long simNumber) {
		this.simNumber = simNumber;
	}

	public String getSimStatus() {
		return simStatus;
	}

	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	
	public static SimDetailsDTO prepareSimDetailsDTO(SimDetails sim)
	{
		SimDetailsDTO simDTO = new SimDetailsDTO();
		simDTO.setServiceNumber(sim.getServiceNumber());
		simDTO.setSimId(sim.getSimId());
		simDTO.setSimNumber(sim.getSimNumber());
		simDTO.setSimStatus(sim.getSimStatus());
		return simDTO;
		
	}
}
