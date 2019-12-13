package com.SpringGame.DicesGame_JPA.Games;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {

	@Autowired
	private GamesService gamesService;
	
    @Autowired
    private ModelMapper modelMapper;
    //To do explicit mapping CHECK
//	PropertyMap<Games, GameDTO> gameMap = new PropertyMap<Games, GameDTO>() {
//		  protected void configure() {
//		    
//		    map(source.getDice1(), destination.dice1);
//		  }
//		};
		
	//POST -ADD NEW GAME TO A PLAYER (by playerId)
	@RequestMapping(method=RequestMethod.POST, value = "/players/{playerId}/games")
	public void newGameForPlayer(@PathVariable int playerId) {
		gamesService.addNewGameForPlayer(playerId);
	}
	
	///GET ALL GAMES for a Player by PlayerId
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games")//GET ALL PLAYERS
	public List<Games> getAllGames(@PathVariable int playerId) {
		return gamesService.getAllGamesForPlayer(playerId);
	}
	
	///GET GAME for a Player by GameId
//	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games/{gameId}")//GET ALL PLAYERS
//	public Optional<Games> getGameByGameId(@PathVariable int gameId) {
//		return gamesService.getGameByGameId(gameId);
//	}
	///GET GAME for a Player by GameId. With DTO conversion
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games/{gameId}")//GET ALL PLAYERS
	public GameDTO getGameByGameId(@PathVariable int gameId) {
		return convertToDto(gamesService.getGameByGameId(gameId));
	}
	
	//GET game by GameId converted to GameDTO (include only playerId) Special mapping for DTO, used while generating DTO transformation
	@RequestMapping(method=RequestMethod.GET, value = "/players/{playerId}/games/DTO/{gameId}")
	public GameDTO getPlayerDTO(@PathVariable int gameId) {
		Optional<Games> requestedGame = gamesService.getGameByGameId(gameId);
		return 	convertToDto(requestedGame);
	}
	
	
	///Conversion to DTO method()
	private GameDTO convertToDto(Optional<Games> requestedGame) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		GameDTO reqGameDTO = modelMapper.map(requestedGame.get(), GameDTO.class);
		return reqGameDTO;
	}
}
