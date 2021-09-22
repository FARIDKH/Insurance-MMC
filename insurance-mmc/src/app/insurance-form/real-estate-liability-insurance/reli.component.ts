import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client.model';
import { Offer } from 'src/app/models/offer.model';
import { PropertyLiabilityInsurance } from 'src/app/models/propertyLiabilityInsurance.model';
import { ClientService } from 'src/app/services/client.service';
import { OfferService } from 'src/app/services/offer.service';
import { PropertyLiabilityInsuranceService } from 'src/app/services/propertyLiabilityInsurance.service';

@Component({
    selector: 'app-reli',
    templateUrl: './reli.component.html',
    styleUrls: ['./reli.component.scss']
})
export class ReliComponent implements OnInit {
    constructor(
        private clientService: ClientService,
        private offerService : OfferService,
        private propertyLiabilityInsuranceService : PropertyLiabilityInsuranceService

    ) { }

    ngOnInit(): void { }

    selectedFormNumber = 1
     
    otherPurposeSelected = false;


    formSubmitted = false;


    propertyLiabilityInsurance : PropertyLiabilityInsurance = new PropertyLiabilityInsurance()
    client : Client = new Client()
    
    selectedInsuranceCompany = ""

    proceedToNextForm(){
        this.selectedFormNumber++;
    }

    submitPLI(){
        this.propertyLiabilityInsuranceService.create(this.propertyLiabilityInsurance).subscribe((pli) => {
            this.propertyLiabilityInsurance.id = pli.id
            console.log(pli)
        })
    }

    submitClient(){
        this.clientService.create(this.client).subscribe((c) => {
            this.client.id = c.id
        })
    }

    selectForm(formNumber : number){
        this.selectedFormNumber = formNumber
    }

    submitForm(){
        let offer = new Offer();
        offer.property_liability_insurance_id = this.propertyLiabilityInsurance.id
        offer.client_id = this.client.id!
        offer.insurance_company = this.selectedInsuranceCompany
        this.offerService.create(offer).subscribe((o) => {
            this.formSubmitted = true;
            setTimeout(() => {
                this.formSubmitted = false;
            }, 2000);
        })

        this.selectedFormNumber = 1
        this.propertyLiabilityInsurance = new PropertyLiabilityInsurance()
        this.client = new Client()
    }

    selectOtherPurposes() {
        this.otherPurposeSelected = true
    }

    selectMainPurpose(){
        this.otherPurposeSelected = false
    }

}
