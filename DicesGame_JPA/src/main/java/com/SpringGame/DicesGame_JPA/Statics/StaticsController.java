package com.SpringGame.DicesGame_JPA.Statics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringGame.DicesGame_JPA.Games.Games;
import com.SpringGame.DicesGame_JPA.Games.GamesService;

@RestController
public class StaticsController {

	@Autowired
	private GamesService gamesService;
	
	//GET General Game Statics
	@RequestMapping(method=RequestMethod.GET,value = "/players/statics")//GET STATICS FROM ALL PLAYERS
	public Statics getGeneralStatics() {
		List<Games> everyGame = gamesService.getEveryGames();
		int qtGames = everyGame.size();
		int qtIsWin = 0;
		//Iterate everyGame_List to know how many are win
		for (int i = 0; i < qtGames; i++) {
			if(everyGame.get(i).getIsWin()==1) {
				qtIsWin += 1;
			}
		}
		System.out.println("qtGames: "+ qtGames + "qtIsWin= "+ qtIsWin);
		Statics generalStats = new Statics(qtGames,qtIsWin);
		return generalStats;
	}
//	public Optional<Games> getGameByGameId() {
//		return gamesService.getGameByGameId(gameId);
//	}
	

}
