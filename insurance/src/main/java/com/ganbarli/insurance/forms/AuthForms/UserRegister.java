package com.ganbarli.insurance.forms.AuthForms;

import com.sun.istack.NotNull;

public class UserRegister {


    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phone;

    @NotNull
    private String password;

    @NotNull
    private Integer client_id;

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
