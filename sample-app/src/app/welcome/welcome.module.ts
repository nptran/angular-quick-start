import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { WelcomeRoutingModule } from "./welcome-routing.module";
import { WelcomeComponent } from "./welcome.component";
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { ModalModule } from 'ngx-bootstrap/modal';

@NgModule({
  declarations: [WelcomeComponent],
  imports: [CommonModule, WelcomeRoutingModule, BsDropdownModule.forRoot(), ModalModule.forRoot()]
})
export class WelcomeModule {}
