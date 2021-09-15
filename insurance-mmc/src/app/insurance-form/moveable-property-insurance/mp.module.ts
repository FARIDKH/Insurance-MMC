
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MPComponent } from './mp.component';

@NgModule({
    declarations: [MPComponent],
    imports: [ CommonModule ],
    exports: [MPComponent],
    providers: [],
})
export class MPModule {}