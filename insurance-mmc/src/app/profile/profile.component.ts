import { Component, OnInit } from '@angular/core';
import { faDownload, faFileDownload } from '@fortawesome/free-solid-svg-icons';
import { OfferInterface } from '../interfaces/offer.interface';
import { Client } from '../models/client.model';
import { ClientService } from '../services/client.service';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
    constructor(private clientService : ClientService) { }

    faDownload = faFileDownload;
    offers : OfferInterface[] = []
    client : Client = new Client()
    filteredOffers : OfferInterface[] = []


    ngOnInit(): void {
        let client_id = parseInt(localStorage.getItem("CLIENT_ID")!)
        this.clientService.getClientOffers(client_id).subscribe((offers)=> {
            this.offers = offers
            this.filteredOffers = this.offers
        })

        this.clientService.getClient(client_id).subscribe((client) => {
            this.client = client
        })


     }

    selectedMenuNumber = 1
    filterValue = -1
    

    selectMenuItem(formNumber : number){
        this.selectedMenuNumber = formNumber
    }

    filterByInsuranceType(it : Number){
        this.filteredOffers = this.offers
        switch (it) {
            case 0: // carInsurance
                this.filteredOffers = this.filteredOffers.filter(offer => offer.carInsurance != null);
                this.filterValue = 0
                break;
            case 1: // propertyInsurance
                this.filteredOffers = this.filteredOffers.filter(offer => offer.propertyInsurance != null);
                this.filterValue = 1
                break;
            case 2: // propertyLiabilityInsurance
                this.filteredOffers = this.filteredOffers.filter(offer => offer.propertyLiabilityInsurance != null);
                this.filterValue = 2
                break;
        
            case 3: // greenCardInsurance
                this.filteredOffers = this.filteredOffers.filter(offer => offer.greenCardInsurance != null);
                this.filterValue = 3
                break;
            default:
                break;
        }
    }

    getInsuranceType(offer: OfferInterface) : String {
        if(offer.carInsurance != null){
            return "İcbari avto"
        } else if (offer.greenCardInsurance != null){
            return "Yaşıl kart"
        } else if (offer.propertyInsurance != null){
            return "İcbari əmlak"
        } else if (offer.propertyLiabilityInsurance != null){
            return "İcbari məsuliyyət"
        }
        return ""
    }

    

}
