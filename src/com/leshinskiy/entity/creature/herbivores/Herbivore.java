package com.leshinskiy.entity.creature.herbivores;

import com.leshinskiy.entity.Grass;
import com.leshinskiy.entity.creature.Creature;
import com.leshinskiy.main.BreadthFirstSearch;
import com.leshinskiy.main.Coordinates;
import com.leshinskiy.main.GameMap;

import java.util.Queue;

public class Herbivore extends Creature {


    public Herbivore(String emoji, int health, int speed, Coordinates coordinates) {
        super(emoji, health, speed, coordinates);
    }

    public void consumeFood(GameMap gameMap, Coordinates grass){ //consume grass
        gameMap.removeEntity(grass);
        gameMap.moveEntity(getCoordinates(), grass);
        setCoordinates(grass);
    }

    @Override
    public void makeMove(GameMap gameMap) {
        if(getHealth() > 0) {

            BreadthFirstSearch bfs = new BreadthFirstSearch();

            Queue<Coordinates> path = bfs.pathSearch(getCoordinates(), Grass.class, gameMap);


            if (path.size() > getSpeed()) {

                for (int i = 0; i < getSpeed(); i++) {
                    gameMap.moveEntity(getCoordinates(), path.peek());
                    setCoordinates(path.poll());
                }
                return;
            }

            if (path.size() != 1 && path.size() <= getSpeed()) {

                for (int i = getSpeed(); i != 1; i--) {
                    if(path.size() == 1) {
                        continue;
                    }
                    gameMap.moveEntity(getCoordinates(), path.peek());
                    setCoordinates(path.poll());
                }
                return;
            }

            if (path.size() == 1) {
                if (gameMap.getEntity(path.peek()) instanceof Grass) {
                    consumeFood(gameMap, path.poll());
                }
            }
        }
    }
}



