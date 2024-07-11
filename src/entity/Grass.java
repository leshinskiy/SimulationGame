package entity;

import entity.Entity;
import main.Coordinates;

public class Grass extends Entity {
    public final String emoji = "🌿";

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }


    public String toString(){
        return emoji;
    }
}
