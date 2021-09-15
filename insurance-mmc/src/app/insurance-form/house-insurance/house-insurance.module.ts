 
 import { NgModule } from '@angular/core';
 import { CommonModule } from '@angular/common';
import { HouseInsuranceComponent } from './house-insurance.component';
import { FormsModule } from '@angular/forms';
import { OfferService } from 'src/app/services/offer.service';
import { ClientService } from 'src/app/services/client.service';
import { PropertyInsuranceService } from 'src/app/services/propertyInsurance.service';
 
 @NgModule({
     declarations: [HouseInsuranceComponent],
     imports: [ CommonModule, FormsModule ],
     exports: [HouseInsuranceComponent],
     providers: [OfferService, ClientService, PropertyInsuranceService],
 })
 export class HouseInsuranceModule {}