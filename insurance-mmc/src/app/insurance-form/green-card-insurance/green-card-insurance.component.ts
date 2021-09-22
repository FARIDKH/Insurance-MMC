

import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client.model';
import { GreenCardInsurance } from 'src/app/models/greenCardInsurance.model';
import { Offer } from 'src/app/models/offer.model';
import { ClientService } from 'src/app/services/client.service';
import { GreenCardInsuranceService } from 'src/app/services/green-card-insurance.service';
import { OfferService } from 'src/app/services/offer.service';

@Component({
    selector: 'app-green-card-insurance',
    templateUrl: './green-card-insurance.component.html',
    styleUrls: ['./green-card-insurance.component.scss']
})
export class GreenCardInsuranceComponent implements OnInit {
    constructor(
        private greenCardInsuranceService : GreenCardInsuranceService,
        private clientService: ClientService,
        private offerService : OfferService
    ) { }

    ngOnInit(): void { }

    
    client : Client = new Client()
    greenCardInsurance : GreenCardInsurance = new GreenCardInsurance()
    chosenInsuranceCompany = ""

    formSubmitted = false;


    selectedFormNumber = 1

    ownerIsPerson = false;
    ownerIsCompany = false;
    selectOwnerIsPerson(){
        this.ownerIsCompany = false
        this.ownerIsPerson = true
    }

    selectOwnerIsCompany(){
        this.ownerIsCompany = true
        this.ownerIsPerson = false
    }

    proceedToNextForm(){
        this.selectedFormNumber++;
    }

    submitGreenCardInsuranceForm(){
        this.greenCardInsuranceService.create(this.greenCardInsurance).subscribe((gci) => {
            this.greenCardInsurance.id = gci.id
        })
    }

    submitClientForm(){
        this.clientService.create(this.client).subscribe((c) => {
            this.client.id = c.id
            console.log(c)
        })
    }

    selectForm(formNumber : number){
        this.selectedFormNumber = formNumber
    }

    
    submitForm(){
        let offer = new Offer();
        offer.green_card_insurance_id = this.greenCardInsurance.id
        offer.client_id = this.client.id!
        offer.insurance_company = this.chosenInsuranceCompany
        
        this.offerService.create(offer).subscribe(() => {
            this.formSubmitted = true;
            setTimeout(() => {
                this.formSubmitted = false;
            }, 2000);
        })
        this.selectedFormNumber = 1
        this.greenCardInsurance = new GreenCardInsurance()
        this.client = new Client()
    }
    

}
