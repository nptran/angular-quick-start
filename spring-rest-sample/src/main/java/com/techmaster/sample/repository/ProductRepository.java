package com.techmaster.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techmaster.sample.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
