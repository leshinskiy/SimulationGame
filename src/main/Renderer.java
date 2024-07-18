package main;

import entity.Entity;
import entity.Ground;

import java.util.HashMap;

public class Renderer {
    public void renderField(GameMap gameMap) {
        HashMap<Coordinates, Entity> entityMap = gameMap.getMap();
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                Coordinates coordinates = new Coordinates(x, y);

                if(entityMap.containsKey(coordinates) && entityMap.get(coordinates) != null){
                    Entity entity = entityMap.get(coordinates);
                    System.out.print(entity.getEmoji());
                } else {
                    Ground ground = new Ground(coordinates);
                    System.out.print(ground.getEmoji());
                }
            }
            System.out.println();
        }
    }
}
