package com.infytel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infytel.domain.SimOffers;

public interface SimOfferRepository extends JpaRepository<SimOffers, Long>{
}