package com.setec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.setec.Exceptions.StudentNotfFoundException;
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

	public ResponseEntity<Object> save(Category category) {
		// TODO Auto-generated method stub
		Category category1=new Category();
		category1.setName(category.getName());
		category1.setCreateBy(category.getCreateBy());
		
		Category category2=categoryRepository.findByName(category1.getName());
		if(category2!=null) {
			throw new StudentNotfFoundException("Category Name has been already!");
		}
		
		categoryRepository.save(category1);
		return new ResponseEntity<Object>("Category created",HttpStatus.CREATED);
	}

	public Category findById(int id) {
		// TODO Auto-generated method stub
		Category category=new Category();
		category=categoryRepository.findCategoryById(id);
		if(category==null) {
			throw new StudentNotfFoundException("Not found id:"+id);
		}
		return category;
	}

	public List<Category> findByName(Category category) {
		// TODO Auto-generated method stub
		List<Category> categoryList=categoryRepository.findCategoryByName(category.getName());
		if(categoryList.size()==0) {
			throw new StudentNotfFoundException("Not found name:"+category.getName());
		}
		return categoryList;
	}

	public ResponseEntity<Object> deleteById(int id) {
		Category category=categoryRepository.findCategoryById(id);
		if(category==null) {
			throw new StudentNotfFoundException("Not found Id:"+id);
		}
		categoryRepository.delete(category);
		return new ResponseEntity<Object>("Categeory Deleted",HttpStatus.OK);
	}

	public ResponseEntity<Object> updateById(int id, Category category) {
		// TODO Auto-generated method stub
		Category category2=categoryRepository.findCategoryById(id);
		if(category2==null) {
			throw new StudentNotfFoundException("Not found Id:"+id);
		}
		category2.setName(category.getName());
		category2.setUpdateBy(category.getUpdateBy());
		categoryRepository.save(category2);
		return new ResponseEntity<Object>("Category Updated",HttpStatus.OK);
	}
 
}
