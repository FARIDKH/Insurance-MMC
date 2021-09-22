import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { faClock, faDotCircle, faUserShield } from '@fortawesome/free-solid-svg-icons';


@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

    faClock = faClock
    faUserShield = faUserShield
    faDotCircle = faDotCircle

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
            case 3:
                this.router.navigateByUrl('/insurance/greenCardInsurance')
                break;
            default:
                break;
        }      

    }
}
