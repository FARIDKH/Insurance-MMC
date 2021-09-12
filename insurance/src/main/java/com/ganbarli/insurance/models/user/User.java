package com.ganbarli.insurance.models.user;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @NotNull
    private Integer client_id;



    @NotNull
    @Column(unique=true)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
