package com.ecombackend.ecom_proj1.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecombackend.ecom_proj1.model.Product;
import com.ecombackend.ecom_proj1.repo.ProductRepo;




@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;

	public List<Product> getProducts() {
		
		 List<Product> products = repo.findAll();
	        System.out.println("Products: " + products);  
	        return products;				
	}
	
	public Product getProductById(int id) {
//		  return  repo.findById(id).orElse(new Product());	
		  return  repo.findById(id).orElse(null);	
	}
	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImagetype(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		return repo.save(product);
	}
	public Product updateProduct(int id,Product product, MultipartFile imageFile) throws IOException {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImagetype(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		return repo.save(product);
	}
	public void deleteProduct(int id) {
		 repo.deleteById(id);
	}
	
	public List<Product> searchProducts(String keyword) {
		return repo.searchProduct(keyword);
	}
	

}
