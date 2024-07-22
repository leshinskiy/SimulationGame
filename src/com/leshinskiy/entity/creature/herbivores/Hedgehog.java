package com.leshinskiy.entity.creature.herbivores;
import com.leshinskiy.main.Coordinates;
import com.leshinskiy.main.GameMap;

public class Hedgehog extends Herbivore {

    public Hedgehog(String emoji, int health, int speed, Coordinates coordinates) {
        super(emoji, health, speed, coordinates);
    }

    public void passiveAttack(GameMap gameMap) {

    }
}
