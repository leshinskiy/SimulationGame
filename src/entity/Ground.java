package entity;

import main.Coordinates;

public class Ground extends Entity{
    private final String emoji = "🟧";

    public Ground(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String toString() {
        return emoji;
    }
}
