import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SubjectsRoutingModule } from './subjects-routing.module';
import { SubjectsListComponent } from './subjects-list/subjects-list.component';
import { SubjectsRegistrationComponent } from './subjects-registration/subjects-registration.component';

@NgModule({
  declarations: [SubjectsListComponent, SubjectsRegistrationComponent],
  imports: [
    CommonModule,
    SubjectsRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class SubjectsModule { }
