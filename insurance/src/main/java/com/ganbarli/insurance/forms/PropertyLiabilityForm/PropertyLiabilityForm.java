package com.ganbarli.insurance.forms.PropertyLiabilityForm;

import org.springframework.lang.NonNull;

public class PropertyLiabilityForm {

    @NonNull
    private String address;

    @NonNull
    private String propertyType;

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(@NonNull String propertyType) {
        this.propertyType = propertyType;
    }
}
