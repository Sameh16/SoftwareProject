package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.StudentGame;
import com.GameForAll.models.StudentGameID;

public interface StudentGameRepository extends CrudRepository<StudentGame, StudentGameID> {

}
