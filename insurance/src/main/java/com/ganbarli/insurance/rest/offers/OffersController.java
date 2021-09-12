package com.ganbarli.insurance.rest.offers;


import com.ganbarli.insurance.forms.OfferForm.OfferForm;
import com.ganbarli.insurance.models.offer.Offer;
import com.ganbarli.insurance.services.offerService.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OffersController {


    @Autowired
    private OfferService offerService;

    @PostMapping("/public/offer/create")
    @ResponseBody
    public Offer create(@RequestBody OfferForm offerForm){
        return offerService.createOffer(offerForm);
    }

    @GetMapping("/admin/offer/getAll")
    @ResponseBody
    public List<Offer> getAll(){
        return offerService.getAll();
    }

}
