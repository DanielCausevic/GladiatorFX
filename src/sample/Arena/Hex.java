package sample.Arena;

public class Hex {

    private int size;
    private Point position;
    private boolean contains;
    private Object holds;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isContains() {
        return contains;
    }

    public void setContains(boolean contains) {
        this.contains = contains;
    }

    public Object getHolds() {
        return holds;
    }

    public void setHolds(Object holds) {
        this.holds = holds;
    }
}
