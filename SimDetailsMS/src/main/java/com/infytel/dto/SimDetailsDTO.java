package com.infytel.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.infytel.domain.SimDetails;

public class SimDetailsDTO {
	int simId;
	
	@Min(value=1000000000,message= "Service number should be 10-digit numeric value")
	@Max(value=9999999999L,message= "Service number should be 10-digit numeric value")
	long serviceNumber;
	
	@Min(value=1000000000000L,message= "Sim number should be 13-digit numeric value")
	@Max(value=9999999999999L,message= "Sim number should be 13-digit numeric value")
	long simNumber;
	String simStatus;
	
	public SimDetailsDTO() {};
	
	public SimDetailsDTO(int simId, long serviceNumber, long simNumber, String simStatus) {
		super();
		this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
	}
	
	@Override
	public String toString() {
		return "SimDetailsDTO [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
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
	
	public static SimDetails prepareSimDetailsEntity(SimDetailsDTO simDTO)
	{
		SimDetails simEntity = new SimDetails();
		simEntity.setServiceNumber(simDTO.getServiceNumber());
		simEntity.setSimId(simDTO.getSimId());
		simEntity.setSimNumber(simDTO.getSimNumber());
		simEntity.setSimStatus(simDTO.getSimStatus());
		return simEntity;
		
	}
}
