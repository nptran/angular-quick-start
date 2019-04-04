package com.techmaster.sample.controller;

/*This is feature branch*/

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techmaster.sample.model.Product;
import com.techmaster.sample.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {

		return new ResponseEntity<List<Product>>(service.getAll(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Void> createProducts(@RequestBody @Valid Product product) {

		service.save(product);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

		service.delete(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable Long id) {
		return new ResponseEntity<Product>(service.getById(id), HttpStatus.ACCEPTED);
	}

}
