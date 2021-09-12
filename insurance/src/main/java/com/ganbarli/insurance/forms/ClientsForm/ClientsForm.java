package com.ganbarli.insurance.forms.ClientsForm;

import com.ganbarli.insurance.models.client.Client_Type;
import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ClientsForm {


    @Nullable
    private String first_name;


    @Nullable
    private String last_name;


    private String address;


    private String phone;


    private String email;


    public Client_Type getClient_type() {
        return client_type;
    }

    public void setClient_type(Client_Type client_type) {
        this.client_type = client_type;
    }

    @Enumerated(EnumType.ORDINAL)
    private Client_Type client_type;

    private String id_number;
    private String fin_code;

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getFin_code() {
        return fin_code;
    }

    public void setFin_code(String fin_code) {
        this.fin_code = fin_code;
    }

    @Nullable
    private String ssn_number;

    @Nullable
    private Boolean is_company;

    @Nullable
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(@Nullable String first_name) {
        this.first_name = first_name;
    }

    @Nullable
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(@Nullable String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Nullable
    public String getSsn_number() {
        return ssn_number;
    }

    public void setSsn_number(@Nullable String ssn_number) {
        this.ssn_number = ssn_number;
    }

    @Nullable
    public Boolean getIs_company() {
        return is_company;
    }

    public void setIs_company(@Nullable Boolean is_company) {
        this.is_company = is_company;
    }
}
