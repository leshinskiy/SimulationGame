package entity.stationary;

import entity.Entity;
import main.Coordinates;

public class Tree extends Entity {
    public final String emoji = "🌳";

    public Tree(Coordinates coordinates) {
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
