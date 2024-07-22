package com.leshinskiy.entity;

import com.leshinskiy.main.Coordinates;

public class Grass extends Entity {
    public final String emoji = "🌿";

    @Override
    public boolean isStatic() {
        return false;
    }

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getEmoji() {
        return emoji;
    }
    public String toString(){
        return emoji + " " + coordinates;
    }

}
