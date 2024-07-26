package com.leshinskiy.entity.creature.predators;


import com.leshinskiy.entity.creature.Creature;
import com.leshinskiy.entity.creature.herbivores.Herbivore;
import com.leshinskiy.main.BreadthFirstSearch;
import com.leshinskiy.main.Coordinates;
import com.leshinskiy.main.GameMap;

import java.util.Queue;

public class Predator extends Creature {

    private final int attackDamage;

    public Predator(String emoji, int health, int speed, int attackDamage, Coordinates coordinates) {
        super(emoji, health, speed, coordinates);
        this.attackDamage = attackDamage;
    }


    @Override
    public void makeMove(GameMap gameMap){

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Queue<Coordinates> path = bfs.pathSearch(getCoordinates(), Herbivore.class, gameMap);


        if(path.size() > getSpeed()) {
            for(int i = 0; i < getSpeed(); i++) {
                gameMap.moveEntity(getCoordinates(), path.peek());
                setCoordinates(path.poll());
            }
            return;
        }

        if(path.size() <= getSpeed() && !path.isEmpty()) {
            for(int i = path.size(); i != 1; i--) {
                gameMap.moveEntity(getCoordinates(), path.peek());
                setCoordinates(path.poll());
            }


            Herbivore prey = (Herbivore) gameMap.getEntity(path.peek());
            attackHerbivore(prey);


            if(prey.getHealth() == 0) {
                if(gameMap.getEntity(path.peek()) instanceof Herbivore) {
                    consumeFood(gameMap, prey.getCoordinates());
                }
            }
        }
    }


    private void attackHerbivore(Herbivore herbivore) {
        if (attackDamage > herbivore.getHealth()) {
            herbivore.setHealth(0);
        } else {
            herbivore.setHealth(herbivore.getHealth() - attackDamage);
        }
    }

    public void consumeFood(GameMap gameMap, Coordinates herbivore){
        gameMap.removeEntity(herbivore);
        gameMap.removeEntity(this.getCoordinates());

        gameMap.addEntity(this, herbivore);
        this.setCoordinates(herbivore);

        System.out.println("Хищник съел добычу!");
    }

}