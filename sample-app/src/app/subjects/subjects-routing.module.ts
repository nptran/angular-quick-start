import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SubjectsListComponent } from './subjects-list/subjects-list.component';
import { SubjectsRegistrationComponent } from './subjects-registration/subjects-registration.component';

const routes: Routes = [
  {
    path: '',
    component: SubjectsListComponent
  },
  {
    path: 'registration',
    component: SubjectsRegistrationComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SubjectsRoutingModule { }
