import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { ProductsRoutingModule } from "./products-routing.module";
import { ProductsListComponent } from "./products-list/products-list.component";
import { ProductCreateComponent } from './product-create/product-create.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ProductEditComponent } from './product-edit/product-edit.component';

@NgModule({
  declarations: [ProductsListComponent, ProductCreateComponent, ProductEditComponent],
  imports: [CommonModule, ProductsRoutingModule, FormsModule, ReactiveFormsModule]
})
export class ProductsModule {}
