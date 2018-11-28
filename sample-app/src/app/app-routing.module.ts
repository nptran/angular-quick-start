import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AppComponent } from "./app.component";
import { LayoutComponent } from "./ui/layout/layout.component";

const routes: Routes = [
  {
    path: "",
    redirectTo: "welcome",
    pathMatch: "full"
  },
  {
    path: "welcome",
    loadChildren: "./welcome/welcome.module#WelcomeModule"
  },
  {
    path: "products",
    loadChildren: "./products/products.module#ProductsModule"
  },
  {
    path: "students",
    loadChildren: "./students/students.module#StudentsModule"
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
