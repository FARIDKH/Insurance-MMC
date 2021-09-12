package com.ganbarli.insurance.services.propertyInsuranceService;


import com.ganbarli.insurance.forms.PropertyForm.PropertyForm;
import com.ganbarli.insurance.models.property_insurance.Ownership_doc;
import com.ganbarli.insurance.models.property_insurance.PropertyInsurance;
import com.ganbarli.insurance.repositories.propertyInsuranceRepository.PropertyInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyInsuranceService {


    @Autowired
    private PropertyInsuranceRepository propertyInsuranceRepository;

    public PropertyInsurance create(PropertyForm propertyForm){
        PropertyInsurance propertyInsurance = new PropertyInsurance();
        propertyInsurance.setProperty_type(propertyForm.getProperty_type());
        propertyInsurance.setAddress(propertyForm.getAddress());
        propertyInsurance.setPost_index(propertyForm.getPost_index());
        propertyInsurance.setCity(propertyForm.getCity());
        propertyInsurance.setOwnership_doc(propertyForm.getOwnership_doc());
        if (propertyForm.getOwnership_doc() == Ownership_doc.EXTRACT){
            propertyInsurance.setSeries(propertyForm.getSeries());
            propertyInsurance.setNumber(propertyForm.getNumber());
        } else {
            propertyInsurance.setOther_doc_number(propertyForm.getOther_doc_number());
        }
        return propertyInsuranceRepository.save(propertyInsurance);
    }

    public PropertyInsurance update(Long propertyInsuranceID, PropertyForm propertyInsuranceForm){
        PropertyInsurance propertyInsurance = propertyInsuranceRepository.getById(propertyInsuranceID);
        propertyInsurance.setProperty_type(propertyInsuranceForm.getProperty_type());
        propertyInsurance.setAddress(propertyInsuranceForm.getAddress());
        propertyInsurance.setPost_index(propertyInsuranceForm.getPost_index());
        propertyInsurance.setSeries(propertyInsuranceForm.getSeries());
        propertyInsurance.setNumber(propertyInsuranceForm.getNumber());
        return propertyInsuranceRepository.save(propertyInsurance);
    }

    public List<PropertyInsurance> getAllPropertyInsurances(){
        return propertyInsuranceRepository.findAll();
    }

    public PropertyInsurance findPropertyInsuranceById(Long propertyInsuranceID){
        return propertyInsuranceRepository.findById(propertyInsuranceID).get();
    }
    public boolean deletePropertyInsurance(Long propertyInsuranceID){
        PropertyInsurance pI = findPropertyInsuranceById(propertyInsuranceID);
        if (pI == null){
            return false;
        }
        propertyInsuranceRepository.delete(pI);
        return true;
    }

}
