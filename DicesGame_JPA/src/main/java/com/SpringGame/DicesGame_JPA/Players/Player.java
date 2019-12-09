package com.SpringGame.DicesGame_JPA.Players;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	private int playerId;
	private String playerLogName;
	private String playerLogPass;
	private  String playerName;
	//private  Date playerRegDate;
	//Game playerGames;
	
	public Player() {
		super();
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
/*
	public Date getPlayerRegDate() {
		return playerRegDate;
	}

	public void setPlayerRegDate(Date playerRegDate) {
		this.playerRegDate = playerRegDate;
	}
*/
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
	
	
	

}
