package entity.stationary;

import entity.Entity;
import main.Coordinates;

public class Rock extends Entity {
    public final String emoji;

    public Rock(String emoji, Coordinates coordinates){
        super(coordinates);
        this.emoji = emoji;
    }

    public String getEmoji() {
        return this.emoji;
    }

    public String toString() {
        return emoji;
    }
}
