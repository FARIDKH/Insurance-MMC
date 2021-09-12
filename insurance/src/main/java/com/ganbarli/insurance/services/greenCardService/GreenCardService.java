package com.ganbarli.insurance.services.greenCardService;


import com.ganbarli.insurance.forms.GreenCardForm.GreenCardForm;
import com.ganbarli.insurance.models.green_card_insurance.GreenCardInsurance;
import com.ganbarli.insurance.repositories.GreenCardRepository.GreenCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenCardService {

    @Autowired
    private GreenCardRepository greenCardRepository;

    public List<GreenCardInsurance> getAll(){
        return greenCardRepository.findAll();
    }

    public GreenCardInsurance getByID(Long greenCardID){
        return greenCardRepository.findById(greenCardID).get();
    }

    public GreenCardInsurance create(GreenCardForm greenCardForm){
        GreenCardInsurance greenCardInsurance = new GreenCardInsurance();
        greenCardInsurance.setCar_plate_number(greenCardForm.getCar_plate_number());
        greenCardInsurance.setCar_registration_number(greenCardForm.getCar_registration_number());
        greenCardInsurance.setContact_person(greenCardForm.getContact_person());
        greenCardInsurance.setDirection(greenCardForm.getDirection());
        greenCardInsurance.setDuration(greenCardForm.getDuration());
        return greenCardRepository.save(greenCardInsurance);
    }

    public GreenCardInsurance update(Long greenCardID, GreenCardForm greenCardForm){
        GreenCardInsurance greenCardInsurance = greenCardRepository.getById(greenCardID);
        greenCardInsurance.setCar_plate_number(greenCardForm.getCar_plate_number());
        greenCardInsurance.setCar_registration_number(greenCardForm.getCar_registration_number());
        greenCardInsurance.setContact_person(greenCardForm.getContact_person());
        greenCardInsurance.setDirection(greenCardForm.getDirection());
        greenCardInsurance.setDuration(greenCardForm.getDuration());
        return greenCardRepository.save(greenCardInsurance);
    }

    public boolean delete(Long greenCardID){
        GreenCardInsurance greenCardInsurance = greenCardRepository.getById(greenCardID);
        if(greenCardInsurance == null){
            return false;
        }
        greenCardRepository.delete(greenCardInsurance);
        return true;
    }

}
