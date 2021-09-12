package com.ganbarli.insurance.forms.OfferForm;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;

public class OfferForm {

    @NonNull
    private Integer client_id;


    @NonNull
    private Date date_offered;
    private Date date_signed;

    @NonNull
    private String insurance_company;

    @NonNull
    public String getInsurance_company() {
        return insurance_company;
    }

    public void setInsurance_company(@NonNull String insurance_company) {
        this.insurance_company = insurance_company;
    }

    @Nullable
    private Integer car_insurance_id;


    @Nullable
    private Long green_card_insurance_id;


    @Nullable
    private Long  property_insurance_id;


    @Nullable
    private Long property_liability_insurance_id;



    @Nullable
    private String details;

    private Boolean is_active;

    @NonNull
    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(@NonNull Integer client_id) {
        this.client_id = client_id;
    }

    @NonNull
    public Date getDate_offered() {
        return date_offered;
    }

    public void setDate_offered(@NonNull Date date_offered) {
        this.date_offered = date_offered;
    }

    public Date getDate_signed() {
        return date_signed;
    }

    public void setDate_signed(Date date_signed) {
        this.date_signed = date_signed;
    }

    @Nullable
    public Integer getCar_insurance_id() {
        return car_insurance_id;
    }

    public void setCar_insurance_id(@Nullable Integer car_insurance_id) {
        this.car_insurance_id = car_insurance_id;
    }

    @Nullable
    public Long getGreen_card_insurance_id() {
        return green_card_insurance_id;
    }

    public void setGreen_card_insurance_id(@Nullable Long green_card_insurance_id) {
        this.green_card_insurance_id = green_card_insurance_id;
    }

    @Nullable
    public Long getProperty_insurance_id() {
        return property_insurance_id;
    }

    public void setProperty_insurance_id(@Nullable Long property_insurance_id) {
        this.property_insurance_id = property_insurance_id;
    }

    @Nullable
    public Long getProperty_liability_insurance_id() {
        return property_liability_insurance_id;
    }

    public void setProperty_liability_insurance_id(@Nullable Long property_liability_insurance_id) {
        this.property_liability_insurance_id = property_liability_insurance_id;
    }

    @Nullable
    public String getDetails() {
        return details;
    }

    public void setDetails(@Nullable String details) {
        this.details = details;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
