package com.TrivialDemo.TrivialDemo.entities.interfaces;

import javax.sql.DataSource;

public interface Game {
    void setHomeTeam(Team team);
    void setAwayTeam(Team team);
    void setDataSource(DataSource dataSource);
    Team getHomeTeam();
    Team getAwayTeam();
    String playGame();
}
