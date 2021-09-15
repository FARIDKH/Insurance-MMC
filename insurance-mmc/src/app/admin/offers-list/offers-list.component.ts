
import { Component, Input, OnInit } from '@angular/core';
import { OfferInterface } from 'src/app/interfaces/offer.interface';
import { CarInsurance } from 'src/app/models/carInsurance.model';
import { Client } from 'src/app/models/client.model';
import { GreenCardInsurance } from 'src/app/models/greenCardInsurance.model';
import { Offer } from 'src/app/models/offer.model';
import { PropertyInsurance } from 'src/app/models/propertyInsurance.model';
import { PropertyLiabilityInsurance } from 'src/app/models/propertyLiabilityInsurance.model';

@Component({
    selector: 'app-offers-list',
    templateUrl: './offers-list.component.html',
    styleUrls: ['./offers-list.component.scss']
})
export class OffersListComponent implements OnInit {

    @Input() allOffers : OfferInterface[] = []

    constructor() { }

    ngOnInit(): void {
        
    }

    selectedClient : Client = new Client();
    selectedInsuranceForm : String = ""


    selectedCarInsurance : CarInsurance = new CarInsurance()
    selectedGreenCardInsurance : GreenCardInsurance = new GreenCardInsurance()
    selectedPropertyInsurance : PropertyInsurance = new PropertyInsurance()
    selectedPropertyLiabilityInsurance : PropertyLiabilityInsurance = new PropertyLiabilityInsurance()


    hideMainTable = false
    hideClientTable = true
    hideInsuranceTable = true

    getInsuranceType(offer: OfferInterface) : String {
        if(offer.carInsurance != null){
            return "AVSSMIS"
        } else if (offer.greenCardInsurance != null){
            return "Yaşıl kart"
        } else if (offer.propertyInsurance != null){
            return "DƏİS"
        } else if (offer.propertyLiabilityInsurance != null){
            return "DƏMMİS"
        }
        return ""
    }

    clientSelected(){
        this.hideMainTable = true
        this.hideClientTable = false   
    }

    backToMain(){
        this.hideMainTable = false
        this.hideClientTable = true
        this.hideInsuranceTable = true
    }

    insuranceSelected(offer : OfferInterface){
        this.hideMainTable = true
        this.hideInsuranceTable = false 
        this.selectedInsuranceForm = this.getInsuranceType(offer)
        if(offer.carInsurance != null){
            this.selectedCarInsurance = offer.carInsurance
        } else if (offer.greenCardInsurance != null){
            this.selectedGreenCardInsurance = offer.greenCardInsurance
        } else if (offer.propertyInsurance != null){
            this.selectedPropertyInsurance = offer.propertyInsurance
        } else if (offer.propertyLiabilityInsurance != null){
            this.selectedPropertyLiabilityInsurance = offer.propertyLiabilityInsurance
        }
    }

}
