package com.leshinskiy.action;

import com.leshinskiy.entity.Entity;
import com.leshinskiy.entity.Grass;
import com.leshinskiy.entity.creature.herbivores.Herbivore;
import com.leshinskiy.entity.creature.predators.Predator;
import com.leshinskiy.entity.stationary.Rock;
import com.leshinskiy.entity.stationary.Tree;
import com.leshinskiy.main.GameMap;

public class CreateAction {
    public void spawnHerbivore(GameMap gameMap) {
        Entity herbivore = new Herbivore("🐑", 5, 2, gameMap.getFreeCoordinates());
        gameMap.addEntity(herbivore, herbivore.getCoordinates());
    }

    public void spawnPredator(GameMap gameMap) {
        Entity predator = new Predator("🐅", 10, 3, 2, gameMap.getFreeCoordinates());
        gameMap.addEntity(predator, predator.getCoordinates());
    }

    public void spawnGrass(GameMap gameMap) {
        Entity grass = new Grass(gameMap.getFreeCoordinates());
        gameMap.addEntity(grass, grass.getCoordinates());
    }

    public void spawnRock(GameMap gameMap) {
        Entity rock = new Rock(gameMap.getFreeCoordinates());
        gameMap.addEntity(rock, rock.getCoordinates());
    }

    public void spawnTree(GameMap gameMap) {
        Entity tree = new Tree(gameMap.getFreeCoordinates());
        gameMap.addEntity(tree, tree.getCoordinates());
    }
}
