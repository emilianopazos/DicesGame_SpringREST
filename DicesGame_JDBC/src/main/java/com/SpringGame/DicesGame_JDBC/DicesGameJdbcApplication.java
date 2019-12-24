package com.SpringGame.DicesGame_JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DicesGameJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicesGameJdbcApplication.class, args);
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	


}
