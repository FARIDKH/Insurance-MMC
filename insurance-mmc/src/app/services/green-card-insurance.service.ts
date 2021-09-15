import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { GreenCardInsuranceComponent } from "../insurance-form/green-card-insurance/green-card-insurance.component";
import { GreenCardInsurance } from "../models/greenCardInsurance.model";



@Injectable()
export class GreenCardInsuranceService {

    constructor(private httpClient: HttpClient){}

    create(greenCard: GreenCardInsurance){
        return this.httpClient.post<GreenCardInsurance>(
            environment.host + "/public/greenCardInsurance/create",greenCard
        )
    }

}