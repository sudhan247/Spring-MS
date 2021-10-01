package com.infytel.dto;

import com.infytel.domain.SimOffers;

public class SimOffersDTO {
	int offerId;	
	int callQty;
	int cost;
	int dataQty;
	int duration;
	String offerName;
	int simId;
	
	public SimOffersDTO() {};
	
	public SimOffersDTO(int offerId, int callQty, int cost, int dataQty, int duration, String offerName, int simId) {
		super();
		this.offerId = offerId;
		this.callQty = callQty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerName = offerName;
		this.simId = simId;
	}
	
	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getCallQty() {
		return callQty;
	}

	public void setCallQty(int callQty) {
		this.callQty = callQty;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDataQty() {
		return dataQty;
	}

	public void setDataQty(int dataQty) {
		this.dataQty = dataQty;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public int getSimId() {
		return simId;
	}

	public void setSimId(int simId) {
		this.simId = simId;
	}
	
	@Override
	public String toString() {
		return "SimOffersDTO [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + ", simId=" + simId + "]";
	}
	
	public static SimOffers prepareSimOffersEntity(SimOffersDTO simoffer) {
		SimOffers simentity = new SimOffers();
		simentity.setOfferId(simoffer.getOfferId());
		simentity.setCallQty(simoffer.getCallQty());
		simentity.setCost(simoffer.getCost());
		simentity.setDataQty(simoffer.getDataQty());
		simentity.setDuration(simoffer.getDuration());
		simentity.setOfferName(simoffer.getOfferName());
		simentity.setSimId(simoffer.getSimId());
		return simentity;
	}
}
