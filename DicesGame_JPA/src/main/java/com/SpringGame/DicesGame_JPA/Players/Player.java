package com.SpringGame.DicesGame_JPA.Players;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	private int playerId;
	private String playerLogName;
	private String playerLogPass;
	private  String playerName;
	private  String playerRegDate;
	//Game playerGames;
	
	public Player() {
		LocalDate currentTime = LocalDate.now();
		this.playerRegDate = currentTime.toString(); 
	}
	
	public Player(String playerLogName, String playerLogPass, String playerName) {
		this.setPlayerLogName(playerLogName);
		this.setPlayerLogPass(playerLogPass);
		this.playerName = playerName;
		//Date regDate = LocalDate.now();
	}
	public Player(String playerLogName, String playerLogPass) {
		this.setPlayerLogName(playerLogName);
		this.setPlayerLogPass(playerLogPass);
		this.playerName = "Anonimo";
		//Date regDate = LocalDate.now();
	}
	

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerLogName() {
		return playerLogName;
	}

	public void setPlayerLogName(String playerLogName) {
		this.playerLogName = playerLogName;
	}

	public String getPlayerLogPass() {
		return playerLogPass;
	}

	public void setPlayerLogPass(String playerLogPass) {
		this.playerLogPass = playerLogPass;
	}

	public String getPlayerRegDate() {
		return playerRegDate;
	}

	public void setPlayerRegDate(String playerRegDate) {
		this.playerRegDate = playerRegDate;
	}
	
	
	

}
