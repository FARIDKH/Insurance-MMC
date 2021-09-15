import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-health-insurance',
    templateUrl: './health-insurance.component.html',
    styleUrls: ['./health-insurance.component.scss']
})
export class HealthInsuranceComponent implements OnInit {
    constructor() { }

    ngOnInit(): void { }

    selectedFormNumber = 1
     
    ownerIsPerson = false;
    ownerIsCompany = false;


    proceedToNextForm(){
        this.selectedFormNumber++;
    }

    selectForm(formNumber : number){
        this.selectedFormNumber = formNumber
    }

    submitForm(){

    }

    selectOwnerIsPerson(){
        this.ownerIsCompany = false
        this.ownerIsPerson = true
    }

    selectOwnerIsCompany(){
        this.ownerIsCompany = true
        this.ownerIsPerson = false
    }

}
