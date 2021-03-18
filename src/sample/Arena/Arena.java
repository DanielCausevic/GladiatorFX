package sample.Arena;

import javafx.scene.canvas.GraphicsContext;
import sample.Model.Gladiator.Gladiator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yannick Brot Christensen
 * @author Rasmus Skovbo
 * Class creates and contains a hexagonal grid in a 2dArray.
 */

// TESTS
public class Arena {

    private Hex[][] arena;
    private int size;

    public Arena(int size, double startX, double startY) {
        this.size = size;
        this.arena = new Hex[size][size];
        initArena(startX, startY);
    }

    //Creates double width hexagonal grid
    public void initArena(double startX, double startY){
        double hexSize = 64;
        double xCounter;
        double yCounter = startY;

        for (int j = 0; j < size; j++) {
            // Resets pixel draw start for each row
            if (j % 2 == 0) {
                xCounter = startX;
            } else {
                xCounter = startX + hexSize * 0.5;
            }

            for (int i = 0; i < size; i++) {
                Point point = new Point(-1, -1);// X AXIS

                /* Doubled offset coords logic:
                If y axis is an even number, x axis only has even numbers (e.g. 2,4 -> 4,4 -> 6,4 -> 8,4)
                 */
                if (j % 2 == 0) {
                    point.setX(i*2);
                } else {
                    point.setX((i*2)+1);
                }
                point.setY(j);

                Hex hex = new Hex(point);
                hex.setX(xCounter);
                hex.setY(yCounter);

                arena[i][j] = hex;
                xCounter += hexSize;
            }

            // Next row (Y AXIS) is 0.75 of hex-size further down
            yCounter += hexSize * 0.75;
        }
    }

    //Creates and returns a list with all the adjacent hexes to a position
    public HashMap<String, Point> getAdjacent(Point gladiatorPosition){
        HashMap<String, Point> adjacentPoints = new HashMap<>();
            if (arena[gladiatorPosition.getX() - 2][gladiatorPosition.getY()] != null)
                adjacentPoints.put("west", arena[gladiatorPosition.getX() - 2][gladiatorPosition.getY()].getPosition());
            if (arena[gladiatorPosition.getX() + 2][gladiatorPosition.getY()] != null)
                adjacentPoints.put("east", arena[gladiatorPosition.getX() + 2][gladiatorPosition.getY()].getPosition());
            if (arena[gladiatorPosition.getX() - 1][gladiatorPosition.getY() - 1] != null)
                adjacentPoints.put("northWest", arena[gladiatorPosition.getX() - 1][gladiatorPosition.getY() - 1].getPosition());
            if (arena[gladiatorPosition.getX() - 1][gladiatorPosition.getY() + 1] != null)
                adjacentPoints.put("southWest", arena[gladiatorPosition.getX() - 1][gladiatorPosition.getY() + 1].getPosition());
            if (arena[gladiatorPosition.getX() + 1][gladiatorPosition.getY() - 1] != null)
                adjacentPoints.put("northEast", arena[gladiatorPosition.getX() + 1][gladiatorPosition.getY() - 1].getPosition());
            if (arena[gladiatorPosition.getX() + 1][gladiatorPosition.getY() + 1] != null)
                adjacentPoints.put("southEast", arena[gladiatorPosition.getX() + 1][gladiatorPosition.getY() + 1].getPosition());
        return adjacentPoints;
    }
/*
    public ArrayList<Point> getFieldOfView(Point gladiatorPosition, int direction) {
      ArrayList<Point> fieldOfView = new ArrayList<>();
        switch(direction) {
            // northEast
            case 1:
                break;

            // east
            case 2:

                break;

            // southEast
            case 3:

                break;
            // southWest
            case 4:

                break;

            // west
            case 5:

                break;

            // northWest
            case 6:

                break;

        }

     return fieldOfView;
    }
*/
    public void render(GraphicsContext gc) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                arena[i][j].render(gc);
            }
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
