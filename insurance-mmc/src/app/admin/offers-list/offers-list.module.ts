
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OffersListComponent } from './offers-list.component';

@NgModule({
    declarations: [OffersListComponent],
    imports: [ CommonModule ],
    exports: [OffersListComponent],
    providers: [],
})
export class OffersListModule {}