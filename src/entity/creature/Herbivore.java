package entity.creature;

import entity.Entity;
import entity.Grass;
import main.BreadthFirstSearch;
import main.Coordinates;
import main.GameMap;
import main.Renderer;

import java.util.Map;
import java.util.Queue;

public class Herbivore extends Creature {


    public Herbivore(String emoji, int health, int speed, Coordinates coordinates) {
        super(emoji, health, speed, coordinates);
    }

    public void consumeGrass(GameMap gameMap, Coordinates grass){
        gameMap.removeEntity(grass);
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

        if(path.size() <= getSpeed()) {

            for(int i = path.size(); i == 1; i--) {
                System.out.println("Херб перешел в (<)" + path.peek());

                Entity entity = gameMap.getEntity(getCoordinates());
                gameMap.removeEntity(getCoordinates());
                setCoordinates(path.poll());
                gameMap.addEntity(entity, getCoordinates());
            }

            consumeGrass(gameMap, path.poll());
            setCoordinates(path.peek());
            System.out.println("Херб съел траву в " + getCoordinates());
        }

    }
}



