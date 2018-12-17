import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentInfoComponent } from './student-info/student-info.component';

const routes: Routes = [
  {
    path: '',
    component: StudentInfoComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentsRoutingModule { }
