package com.leshinskiy.entity.stationary;

import com.leshinskiy.entity.Entity;
import com.leshinskiy.main.Coordinates;

public class Rock extends Entity {
    private String emoji = "🗻";

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
