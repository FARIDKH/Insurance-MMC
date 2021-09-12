package com.ganbarli.insurance.repositories.propertyInsuranceRepository;

import com.ganbarli.insurance.models.property_insurance.PropertyInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyInsuranceRepository extends JpaRepository<PropertyInsurance, Long> {

}
