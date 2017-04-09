package com.GameForAll.Repository;


import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Category;

public interface CategoryRepository  extends CrudRepository<Category, Long>{
	
}
