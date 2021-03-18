package sample.Model.Gladiator;

import javafx.scene.image.Image;
import sample.Arena.Point;

public class Opponent extends Gladiator{
    public Opponent(Image image, double width, double height, Point position) {
        super(image, width, height, position);
        this.mainHand = new Weapon("Fist",0,0.0);
        this.offHand = new Weapon("Fist",0,0.0);;
        this.headArmor = new Armor(0,0.0, "Naked", "Head");
        this.bodyArmor = new Armor(0,0.0, "Naked", "Body");
        this.legArmor = new Armor(0,0.0, "Naked", "Leg");
        this.HP = 100;
        this.conditioning = 100;
        this.dead = false;
    }
}
