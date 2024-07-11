package main;

import entity.Entity;

import java.util.HashMap;

public class Map {
    private HashMap<Coordinates, Entity> map = new HashMap<>();

    public Map(HashMap<Coordinates, Entity> map) {
        this.map = map;
    }

    public boolean isEntity(Coordinates coordinates){
        return map.get(coordinates) != null;
    }

    void addEntity(Entity entity, Coordinates coordinates){
        map.put(coordinates, entity);
    }

    void removeEntity(Coordinates coordinates){
        map.remove(coordinates);
    }

    void moveEntity(Coordinates from, Coordinates to){
        Entity entity = map.get(from);
        map.remove(from);
        map.put(to, entity);
    }

    public Entity getEntity(Coordinates coordinates){
        return map.get(coordinates);
    }

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }

}
