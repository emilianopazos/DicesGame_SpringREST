package com.SpringGame.DicesGame_JPA.Games;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.SpringGame.DicesGame_JPA.Players.Player;

@Entity
public class Games {
	
	@Id@GeneratedValue
	private int gameId;
	private String gameDate;
	private String gameTime;
	private int dice1;
	private int dice2;
	private int isWin;
	private int playerId;
	//Game playerGames;
	
	@ManyToOne
	private Player player;//Foreign Key
	
	
	public Games() {
					
	}
	
	public Games(int playerId) {
		LocalDate currentDate = LocalDate.now();
		LocalDate currentTime = LocalDate.now(Clock.systemUTC());
		this.setGameDate(currentDate.toString());
		this.gameTime = currentTime.toString();
		this.dice1 = new Random().nextInt(7);
		this.dice2 = new Random().nextInt(7);
		///Decide whether is a Win or Not
		if(this.dice1 == 6 && this.dice2 == 6) {
			//this.setWin(true);
			this.isWin = 1;
		}else {
			//this.setWin(false);
			this.isWin = 0;
		}
		
		//Set Id not connected
		this.setPlayerId(playerId);
		//Set Id Foreign Key
		Player player = new Player();
		player.setPlayerId(playerId);
		this.player = player;		
	}
	


	public int getDice1() {
		return dice1;
	}


	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}


	public int getDice2() {
		return dice2;
	}


	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}


	public String getGameTime() {
		return gameTime;
	}


	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}


	public String getGameDate() {
		return gameDate;
	}


	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}


	public int isWin() {
		return isWin;
	}


	public void setWin(int isWin) {
		this.isWin = isWin;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
	

}
