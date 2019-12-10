package com.SpringGame.DicesGame_JPA.Players;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	///GET ALL PLAYERS
	@RequestMapping("/players")//GET ALL PLAYERS
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}
	
	///GET PLAYER BY ID
	@RequestMapping(method=RequestMethod.GET, value = "/players/{playerId}")
	public Optional<Player> Player(@PathVariable int playerId) {
		return playerService.getPlayerById(playerId);
	}
	
	//POST -ADD NEW PLAYER
	@RequestMapping(method=RequestMethod.POST, value = "/players")
	public void addNewPlayer(@RequestBody Player newPlayer) {
		playerService.addNewPlayer(newPlayer);
	}
	
	//POST -ADD NEW PLAYER
	@RequestMapping(method=RequestMethod.PUT, value = "/players")
	public void updatePlayer(@RequestBody Player newPlayer) {		
		playerService.updatePlayer(newPlayer);
	}
	
	//DELETE PLAYER
	@RequestMapping(method=RequestMethod.DELETE, value = "/players/{playerId}")
	public void deletePlayer(@PathVariable int playerId) {
		playerService.deletePlayer(playerId);
	}
	
	
}
