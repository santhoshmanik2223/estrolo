package com.rknowsys.estrolo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rknowsys.estrolo.dao.CategoryAPIRepository;
import com.rknowsys.estrolo.entities.CategoryAPIEntity;

@Service
public class ServiceCategoryAPI {

	@Autowired
	private CategoryAPIRepository categoryRepository;
	
	public void save(CategoryAPIEntity category) {
		categoryRepository.save(category);
	}


	public List<CategoryAPIEntity> getAllCategoriesAPI() {
		List<CategoryAPIEntity> categoryList = categoryRepository.findAll();
		return categoryList;
	}
	
	public Optional<CategoryAPIEntity> getCategoryById(Integer id) {

		Optional<CategoryAPIEntity> item = categoryRepository.findById(id);
		return item;
	}
	
	public void deleteCategoryAPIById(Integer id) {

		categoryRepository.deleteById(id);

	}
	
	public List<CategoryAPIEntity> getByGender() {

		List<CategoryAPIEntity> list = categoryRepository.findAll();

		for (int i = 0; i < list.size(); i++) {
			CategoryAPIEntity category = (CategoryAPIEntity) list.get(i);
			if (!category.getGender().equalsIgnoreCase("Male") && !category.getGender().equalsIgnoreCase("Unisex")) {
				list.remove(i);
				i--;
			}
		}
		return list;
	}
}
