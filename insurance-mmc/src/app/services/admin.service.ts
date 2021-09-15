import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { Offer } from "../models/offer.model";
import { OfferInterface } from "../interfaces/offer.interface";


@Injectable()
export class AdminService {


    constructor(private httpClient : HttpClient){

    }


    getAllOffers(){
        return this.httpClient.get<OfferInterface[]>(environment.host + "/admin/offer/getAll");
    }

}