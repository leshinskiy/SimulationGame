package entity.creature;

import entity.Entity;
import main.BreadthFirstSearch;
import main.Coordinates;
import main.GameMap;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class Predator extends Creature {

    private final int attackDamage;

    public Predator(String emoji, int health, int speed, int attackDamage, Coordinates coordinates) {
        super(emoji, health, speed, coordinates);
        this.attackDamage = attackDamage;
    }


    @Override
    public void makeMove(GameMap gameMap){
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Queue<Coordinates> path = bfs.pathSearch(getCoordinates(), Herbivore.class, gameMap);
        System.out.println("Путь хищника создан :" + path + "  размер " + path.size());

        if(path.size() > getSpeed()) {

            for(int i = 0; i < getSpeed(); i++) {
                System.out.println("Хищник перешел в (>)" + path.peek());

                Entity entity = gameMap.getEntity(getCoordinates());
                gameMap.removeEntity(getCoordinates());
                setCoordinates(path.poll());
                gameMap.addEntity(entity, getCoordinates());
            }

            return;
        }

        if(path.size() <= getSpeed()) {

            for(int i = path.size(); path.size() != 1; i--) {
                System.out.println("Хищник перешел в (<)" + path.peek());

                Entity entity = gameMap.getEntity(getCoordinates());
                gameMap.removeEntity(getCoordinates());
                setCoordinates(path.poll());
                gameMap.addEntity(entity, getCoordinates());
            }

            System.out.println("Хищник подобрался к жертве " + getCoordinates());
            Herbivore prey = (Herbivore) gameMap.getEntity(path.peek());
            System.out.println("Координаты жертвы: " + prey.getCoordinates());
            System.out.println("Жертва: " + prey);
            attackHerbivore(prey);
            int preyHP = prey.getHealth();
            System.out.println("Хищник атаковал жертву и снес ей " + preyHP + "хп");

            if(preyHP == 0) {
                return;
            }
        }
    }


    public void attackHerbivore(Herbivore herbivore) {
        if (attackDamage > herbivore.getHealth()) {
            herbivore.setHealth(0);
        } else {
            herbivore.setHealth(herbivore.getHealth() - attackDamage);
        }
    }


}