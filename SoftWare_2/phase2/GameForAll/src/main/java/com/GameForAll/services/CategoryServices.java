package com.GameForAll.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GameForAll.Repository.CategoryRepository;
import com.GameForAll.models.Category;

@Service
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
	
	public ArrayList<Category> showall()
	{
		return (ArrayList<Category>) categoryRepository.findAll();
	}

}
