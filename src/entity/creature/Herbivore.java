package entity.creature;

import entity.Entity;
import entity.Grass;
import main.BreadthFirstSearch;
import main.Coordinates;
import main.GameMap;

import java.util.HashMap;
import java.util.Map;

public class Herbivore extends Creature {

    public Herbivore(int speed, int health, String emoji, Coordinates coordinates) {
        super(speed, health, emoji, coordinates);
    }



    public void consumeGrass(GameMap gameMap, Coordinates grass){
        gameMap.removeEntity(grass);
    }

    @Override
    public void makeMove(GameMap gameMap, Creature herbivore) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        Grass grass = findGrass(gameMap);
        HashMap<Coordinates, Coordinates> path = bfs.breadthSearch(herbivore.getCoordinates(), grass.getCoordinates(), gameMap);
        int distance = path.size();


        if(distance <=  getSpeed()) {
            consumeGrass(gameMap, grass.getCoordinates());
            gameMap.moveEntity(herbivore.getCoordinates(), grass.getCoordinates());
            setCoordinates(path.get(getCoordinates()));
        }
        if(distance > getSpeed()) {
            for (int i = 0; i < getSpeed(); i++) { // herbivore moves *getSpeed()*  times making it look like it went straight for example 3 cells
                gameMap.moveEntity(getCoordinates(), path.get(getCoordinates()));
                setCoordinates(path.get(getCoordinates()));
            }
        }

    }


    private Grass findGrass(GameMap gameMap) {

        for (Map.Entry<Coordinates, Entity> entry : gameMap.getMap().entrySet()) {
            Entity value = entry.getValue();
            if (value instanceof Grass) {
                return (Grass) value;
            }
        }
        Grass grass = new Grass(gameMap.getFreeCoordinates()); // add grass if there is not a single one
        gameMap.addEntity(grass, grass.getCoordinates());
        return grass;
    }
}



