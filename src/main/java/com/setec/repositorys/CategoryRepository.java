package com.setec.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setec.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

	Category findCategoryById(int id);

	List<Category> findCategoryByName(String name);

	Category findByName(String name);

}
