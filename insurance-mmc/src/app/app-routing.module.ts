import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AdminComponent } from './admin/admin.component';
import { OffersListComponent } from './admin/offers-list/offers-list.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { FAQComponent } from './faq/faq.component';
import { HomeComponent } from './home/home.component';
import { CarInsuranceComponent } from './insurance-form/car-insurance/car-insurance.component';
import { GreenCardInsuranceComponent } from './insurance-form/green-card-insurance/green-card-insurance.component';
import { HouseInsuranceComponent } from './insurance-form/house-insurance/house-insurance.component';
import { IAComponent } from './insurance-form/individual-accident/ia.component';
import { InsuranceFormComponent } from './insurance-form/insurance-forms.component';
import { MPComponent } from './insurance-form/moveable-property-insurance/mp.component';
import { ReliComponent } from './insurance-form/real-estate-liability-insurance/reli.component';
import { InsuranceTypesComponent } from './insurance-types/insurance-types.component';
import { GreenCardInsurance } from './models/greenCardInsurance.model';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'insuranceTypes', component: InsuranceTypesComponent
  },
  {
    path: 'faq', component: FAQComponent
  },
  {
    path: 'aboutUs', component: AboutUsComponent
  },
  {
    path: 'profile', component : ProfileComponent
  },
  {
    path: 'register', component: RegisterComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'logout', component: LoginComponent
  },
  {
    path: 'adminPage', component : AdminComponent
  },
  {
    path: 'adminPage/allOffers', component: OffersListComponent
  },
  {
    path: 'insurance/car', component: CarInsuranceComponent
  },
  {
    path: 'insurance/house', component: HouseInsuranceComponent
  },
  {
    path: 'insurance/reli', component: ReliComponent
  },
  {
    path: 'insurance/mp', component: MPComponent
  },
  {
    path: 'insurance/greenCardInsurance', component: GreenCardInsuranceComponent
  },
  {
    path: 'insurance/ia', component : IAComponent
  },
  {
    path: 'insurance/healthInsurance', component : IAComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
