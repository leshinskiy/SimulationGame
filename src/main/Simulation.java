package main;
import entity.Entity;
import java.util.HashMap;

public class Simulation {
    public void startSimulation(){
        HashMap<Coordinates, Entity> field = new HashMap<>();
        Map map = new Map(field);
        Renderer renderer = new Renderer();
        renderer.renderField(map);
    }
}
