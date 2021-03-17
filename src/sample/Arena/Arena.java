package sample.Arena;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Yannick Brot Christensen
 * Class creates and contains a hexagonal grid in a 2dArray.
 */


public class Arena {

    private Hex[][] arena;

    //Creates double width hexagonal grid
    public void initArena(int width){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width/2; j++) {
                arena[i][j] = new Hex(new Point(i,j));
            }
        }
    }

    //Creates and returns a list with all the adjacent hexes to a position
    public HashMap<String, Point> getAdjacent(Point gladiatorPosition){
        HashMap<String, Point> adjacentPoints = new HashMap<>();
        if(arena[gladiatorPosition.getX()-2][gladiatorPosition.getY()] != null)
            adjacentPoints.put("west", arena[gladiatorPosition.getX()-2][gladiatorPosition.getY()].getPosition());
        if(arena[gladiatorPosition.getX()+2][gladiatorPosition.getY()] != null)
            adjacentPoints.put("east", arena[gladiatorPosition.getX()+2][gladiatorPosition.getY()].getPosition());
        if(arena[gladiatorPosition.getX()-1][gladiatorPosition.getY()-1] != null)
            adjacentPoints.put("southWest", arena[gladiatorPosition.getX()-1][gladiatorPosition.getY()-1].getPosition());
        if(arena[gladiatorPosition.getX()-1][gladiatorPosition.getY()+1] != null)
            adjacentPoints.put("northWest", arena[gladiatorPosition.getX()-1][gladiatorPosition.getY()+1].getPosition());
        if(arena[gladiatorPosition.getX()+1][gladiatorPosition.getY()-1] != null)
            adjacentPoints.put("southEast", arena[gladiatorPosition.getX()+1][gladiatorPosition.getY()-1].getPosition());
        if(arena[gladiatorPosition.getX()+1][gladiatorPosition.getY()+1] != null)
            adjacentPoints.put("northEast", arena[gladiatorPosition.getX()+1][gladiatorPosition.getY()+1].getPosition());
        return adjacentPoints;
    }

}
