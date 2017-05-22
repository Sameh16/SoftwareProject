package com.GameForAll.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.GameForAll.models.Answer;
import com.GameForAll.models.Question;


public interface AnswerRepository extends CrudRepository<Answer, Long> {
	public List<Answer> findByquestion(Question question);

}
