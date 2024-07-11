package entity.creature;

import entity.Entity;
import main.Coordinates;

public abstract class Creature extends Entity {

    private final int speed;
    private int health;

    private final String emoji;

    public Creature(int speed, int health, String emoji, Coordinates coordinates){
        super(coordinates);
        this.health = health;
        this.speed = speed;
        this.emoji = emoji;
    }

    public abstract void makeMove();

    @Override
    public String toString(){
        return emoji;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public String getEmoji() {
        return emoji;
    }


}
