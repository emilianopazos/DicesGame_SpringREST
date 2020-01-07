package com.SpringGame.DicesGame_JDBC.Games;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GamesRowMapper implements RowMapper<Games>{
	
	@Override
    public Games mapRow(ResultSet rs, int rowNum) throws SQLException {
        Games game = new Games();
 
        game.setGameId((rs.getInt("game_id")));
        game.setGameDateTime((rs.getString("game_date_time")));
        game.setDice1((rs.getInt("dice1")));
        game.setDice2((rs.getInt("dice2")));
        game.setIsWin((rs.getInt("is_win")));
        game.setPlayerId((rs.getInt("player_id")));
        return game;
    }

}
