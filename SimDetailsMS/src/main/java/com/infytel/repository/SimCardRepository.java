package com.infytel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.infytel.domain.SimDetails;

public interface SimCardRepository extends JpaRepository<SimDetails, Long>{
	@Transactional
	@Modifying
	@Query(value = "update  sim_details set sim_status = ? " + " where sim_id = ?", nativeQuery = true)
	void statusUpdate(String status,int simId);

}