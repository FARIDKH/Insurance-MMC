package com.ganbarli.insurance.models.property_liability_insurance;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PropertyLiabilityInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private String propertyType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getId() {
        return id;
    }
}
