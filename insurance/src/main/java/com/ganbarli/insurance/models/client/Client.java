package com.ganbarli.insurance.models.client;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ganbarli.insurance.models.offer.Offer;
import com.ganbarli.insurance.models.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String code;

    private String first_name;
    private String last_name;
    private String address;
    private String phone;
    private String email;
    private String ssn_number;

    private String id_number;
    private String fin_code;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Offer> offers;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    @Enumerated(EnumType.ORDINAL)
    private Client_Type client_type;

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }


    public Client_Type getClient_type() {
        return client_type;
    }

    public void setClient_type(Client_Type client_type) {
        this.client_type = client_type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
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

    public String getSsn_number() {
        return ssn_number;
    }

    public void setSsn_number(String ssn_number) {
        this.ssn_number = ssn_number;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", ssn_number='" + ssn_number + '\'' +
                ", id_number='" + id_number + '\'' +
                ", fin_code='" + fin_code + '\'' +
                ", offers=" + offers +
                ", client_type=" + client_type +
                '}';
    }
}
