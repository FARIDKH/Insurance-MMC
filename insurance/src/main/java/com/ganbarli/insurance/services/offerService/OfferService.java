package com.ganbarli.insurance.services.offerService;


import com.ganbarli.insurance.forms.OfferForm.OfferForm;
import com.ganbarli.insurance.models.car_insurance.CarInsurance;
import com.ganbarli.insurance.models.client.Client;
import com.ganbarli.insurance.models.green_card_insurance.GreenCardInsurance;
import com.ganbarli.insurance.models.offer.Offer;
import com.ganbarli.insurance.models.property_insurance.PropertyInsurance;
import com.ganbarli.insurance.models.property_liability_insurance.PropertyLiabilityInsurance;
import com.ganbarli.insurance.repositories.OfferRepository.OffersRepository;
import com.ganbarli.insurance.repositories.clientRepository.ClientRepository;
import com.ganbarli.insurance.services.carInsuranceService.CarInsuranceService;
import com.ganbarli.insurance.services.greenCardService.GreenCardService;
import com.ganbarli.insurance.services.propertyInsuranceService.PropertyInsuranceService;
import com.ganbarli.insurance.services.propertyLiabilityService.PropertyLiabilityInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OfferService {


    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarInsuranceService carInsuranceService;

    @Autowired
    private GreenCardService greenCardService;

    @Autowired
    private PropertyInsuranceService propertyInsuranceService;

    @Autowired
    private PropertyLiabilityInsuranceService propertyLiabilityInsuranceService;

    public Offer createOffer(OfferForm offerForm){
        Offer offer = new Offer();
        Client client = clientRepository.findById(offerForm.getClient_id()).get();
        System.out.println(client.toString());
        offer.setClients(client);
        offer.setInsurance_company(offerForm.getInsurance_company());
        offer.setDate_offered(new Date(System.currentTimeMillis()));
        offer.setDate_signed(null);
        offer.setIs_active(false);
        offer.setDetails("Lorem ipsum dolor sit amet, ");

        if(offerForm.getCar_insurance_id() != null){
            CarInsurance carInsurance = carInsuranceService.getById(offerForm.getCar_insurance_id());
            offer.setCarInsurance(carInsurance);
        } else if(offerForm.getGreen_card_insurance_id() != null){
            GreenCardInsurance greenCardInsurance = greenCardService.getByID(offerForm.getGreen_card_insurance_id());
            offer.setGreenCardInsurance(greenCardInsurance);
        } else if(offerForm.getProperty_insurance_id() != null){
            PropertyInsurance propertyInsurance = propertyInsuranceService
                    .findPropertyInsuranceById(offerForm.getProperty_insurance_id());
            offer.setPropertyInsurance(propertyInsurance);
        } else if(offerForm.getProperty_liability_insurance_id() != null){
            PropertyLiabilityInsurance propertyLiabilityInsurance = propertyLiabilityInsuranceService
                    .getByID(offerForm.getProperty_liability_insurance_id());
            offer.setPropertyLiabilityInsurance(propertyLiabilityInsurance);
        }

        offer = offersRepository.save(offer);

        return offer;
    }


    public List<Offer> getAll(){
        return this.offersRepository.findAll();
    }



}
