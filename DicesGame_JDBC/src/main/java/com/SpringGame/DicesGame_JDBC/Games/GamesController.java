package com.SpringGame.DicesGame_JDBC.Games;

import java.util.ArrayList;
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
	

	/*--POST--*/
	//POST -ADD NEW GAME TO A PLAYER (by playerId)
	@RequestMapping(method=RequestMethod.POST, value = "/players/{playerId}/games")
	public void newGameForPlayer(@PathVariable int playerId) {
		gamesService.addNewGameForPlayer(playerId);
	}
	
	/*--GET--*/
	///GET ALL GAMES for a Player by PlayerId
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games")//GET ALL PLAYERS
	public List<GameDTO> getAllGames(@PathVariable int playerId) {
		List<GameDTO> allGamesDTO = new ArrayList<>();
		gamesService.getAllGamesForPlayer(playerId).forEach(game -> allGamesDTO.add(new GameDTO(game)));
		return allGamesDTO;
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
	

	
}
