package com.rknowsys.estrolo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rknowsys.estrolo.entities.CategoryAPIEntity;
import com.rknowsys.estrolo.service.ServiceCategoryAPI;

@RestController
@RequestMapping("categories")
public class CategoryAPIController {

	@Autowired
	private ServiceCategoryAPI serviceCategory;
	
	@GetMapping(value="/getcategorylist")
	public ResponseEntity<List<CategoryAPIEntity>> getCategoryList(){
		List<CategoryAPIEntity> list =serviceCategory.getAllCategoriesAPI();
		
		return new ResponseEntity<List<CategoryAPIEntity>>(list, HttpStatus.FOUND);
	}
	
	@PostMapping(value="/savecategory")
	public ResponseEntity<String> saveCategory(@RequestBody CategoryAPIEntity category){
		serviceCategory.save(category);
		return new ResponseEntity<String>("Category Saved", HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getcategorybyid/{id}")
	public ResponseEntity<Optional<CategoryAPIEntity>> getCategoryById(@PathVariable Integer id){
		Optional<CategoryAPIEntity> category =serviceCategory.getCategoryById(id);
		return new ResponseEntity<Optional<CategoryAPIEntity>>(category, HttpStatus.FOUND);
	}
	
	@DeleteMapping(value="/deletecategorybyid/{id}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable Integer id){
		serviceCategory.deleteCategoryAPIById(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
	
	@GetMapping(value="/getListByGender/male")
	public ResponseEntity<List<CategoryAPIEntity>> getCategoryListByGender(){
	
		List<CategoryAPIEntity> list =serviceCategory.getByGender();
		return new ResponseEntity<List<CategoryAPIEntity>>(list, HttpStatus.FOUND);
	}
	
}
