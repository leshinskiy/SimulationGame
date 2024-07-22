package com.leshinskiy.entity;

import com.leshinskiy.main.Coordinates;

public class Ground extends Entity{
    private String emoji = "⬛";

    @Override
    public boolean isStatic() {
        return false;
    }

    public Ground(Coordinates coordinates) {
        super(coordinates);
    }

    public String getEmoji() {
        return emoji;
    }

    @Override
    public String toString() {
        return coordinates + " " + emoji;
    }
}
