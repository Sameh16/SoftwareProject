package com.GameForAll.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Game;
import com.GameForAll.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	public List<Question> findBygame(Game game);
}
