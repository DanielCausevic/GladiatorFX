package sample.Model.Gladiator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Gladiator {
    short HP = 100;
    short conditioning = 100;
    ArrayList<Weapon> weapons = new ArrayList<>();

    public Gladiator(int HPP) {
        this.weapons = new ArrayList<>();
        this.HP = 100;
        this.conditioning = 100;

    }

    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }
}
