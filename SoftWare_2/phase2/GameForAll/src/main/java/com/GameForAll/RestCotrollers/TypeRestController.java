package com.GameForAll.RestCotrollers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GameForAll.Repository.CourseRepository;
import com.GameForAll.Repository.TypeRepository;
import com.GameForAll.models.Category;
import com.GameForAll.models.Course;
import com.GameForAll.models.Type;


@RestController
public class TypeRestController {
	@Autowired
	private TypeRepository typeRepository;
	@RequestMapping(value = "/game/get-type", method = RequestMethod.GET)
	public List<Type> GetAllTypes() {
		return (List<Type>) typeRepository.findAll();
	}
}
