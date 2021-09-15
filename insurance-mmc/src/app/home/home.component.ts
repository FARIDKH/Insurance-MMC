import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
    constructor(private router: Router) { }

    ngOnInit(): void { }

    goToInsuranceForm(insuranceType : Number) {
 
        switch (insuranceType) {
            case 0:
                this.router.navigateByUrl('/insurance/car') 
                break;
            case 2:
                this.router.navigateByUrl('/insurance/house')
                break;
            default:
                break;
        }      

    }
}
