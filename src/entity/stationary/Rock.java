package entity.stationary;

import entity.Entity;
import main.Coordinates;

public class Rock extends Entity {
    private String emoji = "🌑";

    public Rock(Coordinates coordinates){
        super(coordinates);
    }

    public String toString() {
        return emoji + " " + coordinates;
    }

    @Override
    public String getEmoji() {
        return emoji;
    }
}
