package com.SpringGame.DicesGame_JDBC.Statics;

import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringGame.DicesGame_JDBC.Games.Games;
import com.SpringGame.DicesGame_JDBC.Games.GamesService;
import com.SpringGame.DicesGame_JDBC.Players.Player;
import com.SpringGame.DicesGame_JDBC.Players.PlayerDTO;
import com.SpringGame.DicesGame_JDBC.Players.PlayerService;

@RestController
public class StatsController {
	
	@Autowired
	private StatsService statsService;

	@Autowired
	private GamesService gamesService;
	
	@Autowired
	private PlayerService playerService;
	
	//GET General Statics for all Games
	@RequestMapping(method=RequestMethod.GET,value = "/players/stats")//GET STATISTICS FROM ALL PLAYERs 
	public Stats getGeneralStatics() {
		List<Games> everyGame = gamesService.getAllGames();
		return statsService.getStatics(everyGame);
	}
	
	//GET Statics for one player by playerId
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/stats")//GET STATISTICS FROM ALL PLAYERS
	public Stats getStaticsForPlayerById(@PathVariable int playerId) {
		List<Games> allGamesForPlayer = gamesService.getAllGamesForPlayer(playerId);
		return statsService.getStatics(allGamesForPlayer);
	}
	
	//GET Best Player Statics
	@RequestMapping(method=RequestMethod.GET,value = "/players/ranking/winner")
	public PlayerDTO getBestPlayerStatics() {
		//Get all Games
		List<Player> allPlayers = playerService.getAllPlayers();
		allPlayers.forEach(player -> player.setAvgIsWin(statsService.getStatics(gamesService.getAllGamesForPlayer(player.getPlayerId())).getAvgIsWin()));
		allPlayers.sort(Comparator.comparing(Player::getAvgIsWin));//Tested outside App
		return new PlayerDTO(allPlayers.get(allPlayers.size()-1));
	}
	
	//GET Worst Player Statics
	@RequestMapping(method=RequestMethod.GET,value = "/players/ranking/looser")
	public PlayerDTO getWorstPlayerStatics() {
		//Get all Games
		List<Player> allPlayers = playerService.getAllPlayers();
		allPlayers.forEach(player -> player.setAvgIsWin(statsService.getStatics(gamesService.getAllGamesForPlayer(player.getPlayerId())).getAvgIsWin()));
		allPlayers.sort(Comparator.comparing(Player::getAvgIsWin));//Tested outside App
		return new PlayerDTO(allPlayers.get(0));
	}
	
}




















