package sample.Model.Gladiator;

import javafx.scene.image.Image;
import sample.Model.Sources.Sprite;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Gladiator extends Sprite {
    private short HP;
    private short conditioning;
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public Gladiator(Image image, double width, double height,  ArrayList<Weapon> weapons) {
        super(image, width, height);
        this.HP = 100;
        this.conditioning = 100;
        this.weapons = weapons;
    }


    // Getters & Setters
    public short getHP() {
        return HP;
    }

    public void setHP(short HP) {
        this.HP = HP;
    }

    public short getConditioning() {
        return conditioning;
    }

    public void setConditioning(short conditioning) {
        this.conditioning = conditioning;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }
}
