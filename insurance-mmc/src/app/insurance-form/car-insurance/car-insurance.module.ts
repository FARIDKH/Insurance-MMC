import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarInsuranceComponent } from './car-insurance.component';
import { CarInsuranceService } from 'src/app/services/carInsurance.service';
import { FormsModule } from '@angular/forms';
import { ClientService } from 'src/app/services/client.service';
import { OfferService } from 'src/app/services/offer.service';
import { SMSService } from 'src/app/services/sms.service';

@NgModule({
    declarations: [CarInsuranceComponent],
    imports: [ CommonModule , FormsModule],
    exports: [CarInsuranceComponent],
    providers: [CarInsuranceService, ClientService, OfferService, SMSService],
})
export class CarInsuranceModule {}