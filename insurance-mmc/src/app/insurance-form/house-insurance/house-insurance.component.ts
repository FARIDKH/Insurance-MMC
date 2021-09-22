import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client.model';
import { Offer } from 'src/app/models/offer.model';
import { PropertyInsurance } from 'src/app/models/propertyInsurance.model';
import { ClientService } from 'src/app/services/client.service';
import { OfferService } from 'src/app/services/offer.service';
import { PropertyInsuranceService } from 'src/app/services/propertyInsurance.service';

@Component({
    selector: 'app-house-insurance',
    templateUrl: './house-insurance.component.html',
    styleUrls: ['./house-insurance.component.scss']
})
export class HouseInsuranceComponent implements OnInit {
    constructor(private propertyInsuranceService : PropertyInsuranceService,
        private clientService : ClientService,
        private offerService : OfferService) { }

    ngOnInit(): void { }

    selectedFormNumber = 1

    propertyInsurance : PropertyInsurance = new PropertyInsurance()
    client : Client = new Client();

    chosenInsuranceCompany = ""


    formSubmitted = false;

    proceedToNextForm(){
        this.selectedFormNumber++;
    }

    selectForm(formNumber : number){
        this.selectedFormNumber = formNumber
    }

    submitPropertyInsuranceForm(){
        this.propertyInsuranceService.create(this.propertyInsurance).subscribe((pi)=>{
            this.propertyInsurance.id = pi.id
        })
    }

    submitClientForm(){
        this.clientService.create(this.client).subscribe((c) => {
            this.client.id = c.id
        })
    }

    submitForm(){
        let offer = new Offer();
        offer.property_insurance_id = this.propertyInsurance.id
        offer.client_id = this.client.id!
        offer.insurance_company = this.chosenInsuranceCompany
        this.offerService.create(offer).subscribe((o) => {
            this.formSubmitted = true;
            setTimeout(() => {
                this.formSubmitted = false;
            }, 2000);
        })

        this.selectedFormNumber = 1
        this.propertyInsurance = new PropertyInsurance()
        this.client = new Client()
    }

}
