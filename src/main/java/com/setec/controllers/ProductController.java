package com.setec.controllers;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setec.models.Category;
import com.setec.models.Product;
import com.setec.services.CategoryService;
import com.setec.services.ProductService;

@RestController
@CrossOrigin(origins = {"http://localhost:8091", "http://10.0.2.2:8080"})
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("")
	public List<Product> getProductyAll(){
		return productService.getProductAll();
	}
	@PostMapping("/save")
	public ResponseEntity<Object> save(@RequestBody Product product){
		return productService.save(product);
	}
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}
	@PostMapping("/name")
	public List<Product> findByName(@RequestBody Product product){
		return productService.findByName(product);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateById(@PathVariable int id,@RequestBody Product product){
		return productService.updateById(id,product);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id){
		return productService.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
}
