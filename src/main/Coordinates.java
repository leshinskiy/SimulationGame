package main;

import java.util.Objects;

public class Coordinates {

    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        return col == that.col && row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}