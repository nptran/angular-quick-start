import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentsRoutingModule } from './students-routing.module';
import { StudentInfoComponent } from './student-info/student-info.component';

@NgModule({
  declarations: [ StudentInfoComponent ],
  imports: [
    CommonModule,
    StudentsRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class StudentsModule { }
