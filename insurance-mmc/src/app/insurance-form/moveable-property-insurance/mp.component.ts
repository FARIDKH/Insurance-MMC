

import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-mp',
    templateUrl: './mp.component.html',
    styleUrls: ['./mp.component.scss']
})
export class MPComponent implements OnInit {
    constructor() { }

    ngOnInit(): void { }

    selectedFormNumber = 1
     
    


    proceedToNextForm(){
        this.selectedFormNumber++;
    }

    selectForm(formNumber : number){
        this.selectedFormNumber = formNumber
    }

    submitForm(){

    }
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

}
