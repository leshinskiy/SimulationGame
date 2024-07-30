package com.leshinskiy.action;

import com.leshinskiy.entity.Entity;
import com.leshinskiy.entity.Grass;
import com.leshinskiy.entity.creature.Creature;
import com.leshinskiy.entity.creature.herbivores.Herbivore;
import com.leshinskiy.main.Coordinates;
import com.leshinskiy.main.GameMap;

import java.util.ArrayList;

public class TurnAction {
    public void makeTurn(GameMap gameMap) {

        ArrayList<Creature> creatures = gameMap.arrayOfCreatures();

        isGrassOnMap(gameMap);
        isHerbivoresOnMap(gameMap);

        for(Creature creature : creatures) {
            creature.makeMove(gameMap);
        }



    }

    private void isGrassOnMap(GameMap gameMap) {
        CreateAction createAction = new CreateAction();
        ArrayList<Grass> grass = gameMap.arrayOfGrass();

        if(grass.size() < 3) {
           for(int i = 0; i < 3; i++) {
               createAction.spawnGrass(gameMap);
           }
        }

    }

    private void isHerbivoresOnMap(GameMap gameMap) {
        CreateAction createAction = new CreateAction();
        ArrayList<Herbivore> herbivores = gameMap.arrayOfHerbivore();

        if(herbivores.isEmpty()) {
            for(int i = 0; i < 3; i++) {
                createAction.spawnHerbivore(gameMap);
            }
        }
    }


}
