package com.leshinskiy.action;

import com.leshinskiy.entity.Grass;
import com.leshinskiy.entity.creature.Creature;
import com.leshinskiy.entity.creature.herbivores.Herbivore;
import com.leshinskiy.main.Coordinates;
import com.leshinskiy.main.GameMap;

import java.util.ArrayList;

public class TurnAction {
    public void makeTurn(GameMap gameMap) {
        ArrayList<Creature> creatures = gameMap.arrayOfCreatures();

        for(Creature creature : creatures) {
            creature.makeMove(gameMap);
        }

        //isGrassOnMap(gameMap);

        //isHerbivoresOnMap(gameMap);

    }

    private void isGrassOnMap(GameMap gameMap) {
        ArrayList<Grass> grass = gameMap.arrayOfGrass();

        if(grass.size() < 3) {
            Coordinates coordinates = gameMap.getFreeCoordinates();
            gameMap.addEntity(new Grass(coordinates), coordinates);
        }

    }

    private void isHerbivoresOnMap(GameMap gameMap) {
        ArrayList<Herbivore> herbivores = gameMap.arrayOfHerbivore();

        if(herbivores.size() < 3) {


        }
    }
}
