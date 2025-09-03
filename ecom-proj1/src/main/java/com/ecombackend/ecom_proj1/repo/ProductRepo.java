package com.ecombackend.ecom_proj1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecombackend.ecom_proj1.model.Product;



@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}