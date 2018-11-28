import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentCreateComponent } from './student-create/student-create.component';
import { StudentEditComponent } from './student-edit/student-edit.component';

const routes: Routes = [
  {
    path: '',
    component: StudentListComponent
  },
  {
    path: 'create',
    component: StudentCreateComponent
  },
  {
    path: 'edit/:id',
    component: StudentEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentsRoutingModule { }
