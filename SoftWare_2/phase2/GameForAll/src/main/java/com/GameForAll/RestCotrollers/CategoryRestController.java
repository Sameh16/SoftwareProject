package com.GameForAll.RestCotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CategoryRepository;
import com.GameForAll.models.Category;

@RestController
public class CategoryRestController {
	@Autowired
	CategoryRepository repostry;

	@RequestMapping(value = "/addcategory" )
	public boolean SaveCategory()
	{
		if(repostry.save(new Category("Ehab")  )!=null)
			return true;
		return false;
	}
	
}
