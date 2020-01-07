package com.SpringGame.DicesGame_JDBC.Players;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PlayerRowMapper implements RowMapper<Player>{
	
	@Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();
 
        player.setPlayerId((rs.getInt("player_id")));
        player.setPlayerLogName((rs.getString("player_log_name")));
        player.setPlayerLogPass((rs.getString("player_log_pass")));
        player.setPlayerName((rs.getString("player_name")));
        player.setPlayerRegDate((rs.getString("player_reg_date")));
        return player;
    }

}
