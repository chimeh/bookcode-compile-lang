package com.TrivialDemo.TrivialDemo;

import com.TrivialDemo.TrivialDemo.entities.classes.BaseballGame;
import com.TrivialDemo.TrivialDemo.entities.classes.Cubs;
import com.TrivialDemo.TrivialDemo.entities.classes.RedSox;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Team;

public class RunWithoutSpring {

    public static void main(String[] args) {
        Team redSox = new RedSox();
        Team cubs = new Cubs();
        Game baseballGame = new BaseballGame(redSox, cubs);
        System.out.println(baseballGame.playGame());
    }

}
