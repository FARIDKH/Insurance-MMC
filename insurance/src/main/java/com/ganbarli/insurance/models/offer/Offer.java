package com.ganbarli.insurance.models.offer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ganbarli.insurance.models.car_insurance.CarInsurance;
import com.ganbarli.insurance.models.client.Client;
import com.ganbarli.insurance.models.green_card_insurance.GreenCardInsurance;
import com.ganbarli.insurance.models.property_insurance.PropertyInsurance;
import com.ganbarli.insurance.models.property_liability_insurance.PropertyLiabilityInsurance;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "offer")
public class Offer {



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @JsonManagedReference
    private Client client;


    private Date date_offered;
    private Date date_signed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_insurance_id")
    @Nullable
    private  CarInsurance carInsurance;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "green_card_insurance_id")
    @Nullable
    private  GreenCardInsurance greenCardInsurance;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_insurance_id")
    @Nullable
    private  PropertyInsurance propertyInsurance;





    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_liability_insurance_id")
    @Nullable
    private  PropertyLiabilityInsurance propertyLiabilityInsurance;



    private String insurance_company;



    private String details;

    private Boolean is_active;

    public Client getClients() {
        return client;
    }

    @Nullable
    public CarInsurance getCarInsurance() {
        return carInsurance;
    }

    public void setCarInsurance(@Nullable CarInsurance carInsurance) {
        this.carInsurance = carInsurance;
    }

    @Nullable
    public GreenCardInsurance getGreenCardInsurance() {
        return greenCardInsurance;
    }

    public void setGreenCardInsurance(@Nullable GreenCardInsurance greenCardInsurance) {
        this.greenCardInsurance = greenCardInsurance;
    }

    @Nullable
    public PropertyInsurance getPropertyInsurance() {
        return propertyInsurance;
    }

    public void setPropertyInsurance(@Nullable PropertyInsurance propertyInsurance) {
        this.propertyInsurance = propertyInsurance;
    }

    @Nullable
    public PropertyLiabilityInsurance getPropertyLiabilityInsurance() {
        return propertyLiabilityInsurance;
    }

    public void setPropertyLiabilityInsurance(@Nullable PropertyLiabilityInsurance propertyLiabilityInsurance) {
        this.propertyLiabilityInsurance = propertyLiabilityInsurance;
    }

    public void setClients(Client client) {
        this.client = client;
    }
    public String getInsurance_company() {
        return insurance_company;
    }

    public void setInsurance_company(String insurance_company) {
        this.insurance_company = insurance_company;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }




    public Date getDate_offered() {
        return date_offered;
    }

    public void setDate_offered(Date date_offered) {
        this.date_offered = date_offered;
    }

    public Date getDate_signed() {
        return date_signed;
    }

    public void setDate_signed(Date date_signed) {
        this.date_signed = date_signed;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", client=" + client.getId() +
                ", date_offered=" + date_offered +
                ", date_signed=" + date_signed +
                ", carInsurance=" + carInsurance +
                ", greenCardInsurance=" + greenCardInsurance +
                ", propertyInsurance=" + propertyInsurance +
                ", propertyLiabilityInsurance=" + propertyLiabilityInsurance +
                ", insurance_company='" + insurance_company + '\'' +
                ", details='" + details + '\'' +
                ", is_active=" + is_active +
                '}';
    }
}
