package com.leshinskiy.entity.creature.herbivores;

import com.leshinskiy.entity.Entity;
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
        gameMap.moveEntity(getCoordinates(), grass);
        setCoordinates(grass);
    }

    @Override
    public void makeMove(GameMap gameMap) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Queue<Coordinates> path = bfs.pathSearch(getCoordinates(), Grass.class, gameMap);
        System.out.println("Путь херба создан :" + path + "  размер " + path.size());

        if(path.size() > getSpeed()) {

            for(int i = 0; i < path.size(); i++) {

                System.out.println("Херб перешел в (>)" + path.peek());

                Entity entity = gameMap.getEntity(getCoordinates()); // later remake into another private method if possible
                gameMap.removeEntity(getCoordinates());
                setCoordinates(path.poll());
                gameMap.addEntity(entity, getCoordinates());
            }

            return;
        }

        if(path.size() != 1 && path.size() <= getSpeed()) {

            for(int i = path.size(); i == 1; i--) {
                System.out.println("Херб перешел в (<)" + path.peek());
                gameMap.moveEntity(getCoordinates(), path.peek());
                setCoordinates(path.poll());
            }
            return;
        }

        if(path.size() == 1) {
            if(gameMap.getEntity(path.peek()) instanceof Grass) {
                consumeFood(gameMap, path.poll());
                System.out.println("Херб съел траву в " + getCoordinates());
            }
        }

    }
}



