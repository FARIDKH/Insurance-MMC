package com.ganbarli.insurance.forms.CarInsuranceForm;

import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

public class CarInsuranceForm {

    @NotNull
    private String car_plate_number;

    @NotNull
    private String car_registration_number;

    @Nullable
    private String car_engine_size;

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

    @Nullable
    public String getCar_engine_size() {
        return car_engine_size;
    }

    public void setCar_engine_size(@Nullable String car_engine_size) {
        this.car_engine_size = car_engine_size;
    }
}
