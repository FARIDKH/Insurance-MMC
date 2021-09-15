import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeModule } from './home/home.module';
import { InsuranceFormModule } from './insurance-form/insurance-forms.module';
import { InsuranceTypesModule } from './insurance-types/insurance-types.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FAQModule } from './faq/faq.module';
import { AboutUsModule } from './about-us/about-us.module';
import { LoginModule } from './auth/login/login.module';
import { RegisterModule } from './auth/register/register.module';
import { AdminModule } from './admin/admin.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpInterceptorService } from './helpers/httpInterceptor.service';
import { FormsModule } from '@angular/forms';
import { ProfileModule } from './profile/profile.module';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    CommonModule,
    InsuranceFormModule,
    InsuranceTypesModule,
    FontAwesomeModule,
    FAQModule,
    AboutUsModule,
    LoginModule,
    RegisterModule,
    AdminModule,
    HttpClientModule,
    ProfileModule
  ],
  providers: [{
    provide : HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi : true
}],
  bootstrap: [AppComponent]
})
export class AppModule { }
