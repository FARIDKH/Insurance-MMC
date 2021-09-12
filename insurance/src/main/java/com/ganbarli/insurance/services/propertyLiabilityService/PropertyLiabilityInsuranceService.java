package com.ganbarli.insurance.services.propertyLiabilityService;


import com.ganbarli.insurance.forms.PropertyLiabilityForm.PropertyLiabilityForm;
import com.ganbarli.insurance.models.property_liability_insurance.PropertyLiabilityInsurance;
import com.ganbarli.insurance.repositories.PropertyLiabilityInsuranceRepository.PropertyLiabilityInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyLiabilityInsuranceService {

    @Autowired
    private PropertyLiabilityInsuranceRepository propertyLiabilityInsuranceRepository;


    public PropertyLiabilityInsurance create(PropertyLiabilityForm pLIForm){
        PropertyLiabilityInsurance pLI = new PropertyLiabilityInsurance();
        pLI.setAddress(pLIForm.getAddress());
        pLI.setPropertyType(pLIForm.getPropertyType());
        return propertyLiabilityInsuranceRepository.save(pLI);
    }

    public PropertyLiabilityInsurance update(Long pLIID, PropertyLiabilityForm pLIForm){
        PropertyLiabilityInsurance pLI = propertyLiabilityInsuranceRepository.getById(pLIID);
        pLI.setAddress(pLIForm.getAddress());
        pLI.setPropertyType(pLIForm.getPropertyType());
        return propertyLiabilityInsuranceRepository.save(pLI);
    }

    public List<PropertyLiabilityInsurance> getAll(){
        return propertyLiabilityInsuranceRepository.findAll();
    }

    public PropertyLiabilityInsurance getByID(Long pLIID){
        return propertyLiabilityInsuranceRepository.findById(pLIID).get();
    }



    public boolean deletePLI(Long pLIID){
        PropertyLiabilityInsurance pLI = propertyLiabilityInsuranceRepository.getById(pLIID);
        if (pLI == null) {
            return false;
        }
        propertyLiabilityInsuranceRepository.delete(pLI);
        return true;
    }

}
