import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { CarInsurance } from "../models/carInsurance.model";


@Injectable()
export class CarInsuranceService{

    constructor(private httpClient: HttpClient){}

    create(carInsurance : CarInsurance){
        return this.httpClient.post<CarInsurance>(
            environment.host + "/public/carInsurance/create", carInsurance
        )
    }

}