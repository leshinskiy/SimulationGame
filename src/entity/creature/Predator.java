package entity.creature;

import entity.Entity;
import entity.creature.Herbivore;
import main.Coordinates;

import java.util.*;

public class Predator extends Creature {

    private final int attackDamage;

    public Predator(Coordinates coordinates, String emoji, int health, int speed, int attackDamage) {
        super(speed, health, emoji, coordinates);
        this.attackDamage = attackDamage;
    }


    public void makeMove() {
    }

    public void attackHerbivore(Herbivore herbivore) {
        if (attackDamage > herbivore.getHealth()) {
            herbivore.setHealth(0);
        } else {
            herbivore.setHealth(getHealth() - attackDamage);
        }
    }

    @Override
    public String toString(){
        return getEmoji();
    }

    public int getAttackDamage() {
        return attackDamage;
    }

}




