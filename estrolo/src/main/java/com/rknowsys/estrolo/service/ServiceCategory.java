package com.rknowsys.estrolo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rknowsys.estrolo.dao.CategoryRepository;
import com.rknowsys.estrolo.entities.Category;
import com.rknowsys.estrolo.entities.CategoryDTO;

@Service
public class ServiceCategory {

	@Autowired
	private CategoryRepository categoryRepository2;

	public void saveCategory(Category category) {
		
		categoryRepository2.save(category);
		
	}
	public Category convertCategory(CategoryDTO categoryDTO) {

		Category category = new Category();

		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setDescription(categoryDTO.getDescription());
		category.setGender(categoryDTO.getGender());
		category.setIsParent(categoryDTO.getIsParent());
		category.setStatus(categoryDTO.getStatus());
		category.setImage(categoryDTO.getImage().getOriginalFilename());
		category.setCreatedAt(new Date());
		category.setUpdatedAt(new Date());

		return category;

	}

	public void saveImageFile(@RequestParam MultipartFile image, String categoryName) {

		String UPLOAD_FOLDER = "src\\main\\webapp\\images\\" + categoryName + "\\";
		File f = new File(UPLOAD_FOLDER);
		if (!f.exists()) {
			f.mkdirs();
		}
		if (image.isEmpty()) {
			return;
		}

		try {
			// read and write the file to the selected location-
			byte[] bytes = image.getBytes();
			System.out.println(f.getAbsolutePath());
			Path path = (Path) Paths.get(f.getAbsolutePath() + "\\" + image.getOriginalFilename());

			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Optional<Category> findById(Integer id) {
		
		Optional<Category> category =categoryRepository2.findById(id);
		return category;
	}

	public List<Category> getAllCategories() {
		List<Category> categoryList = categoryRepository2.findAll();
		return categoryList;
	}

	public void deleteCategoryById(Integer id) {

		categoryRepository2.deleteById(id);

	}

}
