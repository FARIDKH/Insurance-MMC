import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
@NgModule({
    declarations: [HomeComponent],
    imports: [ CommonModule,RouterModule, FontAwesomeModule ],
    exports: [HomeComponent],
    providers: [],
})
export class HomeModule {}