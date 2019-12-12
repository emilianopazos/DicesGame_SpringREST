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
	//Change name to getAllGamesForPlayer
	public List<Games> getAllGames(int playerId) {
		List<Games> allGamesForPlayer = new ArrayList<>();
		gamesRepository.findByPlayerPlayerId(playerId).forEach(allGamesForPlayer::add);
		return allGamesForPlayer;
	}

	public Optional<Games> getGameByGameId(int gameId) {
		return gamesRepository.findById(gameId);
	}
	
	public List<Games> getEveryGames() {
		List<Games> allGames = new ArrayList<>();
		gamesRepository.findAll().forEach(allGames::add);
		return allGames;
	}
	
	
	

}
