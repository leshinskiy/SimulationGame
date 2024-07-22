package com.leshinskiy.main;

import com.leshinskiy.entity.Entity;
import com.leshinskiy.entity.Ground;

import java.util.HashMap;

public class Renderer {
    public void renderField(GameMap gameMap) {
        HashMap<Coordinates, Entity> entityMap = gameMap.getMap();
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 10; col++){
                Coordinates coordinates = new Coordinates(row, col);

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
