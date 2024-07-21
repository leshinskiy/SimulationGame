package main;

import entity.Entity;
import entity.Grass;
import entity.creature.Creature;
import entity.creature.Herbivore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameMap {
    private final HashMap<Coordinates, Entity> map;


    public GameMap() {
        map = new HashMap<>();
    }

    public boolean isNeededClass(Coordinates coordinates, Class<? extends Entity> type ) {
        Entity value = map.get(coordinates);
        if(map.get(coordinates) == null) {
            return false;
        }
        return value.getClass() == type;
    }

    public boolean isEntity(Coordinates coordinates){
        return map.get(coordinates) != null;
    }


    public void addEntity(Entity entity, Coordinates coordinates){
        map.put(coordinates, entity);
    }


    public void removeEntity(Coordinates coordinates){
        map.remove(coordinates);
    }


    public void moveEntity(Coordinates from, Coordinates to){
        Entity entity = map.get(from);
        map.remove(from);
        map.put(to, entity);
    }


    public ArrayList<Creature> arrayOfCreatures() {
        ArrayList<Creature> arrayForCreatures = new ArrayList<>();

        map.forEach((key, value) -> {
            if(value instanceof Creature) {
                arrayForCreatures.add((Creature) value);
            }
        });

        return arrayForCreatures;
    }

    public ArrayList<Grass> arrayOfGrass() {
        ArrayList<Grass> arrayForGrass = new ArrayList<>();

        map.forEach((key, value) -> {
            if(value instanceof  Grass) {
                arrayForGrass.add((Grass) value);
            }
        });

        return arrayForGrass;
    }

    public ArrayList<Herbivore> arrayOfHerbivore() {
        ArrayList<Herbivore> arrayForHerbivore = new ArrayList<>();

        map.forEach((key, value) -> {
            if(value instanceof  Herbivore) {
                arrayForHerbivore.add((Herbivore) value);
            }
        });

        return arrayForHerbivore;
    }

//    public ArrayList<Coordinates> getNotAvailableCoordinates() { //get all coordinates where located static (immovable) objects to avoid them
//        ArrayList<Coordinates> coordinates = new ArrayList<>();
//
//        map.forEach((key, value) -> {
//            if(value.isStatic() || value instanceof Creature) {
//                coordinates.add(key);
//            }
//        });
//
//        return coordinates;
//    }

    public Coordinates getFreeCoordinates() {
        Random random = new Random();
        Coordinates coordinates;

        do {
            int row = random.nextInt(10);
            int col = random.nextInt(10);
            coordinates = new Coordinates(row, col);
        } while(map.containsKey(coordinates));

        return coordinates;
    }


    public Entity getEntity(Coordinates coordinates){
        return map.get(coordinates);
    }


    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }
}
