package com.GameForAll.RestCotrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.GameForAll.models.Category;
import com.GameForAll.services.CategoryServices;


@RestController
public class CategoryRestController {
	@Autowired
	private CategoryServices categoryServices;
	
	@RequestMapping(method=RequestMethod.POST,value="/addcategory")
	public void AddCatgeory(@RequestBody  Category c)
	{
		categoryServices.addCategory(c);
	}
	
}
