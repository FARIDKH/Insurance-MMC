import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ClientService } from '../services/client.service';

@NgModule({
    declarations: [ProfileComponent],
    imports: [ CommonModule, FontAwesomeModule ],
    exports: [ProfileComponent],
    providers: [ClientService],
})
export class ProfileModule {}