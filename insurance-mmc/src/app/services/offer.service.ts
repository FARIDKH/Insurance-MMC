import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { Offer } from "../models/offer.model";



@Injectable()
export class OfferService {


    constructor(private httpClient : HttpClient){ }

    create(offer: Offer){
        return this.httpClient.post<Offer>(environment.host + "/public/offer/create",offer);
    }

    

}