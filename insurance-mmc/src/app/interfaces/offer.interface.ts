import { CarInsurance } from "../models/carInsurance.model";
import { Client } from "../models/client.model";
import { GreenCardInsurance } from "../models/greenCardInsurance.model";
import { PropertyInsurance } from "../models/propertyInsurance.model";
import { PropertyLiabilityInsurance } from "../models/propertyLiabilityInsurance.model";



export interface OfferInterface {
    carInsurance : CarInsurance
    clients : Client
    propertyInsurance : PropertyInsurance 
    greenCardInsurance : GreenCardInsurance 
    propertyLiabilityInsurance : PropertyLiabilityInsurance 
    date_offered : Date
    date_signed? : Date
    insurance_company : String
}