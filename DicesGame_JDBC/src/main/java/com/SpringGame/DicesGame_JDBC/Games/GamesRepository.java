package com.SpringGame.DicesGame_JDBC.Games;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface GamesRepository extends CrudRepository<Games, Integer>{
	
	//JPA method to findBy..
//	public List<Games> findByPlayerPlayerId(int playerId);
	
	//JDBC query
	@Query(value = "SELECT * FROM games WHERE player_id= :playerId")
	List<Games> findAllGamesForPlayer(@Param("playerId") String playerId);

		
}
