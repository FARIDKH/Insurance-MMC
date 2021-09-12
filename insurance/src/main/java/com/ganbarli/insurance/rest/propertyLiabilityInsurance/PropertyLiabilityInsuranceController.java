package com.ganbarli.insurance.rest.propertyLiabilityInsurance;


import com.ganbarli.insurance.forms.PropertyLiabilityForm.PropertyLiabilityForm;
import com.ganbarli.insurance.models.property_liability_insurance.PropertyLiabilityInsurance;
import com.ganbarli.insurance.services.propertyLiabilityService.PropertyLiabilityInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PropertyLiabilityInsuranceController {

    @Autowired
    private PropertyLiabilityInsuranceService propertyLiabilityInsuranceService;


    @GetMapping("/admin/propertyLiabilityInsurance/getAll")
    @ResponseBody
    public List<PropertyLiabilityInsurance> getAll(){
        return propertyLiabilityInsuranceService.getAll();
    }

    @GetMapping("/admin/propertyLiabilityInsurance/get/{pLIID}")
    @ResponseBody
    public PropertyLiabilityInsurance get(@PathVariable Long pLIID){
        return propertyLiabilityInsuranceService.getByID(pLIID);
    }


    @PostMapping("/public/propertyLiabilityInsurance/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PropertyLiabilityInsurance create
            (@RequestBody @Validated PropertyLiabilityForm propertyLiabilityForm){
        return propertyLiabilityInsuranceService.create(propertyLiabilityForm);
    }

    @PutMapping("/public/propertyLiabilityInsurance/update/{pLIID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public PropertyLiabilityInsurance update
            (@PathVariable Long pLIID,
            @RequestBody @Validated PropertyLiabilityForm propertyLiabilityForm){
        return propertyLiabilityInsuranceService.update(pLIID, propertyLiabilityForm);
    }

    @DeleteMapping("/public/propertyLiabilityInsurance/delete/{pLIID}")
    public boolean delete(@PathVariable Long pLIID){
        return propertyLiabilityInsuranceService.deletePLI(pLIID);
    }



}
