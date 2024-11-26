package com.leshinskiy.main;

import com.leshinskiy.entity.Entity;
import com.leshinskiy.entity.Grass;
import com.leshinskiy.entity.creature.Creature;
import com.leshinskiy.entity.creature.herbivores.Herbivore;
import com.leshinskiy.entity.creature.predators.Predator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameMap {
    private final HashMap<Coordinates, Entity> map;


    public GameMap() {
        map = new HashMap<>();
    }

    public <E> void addEntity(E entity, Coordinates coordinates) {
        map.put(coordinates, (Entity) entity);
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
            if(value instanceof Creature && value.getCoordinates() != null) {
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

    public ArrayList<Coordinates> getNotAvailableCoordinates(Class<? extends Entity> type) { // get all coordinates where located static (immovable) objects to avoid them
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        if(type.equals(Predator.class)) {
            map.forEach((key, value) -> {

                if(value != null && value.isStatic() || value instanceof Predator ) {
                    coordinates.add(key);
                }
            });
        } else {
            map.forEach((key, value) -> {
                if(value != null && value.isStatic() || value instanceof Predator || value instanceof Herbivore) {
                    coordinates.add(key);
                }
            });
        }

        return coordinates;
    }

    public Coordinates getFreeCoordinates() { // not the best way to find free cords but i guess it works
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
