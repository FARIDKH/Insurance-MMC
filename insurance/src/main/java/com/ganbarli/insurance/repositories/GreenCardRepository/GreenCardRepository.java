package com.ganbarli.insurance.repositories.GreenCardRepository;

import com.ganbarli.insurance.models.green_card_insurance.GreenCardInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreenCardRepository extends JpaRepository<GreenCardInsurance, Long> {
}
