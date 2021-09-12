package com.ganbarli.insurance.forms.AuthForms;

import com.sun.istack.NotNull;

public class UserLogin {

    @NotNull
    private String phone;

    @NotNull
    private String password;

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
