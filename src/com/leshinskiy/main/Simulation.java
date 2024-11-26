package com.leshinskiy.main;

import com.leshinskiy.action.InitAction;
import com.leshinskiy.action.TurnAction;

import java.util.Scanner;

public class Simulation {
    private int turnCounter;

    private static volatile boolean running = true;
    private static volatile boolean paused = false;

    GameMap gameMap = new GameMap();
    Renderer renderer = new Renderer();
    InitAction initAction = new InitAction();
    TurnAction turnAction = new TurnAction();

    Thread mainThread = new Thread(() -> {
        System.out.println(
                "===============================\n" +
                "  WELCOME TO GAME SIMULATION\n" +
                "===============================\n" +
                "\n" +
                "The game has started! You now have the ability to manipulate the simulation with the following options:\n" +
                "\n" +
                "1 - Pause the simulation\n" +
                "2 - Resume the simulation\n" +
                "3 - Execute one turn\n" +
                "4 - Stop the simulation\n");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        initAction.initializeMap(gameMap);
        while (running) {
            if (!paused) {
                nextTurn();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });

    Thread menuThread = new Thread(() -> {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":   // pause
                    if(paused) {
                        System.out.println("The program is already paused");
                        break;
                    }
                    paused = true;
                    System.out.println("Paused...");
                    break;
                case "2":   // resume
                    if(!paused) {
                        System.out.println("The program is already resumed");
                        break;
                    }
                    paused = false;
                    System.out.println("Resuming...");
                    break;
                case "3":   // one turn
                    System.out.println("Next turn...");
                    nextTurn();
                    break;
                case "4":   // stop
                    running = false;
                    System.out.println("Stopping...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again. \n 1 - pause, 2 - resume, 3 - one turn, 4 - stop");
            }
        }
        scanner.close();
    });


    private void nextTurn() {
        turnCounter++;
        System.out.println("Turn count: " + turnCounter + "\n");

        renderer.renderField(gameMap);
        turnAction.makeTurn(gameMap);
    }

    public void startSimulation() {
        mainThread.start();
        menuThread.start();
    }

}
