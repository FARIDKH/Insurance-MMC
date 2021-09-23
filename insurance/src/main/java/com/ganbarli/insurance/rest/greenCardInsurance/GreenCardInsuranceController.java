package com.ganbarli.insurance.rest.greenCardInsurance;


import com.ganbarli.insurance.forms.GreenCardForm.GreenCardForm;
import com.ganbarli.insurance.models.green_card_insurance.GreenCardInsurance;
import com.ganbarli.insurance.services.greenCardService.GreenCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class GreenCardInsuranceController {

    @Autowired
    private GreenCardService greenCardService;

    @GetMapping("/admin/greenCardInsurance/getAll")
    @ResponseBody
    public List<GreenCardInsurance> getAll(){
        return greenCardService.getAll();
    }

    @GetMapping("/admin/greenCardInsurance/get/{greenCardID}")
    @ResponseBody
    public GreenCardInsurance get(@PathVariable Long greenCardID){
        return greenCardService.getByID(greenCardID);
    }


    @PostMapping("/public/greenCardInsurance/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GreenCardInsurance create(@RequestBody GreenCardForm greenCardForm){
        return greenCardService.create(greenCardForm);
    }

    @PutMapping("/public/greenCardInsurance/update/{greenCardID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public GreenCardInsurance update(@RequestBody GreenCardForm greenCardForm, @PathVariable Long greenCardID){
        return greenCardService.update(greenCardID,greenCardForm);
    }

    @DeleteMapping("/public/greenCardInsurance/delete/{greenCardID}")
    public boolean delete(@PathVariable Long greenCardID){
        return greenCardService.delete(greenCardID);
    }

}
