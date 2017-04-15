package com.GameForAll.RestCotrollers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CategoryRepository;

import com.GameForAll.models.Category;



@RestController
public class CategoryRestController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/game/get-category", method = RequestMethod.GET)
	public List<Category> GetAllCategories() {
		List<Category> categories = new ArrayList<>();
		categories = (List<Category>) categoryRepository.findAll();
		return categories; 
	}
	
	@RequestMapping(value = "/course/get-category", method = RequestMethod.GET)
	public List<Category> GetAlCategories() {
		List<Category> categories = new ArrayList<>();
		categories = (List<Category>) categoryRepository.findAll();
		return categories; 
	}
}
