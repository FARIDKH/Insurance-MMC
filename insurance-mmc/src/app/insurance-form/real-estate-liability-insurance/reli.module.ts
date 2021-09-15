import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReliComponent } from './reli.component';
import { FormsModule } from '@angular/forms';
import { OfferService } from 'src/app/services/offer.service';
import { ClientService } from 'src/app/services/client.service';
import { PropertyLiabilityInsuranceService } from 'src/app/services/propertyLiabilityInsurance.service';

@NgModule({
    declarations: [ ReliComponent ],
    imports: [ CommonModule, FormsModule],
    exports: [ ReliComponent ],
    providers: [OfferService, ClientService, PropertyLiabilityInsuranceService],
})
export class ReliModule {}