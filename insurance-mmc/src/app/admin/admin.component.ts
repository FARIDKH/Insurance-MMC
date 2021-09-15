import { Component, OnInit } from '@angular/core';
import { OfferInterface } from '../interfaces/offer.interface';
import { Offer } from '../models/offer.model';
import { AdminService } from '../services/admin.service';

@Component({
    selector: 'app-admin',
    templateUrl: './admin.component.html',
    styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
    constructor(
        private adminServie: AdminService
    ) { }
    
    allOffers : OfferInterface[] =[]

    page : Number = 0


    ngOnInit(): void {
        this.adminServie.getAllOffers().subscribe((d) => {
            d.forEach(offer => {
                offer.date_offered = new Date(offer.date_offered)
            });
            this.allOffers = d;
            console.log(d)
        })
    }

    

    

}
