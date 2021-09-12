package com.ganbarli.insurance.models.green_card_insurance;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GreenCardInsurance {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getCar_registration_number() {
        return car_registration_number;
    }

    public void setCar_registration_number(String car_registration_number) {
        this.car_registration_number = car_registration_number;
    }

    public String getCar_plate_number() {
        return car_plate_number;
    }

    public void setCar_plate_number(String car_plate_number) {
        this.car_plate_number = car_plate_number;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    private String car_registration_number;
    private String car_plate_number;
    private String contact_person;
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    private Integer duration;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
