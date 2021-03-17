package sample.Model.Gladiator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Daniel
 * @Author Nicolai
 *
 * This class initilize weapons and add them to a list
 */
public class Weapons {

    private List<Weapon> weaponList = new ArrayList<>();

    //init weapons and add to arraylist
    public void initWeapons(){
        Weapon Dagger = new Weapon("Dagger", 0, 0.5);
        Weapon TreforkAndNet = new Weapon("Trefork & net",0, 4.0);
        Weapon shortSword1H = new Weapon("Short sword - 1H", 40, 8.0);
        Weapon longSword2H = new Weapon("Long sword - 2H", 60, 15.0);
        Weapon batteAxe = new Weapon("Battle axe", 0, 20.0);
        Weapon smallShield = new Weapon("Small shield", 60, 6.0);
        Weapon largeShield = new Weapon("Large shield", 100, 9.0);

        weaponList.add(Dagger);
        weaponList.add(TreforkAndNet);
        weaponList.add(shortSword1H);
        weaponList.add(longSword2H);
        weaponList.add(batteAxe);
        weaponList.add(smallShield);
        weaponList.add(largeShield);
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }
}
