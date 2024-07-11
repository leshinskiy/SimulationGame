package main;

import java.util.*;

import entity.Entity;
import entity.creature.Predator;

public class BreadthFirstSearch {
    public void breadthSearch(Coordinates start, Coordinates goal, Entity entity) { // start means where is animal located; goal means what animal is looking for (could be either herbivore or grass)
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(start);

        HashMap<Coordinates, Coordinates> moves = new HashMap<>();
        List<Coordinates> visited = new ArrayList<>();
        while(!queue.isEmpty()){
            Coordinates current = queue.poll();

            if(current.equals(goal)) {
                HashMap<Coordinates, Coordinates> path = new HashMap<>();
                Coordinates currentInPath = goal;
                while(!currentInPath.equals(start)) {
                    path.put(moves.get(currentInPath), currentInPath);
                    currentInPath = moves.get(currentInPath);
                }
                entity.setCoordinates(path.get(start));
                return;
            }

            ArrayList<Coordinates> neighbours = findCellNeighbours(current);
            for(Coordinates neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(current);
                    moves.put(neighbour, current);
                    queue.add(neighbour);
                }

            }

        }
    }

    public ArrayList<Coordinates> findCellNeighbours(Coordinates cell){
        ArrayList<Coordinates> neighbours = new ArrayList<>();
        if (cell.getX() > 0) {
            neighbours.add(new Coordinates(cell.getX() - 1, cell.getY()));
        }
        if (cell.getX() < 9) {
            neighbours.add(new Coordinates(cell.getX() + 1, cell.getY()));
        }
        if (cell.getY() > 0) {
            neighbours.add(new Coordinates(cell.getX(), cell.getY() - 1));
        }
        if (cell.getY() < 9) {
            neighbours.add(new Coordinates(cell.getX(), cell.getY() + 1));
        }
        return neighbours;
    }
}
