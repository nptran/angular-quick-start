import { CollapseModule, BsDropdownModule, ModalModule } from 'ngx-bootstrap';

import { ApiModule } from './../../swagger/api.module';
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { UiModule } from "./ui/ui.module";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { LoginComponent } from './login/login.component';
import { AuthGuardService } from "./guards/auth-guard.service";
import { LoginService } from "./services/login.service";
import { RegisterStudentComponent } from './register/register-student.component';
import { ShowHidePasswordModule } from 'ngx-show-hide-password';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [AppComponent, LoginComponent, RegisterStudentComponent],
  imports: [BrowserModule, 
    AppRoutingModule, 
    HttpClientModule, 
    UiModule, 
    FormsModule, ReactiveFormsModule, 
    ApiModule, 
    BsDropdownModule.forRoot(), 
    CollapseModule.forRoot(), 
    ModalModule.forRoot(),
    ShowHidePasswordModule.forRoot(),
    BrowserAnimationsModule,
  ],
  providers: [
    AuthGuardService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
