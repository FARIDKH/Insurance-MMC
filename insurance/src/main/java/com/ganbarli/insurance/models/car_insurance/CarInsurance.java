package com.ganbarli.insurance.models.car_insurance;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "car_insurances")
public class CarInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String car_plate_number;
    private String car_registration_number;
    private String car_engine_size;



    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCar_plate_number() {
        return car_plate_number;
    }

    public void setCar_plate_number(String car_plate_number) {
        this.car_plate_number = car_plate_number;
    }

    public String getCar_registration_number() {
        return car_registration_number;
    }

    public void setCar_registration_number(String car_registration_number) {
        this.car_registration_number = car_registration_number;
    }

    public String getCar_engine_size() {
        return car_engine_size;
    }

    public void setCar_engine_size(String car_engine_size) {
        this.car_engine_size = car_engine_size;
    }
}
