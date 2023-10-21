package com.setec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setec.models.Category;
import com.setec.repositorys.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getCategoryAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
}
