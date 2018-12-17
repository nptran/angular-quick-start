import { RegisterStudentComponent } from './register/register-student.component';
import { LoginComponent } from './login/login.component';

import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { LayoutComponent } from "./ui/layout/layout.component";
import { AuthGuardService } from "./guards/auth-guard.service";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'welcome',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterStudentComponent
  },
  {
    path: '',
    component: LayoutComponent,
    canActivate: [AuthGuardService],
    children: [
      {
        path: 'welcome',
        loadChildren: './welcome/welcome.module#WelcomeModule'
      },
      {
        path: 'subjects',
        loadChildren: './subjects/subjects.module#SubjectsModule'
      },
      {
        path: 'persional',
        loadChildren: './students/students.module#StudentsModule'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
