package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Contributor;
import com.GameForAll.models.ContributorID;
import com.GameForAll.models.Game;
import com.GameForAll.models.Teacher;

public interface ContributorRepository extends CrudRepository<Contributor, ContributorID> {

	Contributor findByTeacher(Teacher teacher);
	Contributor findByGame(Game game);
	Contributor findByGameAndTeacher(Game game , Teacher teacher);

}
