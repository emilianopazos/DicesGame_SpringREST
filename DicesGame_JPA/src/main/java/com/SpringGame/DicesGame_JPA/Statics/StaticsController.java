package com.SpringGame.DicesGame_JPA.Statics;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringGame.DicesGame_JPA.Games.Games;
import com.SpringGame.DicesGame_JPA.Games.GamesService;

@RestController
public class StaticsController {
	
	@Autowired
	private StaticsService statsService;

	@Autowired
	private GamesService gamesService;
	
	//GET General Statics for all Games
	@RequestMapping(method=RequestMethod.GET,value = "/players/statics")//GET STATICS FROM ALL PLAYERS
	public Statics getGeneralStatics() {
//		List<Games> everyGame = gamesService.getAllGames();
//		int qtGames = everyGame.size();
//		int qtIsWin = 0;
//		//Iterate everyGame(List) to know how many are win
//		for (int i = 0; i < qtGames; i++) {
//			if(everyGame.get(i).getIsWin()==1) {
//				qtIsWin += 1;
//			}
//		}
//		//System.out.println("qtGames: "+ qtGames + "qtIsWin= "+ qtIsWin);
//		Statics generalStats = new Statics(qtGames,qtIsWin);
//		return generalStats;
		List<Games> everyGame = gamesService.getAllGames();
		return statsService.getStatics(everyGame);
	}
	
	//GET Statics for one player by playerId
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/statics")//GET STATICS FROM ALL PLAYERS
	public Statics getStaticsForPlayerById(@PathVariable int playerId) {
//		List<Games> allGamesForPlayer = gamesService.getAllGamesForPlayer(playerId);
//		int qtGames = allGamesForPlayer.size();
//		int qtIsWin = 0;
//		//Iterate allGameForPlayer(List) to know how many are win
//		for (int i = 0; i < qtGames; i++) {
//			if(allGamesForPlayer.get(i).getIsWin()==1) {
//				qtIsWin += 1;
//			}
//		}
//		//System.out.println("qtGames: "+ qtGames + "qtIsWin= "+ qtIsWin);
//		Statics playerStats = new Statics(qtGames,qtIsWin);
//		return playerStats;
		List<Games> allGamesForPlayer = gamesService.getAllGamesForPlayer(playerId);
		return statsService.getStatics(allGamesForPlayer);
		
	}
	
}
