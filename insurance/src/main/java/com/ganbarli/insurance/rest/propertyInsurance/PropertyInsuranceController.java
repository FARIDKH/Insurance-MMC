package com.ganbarli.insurance.rest.propertyInsurance;


import com.ganbarli.insurance.forms.PropertyForm.PropertyForm;
import com.ganbarli.insurance.models.property_insurance.PropertyInsurance;
import com.ganbarli.insurance.services.propertyInsuranceService.PropertyInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://185.43.190.108:4200", maxAge = 3600)
public class PropertyInsuranceController {


    @Autowired
    private PropertyInsuranceService propertyInsuranceService;


    @GetMapping("/admin/propertyInsurance/getAll")
    @ResponseBody
    public List<PropertyInsurance> getAll(){
        return propertyInsuranceService.getAllPropertyInsurances();
    }

    @GetMapping("/admin/propertyInsurance/getByID/{propertyInsuranceId}")
    @ResponseBody
    public PropertyInsurance getByID(@PathVariable Long propertyInsuranceId){
        return propertyInsuranceService.findPropertyInsuranceById(propertyInsuranceId);
    }

    @PostMapping("/public/propertyInsurance/create")
    @ResponseBody
    public PropertyInsurance create(@RequestBody PropertyForm propertyForm){
        return propertyInsuranceService.create(propertyForm);
    }


    @PutMapping("/public/propertyInsurance/update/{propertyInsuranceId}")
    @ResponseBody
    public PropertyInsurance update(@PathVariable Long propertyInsuranceId,
                                    PropertyForm propertyInsuranceForm){
        return propertyInsuranceService.update(propertyInsuranceId,propertyInsuranceForm);
    }

    @DeleteMapping("/public/propertyInsurance/delete/{propertyInsuranceID}")
    public boolean delete(@PathVariable Long propertyInsuranceID){
        return propertyInsuranceService.deletePropertyInsurance(propertyInsuranceID);
    }







}
