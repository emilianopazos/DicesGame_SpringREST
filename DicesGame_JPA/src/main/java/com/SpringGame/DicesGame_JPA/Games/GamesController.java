package com.SpringGame.DicesGame_JPA.Games;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {

	@Autowired
	private GamesService gamesService;
	
	
	//POST -ADD NEW GAME TO A PLAYER (by playerId)
	@RequestMapping(method=RequestMethod.POST, value = "/players/{playerId}/games")
	public void newGameForPlayer(@PathVariable int playerId) {
		gamesService.addNewGameForPlayer(playerId);
	}
	
	///GET ALL GAMES for a Player by PlayerId
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games")//GET ALL PLAYERS
	public List<Games> getAllGames(@PathVariable int playerId) {
		return gamesService.getAllGames(playerId);
	}
	
	///GET GAME for a Player by GameId
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games/{gameId}")//GET ALL PLAYERS
	public Optional<Games> getGameByGameId(@PathVariable int gameId) {
		return gamesService.getGameByGameId(gameId);
	}
		
}
