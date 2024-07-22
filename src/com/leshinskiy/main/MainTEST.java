package com.leshinskiy.main;

import com.leshinskiy.action.TurnAction;
import com.leshinskiy.entity.Entity;
import com.leshinskiy.entity.Grass;
import com.leshinskiy.entity.creature.Creature;
import com.leshinskiy.entity.creature.herbivores.Herbivore;
import com.leshinskiy.entity.creature.predators.Predator;

public class MainTEST {
    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        TurnAction turnAction = new TurnAction();
        Renderer renderer = new Renderer();


        Herbivore herbivore1 = new Herbivore("🐄", 5, 1, new Coordinates(1, 0));
        gameMap.addEntity(herbivore1, herbivore1.getCoordinates());
        Herbivore herbivore2 = new Herbivore("🐄", 5, 1, new Coordinates(0,0));
        gameMap.addEntity(herbivore2, herbivore2.getCoordinates());
        Herbivore herbivore3 = new Herbivore("🐄", 5, 1, new Coordinates(0,1));
        gameMap.addEntity(herbivore3, herbivore3.getCoordinates());
        Herbivore herbivore4 = new Herbivore("🐄", 5, 1, new Coordinates(1,1));
        gameMap.addEntity(herbivore4, herbivore4.getCoordinates());
        Herbivore herbivore5 = new Herbivore("🐄", 5, 1, gameMap.getFreeCoordinates());
        gameMap.addEntity(herbivore5, herbivore5.getCoordinates());
        Herbivore herbivore6 = new Herbivore("🐄", 5, 1, gameMap.getFreeCoordinates());
        gameMap.addEntity(herbivore6, herbivore6.getCoordinates());
        Herbivore herbivore7 = new Herbivore("🐄", 5, 1, gameMap.getFreeCoordinates());
        gameMap.addEntity(herbivore7, herbivore7.getCoordinates());

        Entity grass = new Grass(new Coordinates(9,9));
        gameMap.addEntity(grass, grass.getCoordinates());
        Entity grass1 = new Grass(gameMap.getFreeCoordinates());
        gameMap.addEntity(grass1, grass1.getCoordinates());
        Entity grass2 = new Grass(gameMap.getFreeCoordinates());
        gameMap.addEntity(grass2, grass2.getCoordinates());
        Entity grass3 = new Grass(gameMap.getFreeCoordinates());
        gameMap.addEntity(grass3, grass3.getCoordinates());
        Entity grass4 = new Grass(gameMap.getFreeCoordinates());
        gameMap.addEntity(grass4, grass4.getCoordinates());

        Predator predator = new Predator("🐻", 10, 4, 2, gameMap.getFreeCoordinates());
        gameMap.addEntity(predator, predator.getCoordinates());

        Predator predator2 = new Predator("🐻", 10, 4, 2, gameMap.getFreeCoordinates());
        gameMap.addEntity(predator2, predator2.getCoordinates());

        Predator predator3 = new Predator("🐻", 10, 4, 2, gameMap.getFreeCoordinates());
        gameMap.addEntity(predator3, predator3.getCoordinates());


        renderer.renderField(gameMap);
        for (int i = 0; i < 10; i++) {

            herbivore1.makeMove(gameMap);
            herbivore2.makeMove(gameMap);
            herbivore3.makeMove(gameMap);
            herbivore4.makeMove(gameMap);
            predator.makeMove(gameMap);
            predator2.makeMove(gameMap);
            predator3.makeMove(gameMap);
            renderer.renderField(gameMap);
        }









    }
}
