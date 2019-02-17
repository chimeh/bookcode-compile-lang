package com.TrivialDemo.TrivialDemo;

import com.TrivialDemo.TrivialDemo.entities.classes.BaseballGame;
import com.TrivialDemo.TrivialDemo.entities.classes.Cubs;
import com.TrivialDemo.TrivialDemo.entities.classes.RedSox;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.TrivialDemo")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

    /**
     * This goes to find the bean in whichever config file this exists in. Note,
     * this only works if there is one data source. Note, Autowired is autowired
     * by type.
     */
    @Autowired @Qualifier("dataSource")
    private DataSource dataSource;

    /**
     * Note, in general you should put beans you want to scan into the same folder.
     * Resource loads it by name
     */
    @Autowired @Qualifier("redSox")
    private Team home;

    @Autowired @Qualifier("cubs")
    private Team away;

    /**
     * If we have multiple things that match a type (so we have two Teams) then we
     * can initialise a collection with them
     */
    @Autowired
    private List<Team> teams;

    /**
     * This prototype annotation means we get a new instance every time we call for
     * this bean.
     */
    @Bean
    @Scope("prototype")
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(home, away);
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }

}
