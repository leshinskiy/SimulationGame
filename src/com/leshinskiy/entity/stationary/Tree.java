package com.leshinskiy.entity.stationary;

import com.leshinskiy.entity.Entity;
import com.leshinskiy.main.Coordinates;

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
