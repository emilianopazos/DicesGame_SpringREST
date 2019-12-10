package com.SpringGame.DicesGame_JPA.Games;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {
	
	@Autowired
	private GamesRepository gamesRepository;

	public void addNewGameForPlayer(int playerId) {
		Games newGame = new Games(playerId);
		gamesRepository.save(newGame);
		
	}

	/*
	 * COPY FROM GAME SERVICE. EDIT WHILE CREATE MAPPING REQUEST IN CONTROLLER
	 * 
	
	//GET PLAYER BY playerId
	public Optional<Games> getPlayerById(int playerId) {
		return gamesRepository.findById(playerId);
	}
	
	///GET ALL PLAYERS
	public List<Games> getAllPlayers() {
		List<Games> allPlayers = new ArrayList<Games>();
		//playerRepository.findAll().forEach(allPlayers::add);	
		gamesRepository.findAll().forEach(p -> allPlayers.add(p));
		return allPlayers;
	}
	
	//POST -ADD NEW PLAYER
	public void addNewPlayer(Games newPlayer) {
		if(newPlayer.getPlayerName()=="") {
			newPlayer.setPlayerName("Anonimo");
		}
		gamesRepository.save(newPlayer);		
	}
	
	//PUT or UPDATE PLAYER
	public void updatePlayer(Games newPlayer) {
		if(newPlayer.getPlayerName()=="") {
			newPlayer.setPlayerName("Anonimo");
		}
		gamesRepository.save(newPlayer);
	}

	//DELETE PLAYER
	public void deletePlayer(int playerId) {
		gamesRepository.deleteById(playerId);
	}
	*/
	
	

}
