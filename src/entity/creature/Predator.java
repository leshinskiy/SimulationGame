package entity.creature;

import main.BreadthFirstSearch;
import main.Coordinates;
import main.GameMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Predator extends Creature {

    private final int attackDamage;


    public Predator(Coordinates coordinates, String emoji, int health, int speed, int attackDamage) {
        super(speed, health, emoji, coordinates);
        this.attackDamage = attackDamage;
    }



    @Override
    public void makeMove(GameMap gameMap, Creature predator){
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Herbivore herbivore = findHerbivore(gameMap);
        System.out.println("хербивор: \n" + herbivore);


        HashMap<Coordinates, Coordinates> path = bfs.breadthSearch(predator.getCoordinates(), herbivore.getCoordinates(), gameMap);

        int distance = path.size(); // distance to Herbivore
        
        if(distance <= getSpeed()) {
            for (int i = 0; i < distance - 1; i++) {
                Coordinates currentLocation = getCoordinates();
                Coordinates nextLocation = path.get(getCoordinates());

                gameMap.moveEntity(currentLocation, nextLocation);
                setCoordinates(nextLocation);
            }
            attackHerbivore(herbivore);
        }

        if (distance > getSpeed()) {
            for(int i = 0; i < getSpeed(); i++) {
                Coordinates currentLocation = getCoordinates();
                Coordinates nextLocation = path.get(getCoordinates());

                gameMap.moveEntity(currentLocation, nextLocation);
                setCoordinates(nextLocation);
            }
        }

    }


    private Herbivore findHerbivore(GameMap gameMap) {
        ArrayList<Herbivore> herbivores = gameMap.arrayOfHerbivore();
        Random random = new Random();

        int randomIndex = random.nextInt(herbivores.size());

        return herbivores.get(randomIndex);
    }




    public void attackHerbivore(Herbivore herbivore) {
        if (attackDamage > herbivore.getHealth()) {
            herbivore.setHealth(0);
        } else {
            herbivore.setHealth(herbivore.getHealth() - attackDamage);
        }
    }


}