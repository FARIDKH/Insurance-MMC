import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InsuranceTypesComponent } from './insurance-types.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule } from '@angular/router';

@NgModule({
    declarations: [InsuranceTypesComponent],
    imports: [ CommonModule, FontAwesomeModule, RouterModule ],
    exports: [InsuranceTypesComponent],
    providers: [],
})
export class InsuranceTypesModule {}