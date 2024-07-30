package com.leshinskiy.action;


import com.leshinskiy.main.GameMap;

public class InitAction extends Actions{
    public final int HERBIVORE_COUNT = 6;
    public final int PREDATOR_COUNT = 3;
    public final int GRASS_COUNT = 8;
    public final int ROCK_COUNT = 4;
    public final int TREE_COUNT = 5;

    public void initializeMap(GameMap gameMap) {
        CreateAction createAction = new CreateAction();

        for(int i = 0; i < HERBIVORE_COUNT; i++) {
            createAction.spawnHerbivore(gameMap);
        }




        for(int i = 0; i < PREDATOR_COUNT; i++) {
            createAction.spawnPredator(gameMap);
        }


        for(int i = 0; i < GRASS_COUNT; i++) {
            createAction.spawnGrass(gameMap);
        }



        for(int i = 0; i < ROCK_COUNT; i++) {
            createAction.spawnRock(gameMap);
        }


        for(int i = 0; i < TREE_COUNT; i++) {
            createAction.spawnTree(gameMap);
        }
    }


}
