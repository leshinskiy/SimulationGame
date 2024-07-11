package main;

import entity.Entity;
import entity.Ground;

import java.util.HashMap;

public class Renderer {
    public void renderField(Map map) {
        for(int col = 0; col < 10; col++){
            for(int row = 0; row < 10; row++){
                Coordinates currentCords = new Coordinates(col, row);
                if(map.isEntity(currentCords)){
                    System.out.print(map.getEntity(currentCords));
                } else {
                    System.out.print(new Ground(currentCords));
                }
                System.out.println();
            }
        }
    }
}
