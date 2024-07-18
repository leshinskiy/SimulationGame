package action;

import entity.Grass;
import entity.creature.Creature;
import entity.creature.Herbivore;
import main.Coordinates;
import main.GameMap;

import java.util.ArrayList;

public class TurnAction {
    public void makeTurn(GameMap gameMap) {
        ArrayList<Creature> creatures = gameMap.arrayOfCreatures();

        for(Creature creature : creatures) {
            creature.makeMove(gameMap, creature);
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

        if(herbivores.size() < 2) {
            Coordinates coordinates = gameMap.getFreeCoordinates();
            gameMap.addEntity(new Herbivore(1, 20, "🐑", coordinates), coordinates);
        }
    }
}
