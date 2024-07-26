package com.leshinskiy.action;


import com.leshinskiy.main.GameMap;

public class InitAction extends Actions{

    public void initializeMap(GameMap gameMap) {
        CreateAction createAction = new CreateAction();

        createAction.spawnHerbivore(gameMap);
        createAction.spawnHerbivore(gameMap);
        createAction.spawnHerbivore(gameMap);
        createAction.spawnHerbivore(gameMap);
        createAction.spawnHerbivore(gameMap);




        createAction.spawnPredator(gameMap);
        createAction.spawnPredator(gameMap);
        createAction.spawnPredator(gameMap);


        createAction.spawnGrass(gameMap);
        createAction.spawnGrass(gameMap);
        createAction.spawnGrass(gameMap);
        createAction.spawnGrass(gameMap);
        createAction.spawnGrass(gameMap);
        createAction.spawnGrass(gameMap);
        createAction.spawnGrass(gameMap);



        createAction.spawnRock(gameMap);
        createAction.spawnRock(gameMap);
        createAction.spawnRock(gameMap);
        createAction.spawnRock(gameMap);


        createAction.spawnTree(gameMap);
        createAction.spawnTree(gameMap);
        createAction.spawnTree(gameMap);
        createAction.spawnTree(gameMap);
        createAction.spawnTree(gameMap);
    }


}
