package com.ganbarli.insurance.repositories.carInsuranceRepository;

import com.ganbarli.insurance.models.car_insurance.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInsuranceRepository extends JpaRepository<CarInsurance, Integer> {


}
