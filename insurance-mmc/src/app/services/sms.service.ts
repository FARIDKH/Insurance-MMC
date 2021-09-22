import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { Client } from "../models/client.model";
import { Offer } from "../models/offer.model";
import { SMS } from "../models/sms.model";


@Injectable()
export class SMSService {


    constructor(private httpClient : HttpClient) {}

    send(client : Client, offer : Offer){
        let sms = new SMS()
        sms.to = client.phone
        sms.message = "Hörmətli vətəndaş,"+
        " sizin sığorta kodunuz xxxx. Zəhmət olmasa 1 gün ərzində bu kodla ödəniş edin. Istifadəçi kodunuz : " + client.code +
        "  Təşəkkürlər."
        return this.httpClient.post(environment.host + "/public/sms",sms);
    }

}