import { Component, OnInit } from '@angular/core';
import { CarInsurance } from 'src/app/models/carInsurance.model';
import { Client } from 'src/app/models/client.model';
import { Offer } from 'src/app/models/offer.model';
import { SMS } from 'src/app/models/sms.model';
import { CarInsuranceService } from 'src/app/services/carInsurance.service';
import { ClientService } from 'src/app/services/client.service';
import { OfferService } from 'src/app/services/offer.service';
import { SMSService } from 'src/app/services/sms.service';

@Component({
    selector: 'app-car-insurance',
    templateUrl: './car-insurance.component.html',
    styleUrls: ['./car-insurance.component.scss']
})
export class CarInsuranceComponent implements OnInit {
    constructor(private carInsuranceService: CarInsuranceService,
        private clientService : ClientService,
        private offerService: OfferService,
        private smsService : SMSService
        ) { }

    ngOnInit(): void { }


    selectedForm = "carForm"

    selectedFormNumber = 1


    carInsurance : CarInsurance = new CarInsurance()
    client : Client = new Client()

    chosenInsuranceCompany = ""

    formSubmitted = false;

    proceedToNextForm(){
        this.selectedFormNumber++;
        this.selectedForm = this.selectedForm + this.selectedFormNumber
    }

    submitCarInsuranceForm(){
        this.carInsuranceService.create(this.carInsurance).subscribe((cI) => {
            this.carInsurance.id = cI.id
        })
    }

    submitClientForm(){
        this.clientService.create(this.client).subscribe((c) => {
            this.client.id = c.id
        })
    }

    selectForm(formNumber : number){
        this.selectedFormNumber = formNumber
    }

    
    submitForm(){
        let offer = new Offer();
        offer.car_insurance_id = this.carInsurance.id
        offer.client_id = this.client.id!
        offer.insurance_company = this.chosenInsuranceCompany
        this.offerService.create(offer).subscribe((o) => {
            this.formSubmitted = true;
            setTimeout(() => {
                this.formSubmitted = false;
            }, 2000);
        })


        this.selectedFormNumber = 1
        this.carInsurance = new CarInsurance()
        this.client = new Client()
    }
    
}
