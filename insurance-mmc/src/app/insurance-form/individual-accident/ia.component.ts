
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-ia',
    templateUrl: './ia.component.html',
    styleUrls: ['./ia.component.scss']
})
export class IAComponent implements OnInit {
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


}
