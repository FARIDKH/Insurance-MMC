import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InsuranceFormComponent } from './insurance-forms.component';
import { CarInsuranceModule } from './car-insurance/car-insurance.module';
import { HouseInsuranceModule } from './house-insurance/house-insurance.module';
import { ReliModule } from './real-estate-liability-insurance/reli.module';
import { MPComponent } from './moveable-property-insurance/mp.component';
import { MPModule } from './moveable-property-insurance/mp.module';
import { IAModule } from './individual-accident/ia.module';
import { HealthInsuranceModule } from './health-insurance/health-insurance.module';
import { GreenCardInsuranceModule } from './green-card-insurance/green-card-insurance.module';

@NgModule({
    declarations: [InsuranceFormComponent],
    imports: [ CommonModule, 
        CarInsuranceModule, 
        HouseInsuranceModule, 
        ReliModule, 
        MPModule, 
        IAModule, 
        HealthInsuranceModule,
        GreenCardInsuranceModule
    ],
    exports: [InsuranceFormComponent],
    providers: [],
})
export class InsuranceFormModule {}