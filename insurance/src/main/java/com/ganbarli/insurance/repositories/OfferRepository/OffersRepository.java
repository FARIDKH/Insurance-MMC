package com.ganbarli.insurance.repositories.OfferRepository;

import com.ganbarli.insurance.models.offer.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersRepository extends JpaRepository<Offer, Long> {
}
