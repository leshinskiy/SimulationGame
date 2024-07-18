package action;


import entity.creature.Creature;
import entity.creature.Herbivore;
import entity.creature.Predator;
import main.GameMap;

public class InitAction extends Actions{

    public void initializeMap(GameMap gameMap) {
        Creature tiger1 = new Predator(gameMap.getFreeCoordinates(), "🐯", 100, 3, 50);

        gameMap.addEntity(tiger1, tiger1.getCoordinates());


        Creature sheep1 = new Herbivore(1, 100, "🐑",  gameMap.getFreeCoordinates());


        gameMap.addEntity(sheep1, sheep1.getCoordinates());

    }


}
