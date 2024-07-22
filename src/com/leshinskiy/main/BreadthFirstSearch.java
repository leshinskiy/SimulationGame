package com.leshinskiy.main;

import com.leshinskiy.entity.Entity;
import com.leshinskiy.entity.creature.predators.Predator;

import java.util.*;

public class BreadthFirstSearch {
   public Deque<Coordinates> pathSearch(Coordinates start, Class<? extends Entity> foodType, GameMap gameMap) {
       System.out.println("Алгоритм поиска пути вызван");
       Queue<Coordinates> queue = new LinkedList<>();   //queue for non-checked coordinates
       queue.add(start);

       HashSet<Coordinates> visited = new HashSet<>();  //Set for visited coordinates
       visited.add(start);

       HashMap<Coordinates, Coordinates> previousCoordinates = new HashMap<>();   // Map for path recovery



       while(!queue.isEmpty()) {
           Coordinates thisCoordinate = queue.poll();
           Entity currentEntity = gameMap.getMap().get(thisCoordinate);


           if(gameMap.getMap().get(thisCoordinate) != null) { // if we found what we looked for we recover path
               if(currentEntity.getClass().equals(foodType)) {

                    Deque<Coordinates> path = new ArrayDeque<>();
                    Coordinates current = thisCoordinate;
                    path.addFirst(current); // add last coordinate

                    while (current != start) { // stop when reach start location
                        path.addFirst(current);
                        current = previousCoordinates.get(current);
                    }
                    path.removeLast(); // removing to not repeat same last coordinate

                    System.out.println("Ласт координаты: " + path.getLast());
                    System.out.println(path);
                    return path;
               }
           }

           Class<? extends Entity> classType = gameMap.getEntity(start).getClass(); // type of who is searching
           ArrayList<Coordinates> unreachableCoordinates = gameMap.getNotAvailableCoordinates(classType); // get all static and predator location
           for(Coordinates coordinate : adjacentCells(thisCoordinate) ){
               if(visited.contains(coordinate) || unreachableCoordinates.contains(coordinate)) {
                   continue; // skip if visited or predator
               }

               previousCoordinates.put(coordinate, thisCoordinate);
               queue.add(coordinate);
               visited.add(coordinate);
           }
       }
       return new ArrayDeque<>(); // return empty Queue if coordinate not found to prevent NPE(Null Pointer Exception)
   }

   private ArrayList<Coordinates> adjacentCells(Coordinates cell) { // function to find all neighbours of current cell in range of [1,-1]

       ArrayList<Coordinates> adjacentCells = new ArrayList<>();
       if (cell.getRow() > 0) {
           adjacentCells.add(new Coordinates(cell.getRow() - 1, cell.getCol()));
       }
       if (cell.getRow() < 9) {
           adjacentCells.add(new Coordinates(cell.getRow() + 1, cell.getCol()));
       }
       if (cell.getCol() > 0) {
           adjacentCells.add(new Coordinates(cell.getRow(), cell.getCol() - 1));
       }
       if (cell.getCol() < 9) {
           adjacentCells.add(new Coordinates(cell.getRow(), cell.getCol() + 1));
       }
       return adjacentCells;
   }


}
