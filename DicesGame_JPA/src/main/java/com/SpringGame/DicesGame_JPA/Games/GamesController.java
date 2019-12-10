package com.SpringGame.DicesGame_JPA.Games;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringGame.DicesGame_JPA.Players.PlayerService;

@RestController
public class GamesController {

	@Autowired
	private GamesService gamesService;
	
	@Autowired
	private PlayerService playerService;
	
	//POST -ADD NEW GAME TO A PLAYER (by playerId)
	@RequestMapping(method=RequestMethod.POST, value = "/players/{playerId}/games")
	public void newGameForPlayer(@PathVariable int playerId) {
		gamesService.addNewGameForPlayer(playerId);
//		System.out.println(playerId);
	}
	
	
	
	
	
	/*
	 * COPY FROM GAME CONTROLLER. EDIT WHILE CREATE MAPPING REQUEST AND EDIT SERVICE
	 * 
	///GET ALL PLAYERS
	@RequestMapping("/players")//GET ALL PLAYERS
	public List<Games> getAllPlayers() {
		return gamesService.getAllPlayers();
	}
	
	///GET PLAYER BY ID
	@RequestMapping(method=RequestMethod.GET, value = "/players/{playerId}")
	public Optional<Games> Player(@PathVariable int playerId) {
		return gamesService.getPlayerById(playerId);
	}
	
	//POST -ADD NEW PLAYER
	@RequestMapping(method=RequestMethod.POST, value = "/players")
	public void addNewPlayer(@RequestBody Games newPlayer) {
		gamesService.addNewPlayer(newPlayer);
	}
	
	//POST -ADD NEW PLAYER
	@RequestMapping(method=RequestMethod.PUT, value = "/players")
	public void updatePlayer(@RequestBody Games newPlayer) {		
		gamesService.updatePlayer(newPlayer);
	}
	
	//DELETE PLAYER
	@RequestMapping(method=RequestMethod.DELETE, value = "/players/{playerId}")
	public void deletePlayer(@PathVariable int playerId) {
		gamesService.deletePlayer(playerId);
	}
	*/
	
}
