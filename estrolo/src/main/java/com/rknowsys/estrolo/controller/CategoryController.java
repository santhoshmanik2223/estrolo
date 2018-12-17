package com.rknowsys.estrolo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rknowsys.estrolo.dao.CategoryRepository;
import com.rknowsys.estrolo.entities.Category;
import com.rknowsys.estrolo.entities.CategoryDTO;
import com.rknowsys.estrolo.service.ServiceCategory;

@RestController
@RequestMapping("/categories")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class CategoryController {

	@Autowired
	private CategoryRepository cDao;

	@Autowired
	private ServiceCategory serviceCategory;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public ModelAndView save(@ModelAttribute("categoryForm") CategoryDTO categoryDto) {

		serviceCategory.saveImageFile(categoryDto.getImage(),categoryDto.getCategoryName());

		cDao.save(serviceCategory.convertCategory(categoryDto));
		return new ModelAndView("redirect:/categories/getallcategories");
	}

	

	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public ModelAndView addCategory() {
		ModelAndView model = new ModelAndView();

		Category category = new Category();
		model.addObject("categoryForm", category);
		model.setViewName("savecategory");

		return model;
	}

	@RequestMapping(value = { "/getallcategories" }, method = RequestMethod.GET)
	public ModelAndView getAllcategories() {
		List<Category> categoryList = serviceCategory.getAllCategories();
		ModelAndView model = new ModelAndView();
		model.addObject("categoryList", categoryList);
		model.setViewName("getallcategories");
		return model;
	}

	@GetMapping(value = "/getcategorybyId/{id}")
	public Optional<Category> findCategoryById(@PathVariable("id") Integer id) {

		Optional<Category> category = serviceCategory.findById(id);
		return category;

	}

	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") Integer id) {
		serviceCategory.deleteCategoryById(id);
		return new ModelAndView("redirect:/categories/getallcategories");
	}

	@RequestMapping(value = "/updateCategory/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable Integer id) {
		ModelAndView model = new ModelAndView();
		Optional<Category> category = serviceCategory.findById(id);
		model.addObject("categoryForm", category);
		model.setViewName("updatecategory");
		return model;
	}

	@PostMapping(value = "/save")
	public String saveCategory(@RequestBody Category category) {

		serviceCategory.saveCategory(category);
		return "Saved Successfully";
	}

}
