import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { PropertyInsurance } from "../models/propertyInsurance.model";

@Injectable()
export class PropertyInsuranceService{


    constructor(private httpClient: HttpClient) {}

    create(propertyInsurance : PropertyInsurance){
        return this.httpClient.post<PropertyInsurance>(
            environment.host + "/public/propertyInsurance/create", propertyInsurance
        )
    }

}