import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { PropertyLiabilityInsurance } from "../models/propertyLiabilityInsurance.model";


@Injectable()
export class PropertyLiabilityInsuranceService {

    constructor(private httpClient: HttpClient){}

    create(propertyLiabilityInsurance : PropertyLiabilityInsurance){
        return this.httpClient.post<PropertyLiabilityInsurance>(
            environment.host + "/public/propertyLiabilityInsurance/create", propertyLiabilityInsurance
        )
    }

}