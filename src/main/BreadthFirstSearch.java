package main;

import java.util.*;

public class BreadthFirstSearch {
    public HashMap<Coordinates, Coordinates> breadthSearch(Coordinates start, Coordinates goal, GameMap gameMap) { // start means where is animal located; goal means what animal is looking for (could be either herbivore or grass)
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(start);

        HashMap<Coordinates, Coordinates> moves = new HashMap<>();

        HashMap<Coordinates, Coordinates> path = new HashMap<>();

        Set<Coordinates> visited = new HashSet<>();

        visited.add(start);


        while (!queue.isEmpty()) {
            Coordinates currentInQueue = queue.poll();

            if (currentInQueue.equals(goal)) {
                Coordinates currentStep = goal;

                while (!currentStep.equals(start)) {
                    path.put(moves.get(currentStep), currentStep);
                    currentStep = moves.get(currentStep);
                }
                return path;
            }


            ArrayList<Coordinates> neighbours = findCellNeighbours(currentInQueue);
            ArrayList<Coordinates> unavailableCoordinates = gameMap.getNotAvailableCoordinates();
            for (Coordinates neighbour : neighbours) {
                if (unavailableCoordinates.contains(neighbour) || visited.contains(neighbour)) {
                    continue;
                }
                moves.put(neighbour, currentInQueue);
                queue.add(neighbour);
                visited.add(currentInQueue);
            }
        }
        return path;
    }


        ArrayList<Coordinates> findCellNeighbours (Coordinates cell){
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
