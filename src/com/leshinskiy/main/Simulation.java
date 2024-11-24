package com.leshinskiy.main;

import com.leshinskiy.action.InitAction;
import com.leshinskiy.action.TurnAction;

import java.util.Scanner;

public class Simulation {
    private int turnCounter;
    private boolean gameStatus = true;

    GameMap gameMap = new GameMap();
    Renderer renderer = new Renderer();
    InitAction initAction = new InitAction();
    TurnAction turnAction = new TurnAction();

    public void startSimulation() {
        initAction.initializeMap(gameMap);

        while (gameStatus) {
            nextTurn();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void nextTurn() {
        turnCounter++;
        System.out.println("Количество ходов: " + turnCounter + "\n");

        renderer.renderField(gameMap);

        turnAction.makeTurn(gameMap);


    }

}
