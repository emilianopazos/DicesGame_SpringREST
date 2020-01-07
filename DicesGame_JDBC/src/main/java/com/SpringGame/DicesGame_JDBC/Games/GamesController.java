package com.SpringGame.DicesGame_JDBC.Games;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {

	@Autowired
	private GamesService gamesService;
	

	/*--POST--*/
	//POST -ADD NEW GAME TO A PLAYER (by playerId)
	@RequestMapping(method=RequestMethod.POST, value = "/players/{playerId}/games")
	public void newGameForPlayer(@PathVariable int playerId) {
		gamesService.addNewGameForPlayer(playerId);
	}
	
	/*--GET--*/
	///GET ALL GAMES for a Player by PlayerId
//	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games")//GET ALL PLAYERS
//	public List<GameDTO> getAllGames(@PathVariable int playerId) {
//		List<GameDTO> allGamesDTO = new ArrayList<>();
//		gamesService.getAllGamesForPlayer(playerId).forEach(game -> allGamesDTO.add(new GameDTO(game)));
//		return allGamesDTO;
//	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games")//GET ALL PLAYERS
	public List<Games> getAllGames(@PathVariable int playerId) {
		//System.out.println("Hola");
		//List<Games> allGamesForPlayer = new ArrayList<>();
		//gamesService.getAllGamesForPlayer(playerId).forEach(game -> allGamesDTO.add(new GameDTO(game)));
		//gamesService.getAllGamesForPlayer(playerId).forEach(game -> allGamesForPlayer.add((Games) game));
		//return allGamesForPlayer;
		//System.out.println(gamesService.getAllGamesForPlayer(playerId));
		
		return gamesService.getAllGamesForPlayer(playerId);
	}
		
	///GET GAME for a Player by GameId. With DTO conversion
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games/{gameId}")//GET ALL PLAYERS
	public GameDTO getGameByGameId(@PathVariable int gameId) {
		return new GameDTO(gamesService.getGameByGameId(gameId).get());
	}
	
	
	/*--DELETE--*/
	@RequestMapping(method=RequestMethod.DELETE, value = "/players/{playerId}/games")
	public void deleteAllGamesForPlayer(@PathVariable int playerId) {
		gamesService.deleteAllGamesForPlayer(playerId);
				
	}
	
	/*--CREATE GAME TABLE--*/
	@RequestMapping(method=RequestMethod.POST, value = "/games/createTables")
	public void createGameTable() {
		gamesService.createGameTable();
				
	}

	
}
