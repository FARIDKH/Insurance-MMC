package com.ganbarli.insurance.forms.GreenCardForm;

import org.springframework.lang.NonNull;

public class GreenCardForm {


    @NonNull
    private String car_registration_number;


    @NonNull
    private String car_plate_number;


    @NonNull
    private String contact_person;


    @NonNull
    private String direction;

    @NonNull
    private Integer duration;


    @NonNull
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(@NonNull Integer duration) {
        this.duration = duration;
    }

    @NonNull
    public String getCar_registration_number() {
        return car_registration_number;
    }

    public void setCar_registration_number(@NonNull String car_registration_number) {
        this.car_registration_number = car_registration_number;
    }

    @NonNull
    public String getCar_plate_number() {
        return car_plate_number;
    }

    public void setCar_plate_number(@NonNull String car_plate_number) {
        this.car_plate_number = car_plate_number;
    }

    @NonNull
    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(@NonNull String contact_person) {
        this.contact_person = contact_person;
    }

    @NonNull
    public String getDirection() {
        return direction;
    }

    public void setDirection(@NonNull String direction) {
        this.direction = direction;
    }
}
