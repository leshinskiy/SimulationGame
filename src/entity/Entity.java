package entity;
import main.Coordinates;
public abstract class Entity {
    protected Coordinates coordinates;
    private String emoji;

    public boolean isStatic(){
        return true;
    }

    public Entity(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getEmoji() {
        return emoji;
    }
}
