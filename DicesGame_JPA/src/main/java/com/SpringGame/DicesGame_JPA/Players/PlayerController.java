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
	
//    @Autowired
//    private ModelMapper modelMapper;
	
	///GET ALL PLAYERS
	@RequestMapping("/players")//GET ALL PLAYERS
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}
	
	///GET PLAYER BY ID
	@RequestMapping(method=RequestMethod.GET, value = "/players/{playerId}")
	public Optional<Player> getPlayer(@PathVariable int playerId) {
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
	
//	//GET player by id converted to DTO
//	@RequestMapping(method=RequestMethod.GET, value = "/players/DTO/{playerId}")
//	public PlayerDTO getPlayerDTO(@PathVariable int playerId) {
//		Optional<Player> requestedPlayer = playerService.getPlayerById(playerId);
//		return 	convertToDto(requestedPlayer);
//	}
//	
//	private PlayerDTO convertToDto(Optional<Player> requestedPlayer) {
//		modelMapper.addMappings(propertyMap)
//		PlayerDTO reqPlayerDTO = modelMapper.map(requestedPlayer, PlayerDTO.class);
//		modelMapper.
//		return reqPlayerDTO;
////	    PostDto postDto = modelMapper.map(post, PostDto.class);
////	    postDto.setSubmissionDate(post.getSubmissionDate(), 
////	        userService.getCurrentUser().getPreference().getTimezone());
////	    return postDto;
////}
}
