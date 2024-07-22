package com.leshinskiy.main;

import com.leshinskiy.action.InitAction;
import com.leshinskiy.action.TurnAction;

public class Simulation {
    public void startSimulation(){
        GameMap gameMap = new GameMap();
        Renderer renderer = new Renderer();
        InitAction init = new InitAction();
        TurnAction turn = new TurnAction();
        init.initializeMap(gameMap);



        int i = 0;
        while(true){
            renderer.renderField(gameMap);
            turn.makeTurn(gameMap);
            System.out.println();
        }

    }
}
