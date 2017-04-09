package com.GameForAll.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.GameForAll.Repository.CategoryRepository;
import com.GameForAll.models.Category;

public class CategoryServices {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addCategory(Category c) 
	{
		categoryRepository.save(c);
	}
	public Category FindCatgeory(long CategoryId)
	{
		return categoryRepository.findOne(CategoryId);
	}

}
