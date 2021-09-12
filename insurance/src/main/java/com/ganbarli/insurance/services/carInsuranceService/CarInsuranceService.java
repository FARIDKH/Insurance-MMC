package com.ganbarli.insurance.services.carInsuranceService;


import com.ganbarli.insurance.repositories.carInsuranceRepository.CarInsuranceRepository;
import com.ganbarli.insurance.forms.CarInsuranceForm.CarInsuranceForm;
import com.ganbarli.insurance.models.car_insurance.CarInsurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarInsuranceService {


    @Autowired
    private CarInsuranceRepository carInsuranceRepository;

    public List<CarInsurance> getAllCarInsurances(){
        return carInsuranceRepository.findAll();
    }

    public CarInsurance getById(Integer id){
        return carInsuranceRepository.findById(id).get();
    }

    public CarInsurance create(CarInsuranceForm carInsuranceForm){
        CarInsurance carInsurance = new CarInsurance();
        carInsurance.setCar_engine_size(carInsuranceForm.getCar_engine_size());
        carInsurance.setCar_plate_number(carInsuranceForm.getCar_plate_number());
        carInsurance.setCar_registration_number(carInsuranceForm.getCar_registration_number());
        carInsuranceRepository.save(carInsurance);
        return carInsurance;
    }

    public boolean update(Integer carInsuranceID, CarInsuranceForm carInsuranceForm){
        Optional<CarInsurance> carInsuranceOptional = carInsuranceRepository.findById(carInsuranceID);
        CarInsurance carInsurance;
        boolean l = false;
        if(!carInsuranceOptional.isEmpty()){
            carInsurance = carInsuranceOptional.get();
            carInsurance.setCar_engine_size(carInsuranceForm.getCar_engine_size());
            carInsurance.setCar_plate_number(carInsuranceForm.getCar_plate_number());
            carInsurance.setCar_registration_number(carInsuranceForm.getCar_registration_number());
            carInsuranceRepository.save(carInsurance);
            l = true;
        }
        return l;
    }

    public boolean delete(Integer carInsuranceID){
        Optional<CarInsurance> carInsuranceOptional = carInsuranceRepository.findById(carInsuranceID);
        CarInsurance carInsurance;
        boolean l = false;
        if(!carInsuranceOptional.isEmpty()){
            carInsurance = carInsuranceOptional.get();
            carInsuranceRepository.delete(carInsurance);
            l = true;
        }
        return l;
    }

}
