package com.leshinskiy.entity.creature.predators;

import com.leshinskiy.entity.Entity;
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
        System.out.println("Путь хищника создан :" + path + "  размер " + path.size());

        if(path.size() > getSpeed()) {
            for(int i = 0; i < getSpeed(); i++) {
                System.out.println("Хищник перешел в (>)" + path.peek());

                gameMap.moveEntity(getCoordinates(), path.peek());
                setCoordinates(path.poll());
            }
            return;
        }

        if(path.size() <= getSpeed()) {
            for(int i = path.size(); i != 1; i--) {
                System.out.println("Хищник перешел в (<)" + path.peek());
                gameMap.moveEntity(getCoordinates(), path.peek());
                setCoordinates(path.poll());
            }

            System.out.println("Хищник подобрался к жертве " + getCoordinates());
            Herbivore prey = (Herbivore) gameMap.getEntity(path.peek());
            attackHerbivore(prey);

            System.out.println("Хищник атаковал жертву. Хп жертвы: " + prey.getHealth() + "хп");

            if(prey.getHealth() == 0) {
                consumeFood(gameMap, path.poll());
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

    public void consumeFood(GameMap gameMap, Coordinates coordinates){
        gameMap.moveEntity(getCoordinates(), coordinates);
        setCoordinates(coordinates);
    }

}