package sample.Model.Dummy;

import javafx.scene.image.Image;
import sample.Arena.Point;
import sample.Model.Sources.Sprite;

public class Dummy extends Sprite {

    int HP = 100;
    boolean dead = false;

    public Dummy(Image image, double width, double height, Point position, int HP) {
        super(image, width, height, position);
        this.HP = HP;
    }

    public Dummy(Image image, double width, double height, Point position) {
        super(image, width, height, position);
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
