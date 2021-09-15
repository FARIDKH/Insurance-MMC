import { Component, OnInit } from '@angular/core';
import { faCar, faCreditCard, faFirstAid, faHome, faHouseDamage, faTv, faWheelchair } from '@fortawesome/free-solid-svg-icons';

@Component({
    selector: 'app-insurance-types',
    templateUrl: './insurance-types.component.html',
    styleUrls: ['./insurance-types.component.scss']
})
export class InsuranceTypesComponent implements OnInit {

    faCar = faCar;
    faHome = faHome;
    faHouseDamage = faHouseDamage
    faTv = faTv
    faCard = faCreditCard

    faWheelChair = faWheelchair

    faFirstAid = faFirstAid

    constructor() { }

    ngOnInit(): void { }
}
