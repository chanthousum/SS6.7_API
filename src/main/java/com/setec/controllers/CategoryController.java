package com.setec.controllers;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setec.models.Category;
import com.setec.services.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@GetMapping("")
	public List<Category> getCategoryAll(){
		return categoryService.getCategoryAll();
	}
	@PostMapping("/save")
	public ResponseEntity<Object> save(@RequestBody Category category){
		return categoryService.save(category);
	}
	@GetMapping("/{id}")
	public Category findById(@PathVariable int id) {
		return categoryService.findById(id);
	}
	@PostMapping("/name")
	public List<Category> findByName(@RequestBody Category category){
		return categoryService.findByName(category);
	}
	
	
	
	
	
	
	
	
	
	
	
}
