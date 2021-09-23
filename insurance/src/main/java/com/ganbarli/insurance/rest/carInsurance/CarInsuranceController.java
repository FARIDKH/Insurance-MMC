package com.ganbarli.insurance.rest.carInsurance;


import com.ganbarli.insurance.forms.CarInsuranceForm.CarInsuranceForm;
import com.ganbarli.insurance.models.car_insurance.CarInsurance;
import com.ganbarli.insurance.services.carInsuranceService.CarInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://185.43.190.108:4200", maxAge = 3600)

public class CarInsuranceController {

    @Autowired
    private CarInsuranceService carInsuranceService;


    @GetMapping("/admin/carInsurance/getAll")
    @ResponseBody
    public List<CarInsurance> getAll(){
        return carInsuranceService.getAllCarInsurances();
    }

    @PostMapping("/public/carInsurance/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CarInsurance create(@RequestBody @Validated CarInsuranceForm carInsuranceForm){
        return carInsuranceService.create(carInsuranceForm);
    }


    @PutMapping("/public/carInsurance/update/{id}")
    @ResponseBody
    public Boolean update(@RequestBody CarInsuranceForm carInsuranceForm, @PathVariable Integer id){
        return carInsuranceService.update(id,carInsuranceForm);
    }

    @DeleteMapping("/public/carInsurance/delete/{id}")
    @ResponseBody
    public Boolean delete(@PathVariable Integer id){
        return carInsuranceService.delete(id);
    }

}
