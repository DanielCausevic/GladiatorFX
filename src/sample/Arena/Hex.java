package sample.Arena;

import javafx.scene.image.Image;
import sample.Model.Sources.Sprite;

/**
 * @author Yannick Brot Christensen
 * @author Rasmus Skovbo
 * Hex class used as a tile in the arena class
 */

public class Hex extends Sprite {
    private int size;
    private boolean containingObject;
    private Object holds;

    public Hex(Point position) {
        super(new Image("sample/resources/hex.gif"), 54, 54, position); // Hard coded data on hex image
        this.size = 54; //px size, end to end
        this.containingObject = false;
        this.holds = null; // Holds nothing at beginning
    }

    public boolean isContainingObject() {
        return containingObject;
    }

    public void setContainingObject(boolean containingObject) {
        this.containingObject = containingObject;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isContains() {
        return containingObject;
    }

    public void setContains(boolean contains) {
        this.containingObject = contains;
    }

    public Object getHolds() {
        return holds;
    }

    public void setHolds(Object holds) {
        this.holds = holds;
    }

    @Override
    public String toString() {
        return "Hex{" +
                "position = " + getPosition() +
                '}';
    }
}
