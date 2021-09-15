
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { AdminService } from '../services/admin.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpInterceptorService } from '../helpers/httpInterceptor.service';
import { OffersListModule } from './offers-list/offers-list.module';
import { AppRoutingModule } from '../app-routing.module';

@NgModule({
    declarations: [AdminComponent],
    imports: [ CommonModule, OffersListModule, AppRoutingModule ],
    exports: [AdminComponent],
    providers: [AdminService, {
        provide : HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi : true
    }],
})
export class AdminModule {}