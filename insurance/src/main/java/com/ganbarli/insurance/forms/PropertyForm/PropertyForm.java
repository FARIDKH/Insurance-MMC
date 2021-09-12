package com.ganbarli.insurance.forms.PropertyForm;

import com.ganbarli.insurance.models.property_insurance.Ownership_doc;
import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

public class PropertyForm {


    @NotNull
    private String property_type;


    @NotNull
    private String post_index;


    @NotNull
    private String series;


    @NotNull
    private String number;


    @NotNull
    private Ownership_doc ownership_doc;

    @NotNull
    private String city;

    @Nullable
    private String other_doc_number;

    @Nullable
    public String getOther_doc_number() {
        return other_doc_number;
    }

    public void setOther_doc_number(@Nullable String other_doc_number) {
        this.other_doc_number = other_doc_number;
    }

    public Ownership_doc getOwnership_doc() {
        return ownership_doc;
    }

    public void setOwnership_doc(Ownership_doc ownership_doc) {
        this.ownership_doc = ownership_doc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotNull
    private String address;


    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public String getPost_index() {
        return post_index;
    }

    public void setPost_index(String post_index) {
        this.post_index = post_index;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
