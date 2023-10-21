package com.setec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setec.models.Category;
import com.setec.services.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@GetMapping("/api/v1/category")
	public List<Category> getCategoryAll(){
		return categoryService.getCategoryAll();
	}
}
