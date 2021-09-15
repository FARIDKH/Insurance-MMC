import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { OfferInterface } from "../interfaces/offer.interface";
import { Client } from "../models/client.model";


@Injectable()
export class ClientService {


    constructor(private httpClient: HttpClient){}

    create(client : Client){
        client.phone = "+994" + client.phone
        return this.httpClient.post<Client>(environment.host + "/public/client/create",client)
    }


    getClientOffers(clientID : Number){
        return this.httpClient.get<OfferInterface[]>(environment.host + "/public/client/"+clientID+"/getOffers")
    }


    getClient(clientID: number){
        return this.httpClient.get<Client>(environment.host+ "/public/client/"+clientID+"/getInfo")
    }

    

}