

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GreenCardInsuranceComponent } from './green-card-insurance.component';
import { FormsModule } from '@angular/forms';
import { ClientService } from 'src/app/services/client.service';
import { GreenCardInsuranceService } from 'src/app/services/green-card-insurance.service';
import { OfferService } from 'src/app/services/offer.service';

@NgModule({
    declarations: [GreenCardInsuranceComponent],
    imports: [ CommonModule, FormsModule ],
    exports: [GreenCardInsuranceComponent],
    providers: [ClientService, GreenCardInsuranceService, OfferService],
})
export class GreenCardInsuranceModule {}