package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long >{

}
