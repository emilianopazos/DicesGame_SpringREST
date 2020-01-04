package com.SpringGame.DicesGame_JDBC.Players;

import org.springframework.data.repository.CrudRepository;


public interface PlayerRepository extends CrudRepository<Player, Integer>{
	  
//	@Query("select firstName, lastName from User u where u.emailAddress = :email")
//	  User findByEmailAddress(@Param("email") String email);
}
