package com.GameForAll.Repository;




import org.springframework.data.repository.CrudRepository;
import com.GameForAll.models.Game;


public interface GameRepository  extends CrudRepository<Game, Long>{
	
}
