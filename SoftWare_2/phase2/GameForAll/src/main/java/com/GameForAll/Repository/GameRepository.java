package com.GameForAll.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Game;



public interface GameRepository  extends CrudRepository<Game, Long>{
	public List<Game> findBygameNameStartingWith(String name);
	public List<Game> findBygameName(String name);
}	
