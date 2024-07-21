package entity.creature;

import entity.Entity;
import main.Coordinates;
import main.GameMap;

public abstract class Creature extends Entity {
    private final int speed;
    private int health;

    private String emoji;

    public Creature(String emoji, int health, int speed, Coordinates coordinates) {
        super(coordinates);
        this.health = health;
        this.speed = speed;
        this.emoji = emoji;
    }

    public abstract void makeMove(GameMap gameMap);

    @Override
    public boolean isStatic(){
        return false;
    }


    @Override
    public String getEmoji() {
        return emoji;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "speed=" + speed +
                ", health=" + health +
                ", emoji='" + emoji + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
