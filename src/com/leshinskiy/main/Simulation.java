package com.leshinskiy.main;

import com.leshinskiy.action.CreateAction;
import com.leshinskiy.action.InitAction;
import com.leshinskiy.action.TurnAction;

import java.util.Scanner;

public class Simulation {
    private int turnCounter;
    private boolean gameStatus = false;
    GameMap gameMap = new GameMap();
    Renderer renderer = new Renderer();
    InitAction initAction = new InitAction();
    TurnAction turnAction = new TurnAction();
    public void startSimulation(){
        initAction.initializeMap(gameMap);

        gameStatus = true;
        while(gameStatus) {
            nextTurn();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Если вы хотите продолжить нажмите Enter или введите любой символ\nЕсли вы хотите остановить симуляцию введите Y");
                String playerStatus;

                do {
                    playerStatus = scanner.nextLine();
                } while (playerStatus.length() > 1);

                if("y".equalsIgnoreCase(playerStatus)) {
                    pauseSimulation();
                } else {
                    System.out.println("Продолжаю игру...\n");
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void nextTurn() {
        turnCounter++;
        System.out.println("Количество ходов: " + turnCounter + "\n");

        renderer.renderField(gameMap);

        turnAction.makeTurn(gameMap);


    }

    public void pauseSimulation() {
        System.out.println("Симуляция остановлена...");
        gameStatus = false;
    }


}
