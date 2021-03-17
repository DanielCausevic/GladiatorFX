package sample.Arena;

import javafx.scene.canvas.GraphicsContext;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yannick Brot Christensen
 * Class creates and contains a hexagonal grid in a 2dArray.
 */


public class Arena {

    private Hex[][] arena;
    private int size;

    public Arena(int size) {
        this.size = size;
        this.arena = new Hex[size][size];
        initArena();
    }

    //Creates double width hexagonal grid
    public void initArena(){
        double hexSize = 52;
        // 1st row
        double xCounter = 0;
        double yCounter = 0;
        for (int i = 0; i < size; i ++) {
            Hex hex = new Hex(new Point(0, 0));
            hex.setX(xCounter);
            hex.setY(yCounter);
            arena[0][i] = hex;
            xCounter += hexSize;
        }
        // 2nd row
        xCounter = 0 + hexSize * 0.5;
        yCounter = 0 + hexSize * 0.75;
        for (int i = 0; i < size; i ++) {
            Hex hex = new Hex(new Point(0, 0));
            hex.setX(xCounter);
            hex.setY(yCounter);
            arena[1][i] = hex;
            xCounter += hexSize;
        }

        /*
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size/2; j++) {
                arena[i][j] = new Hex(new Point(i,j));
            }
        }
         */
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

    public void render(GraphicsContext gc) {
        for (int i = 0; i < size; i++) {
            arena[0][i].render(gc);
        }
        for (int i = 0; i < size; i++) {
            arena[1][i].render(gc);
        }
    }

    public Hex[][] getArena() {
        return arena;
    }

    public void setArena(Hex[][] arena) {
        this.arena = arena;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "hex=" + Arrays.toString(arena) +
                ", size=" + size +
                '}';
    }
}
