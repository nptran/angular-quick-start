import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product, ProductControllerService } from 'src/swagger';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.scss'],
  providers: [ProductControllerService]
})
export class ProductCreateComponent implements OnInit {

  productForm: FormGroup;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private productService: ProductControllerService
  ) { 
    this.createForm();
  }

  ngOnInit() {
  }

  private createForm() {
    this.productForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      price: ['', Validators.required]
    });
  }

  create() {

    let product: Product = {};
    product.name = this.productForm.value.name;
    product.price = this.productForm.value.price;

    this.productService.createProductsUsingPOST(product).subscribe(res => {
      this.router.navigate(['/products']);
    }, err => {

    });

  }

  cancel(){
    this.router.navigate(['/products']); 
  }

  clear() {
    this.createForm();
  }

}
