package sample.Model.Gladiator;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Auhtor Daniel
 * @Auhtor Nicolai
 */
public class Gladiator {
    private short HP = 100;
    private short conditioning = 100;
    private Weapon mainHand; //if null, the gladiator has no attack weapon
    private Weapon offHand; //if null, the gladiator has no attack weapon/or shield
    private Armor headArmor;
    private Armor bodyArmor;
    private Armor legArmor;
    private String weightClass = "";

    public Gladiator() {
        this.mainHand = new Weapon("Fist",0,0.0);
        this.offHand = new Weapon("Fist",0,0.0);;
        this.headArmor = new Armor(0,0.0, "Naked", "Head");
        this.bodyArmor = new Armor(0,0.0, "Naked", "Body");
        this.legArmor = new Armor(0,0.0, "Naked", "Leg");
        this.HP = 100;
        this.conditioning = 100;
    }

    public void addWeaponToMain(Weapon weapon) {
        mainHand = weapon;
    }

    public void addWeaponToOffHand(Weapon weapon) {
        offHand = weapon;
    }

    public void addShield(Weapon weapon) {
        if (weapon.getName().equals("Small shield")) {
            offHand = weapon;
        } else if (weapon.getName().equals("Large shield")) {
            offHand = weapon;
        }
    }

    public void dropMainHand(){
        mainHand = null;
    }

    public void dropOffHand(){
        offHand = null;
    }

    public Weapon getMainWeapon() {
        if (!(mainHand == null)) {
            return mainHand;
        } else {
            return null;
        }
    }

    public void addArmor(Armor armor) {
        if (armor.getBodyLocation().equals("Head")) {
            headArmor = armor;
        } else if (armor.getBodyLocation().equals("Body")) {
            bodyArmor = armor;
        } else if (armor.getBodyLocation().equals("Leg")) {
            legArmor = armor;
        }
    }
//TODO: test om nullpointers
    public double calculateWeightClass(){
        double totoalWeight = mainHand.weight + offHand.weight + headArmor.weight +
                            bodyArmor.weight + legArmor.weight;
        return totoalWeight;
    }

    public void setWeightClass(){
        if(calculateWeightClass()>25){
            weightClass = "Heavy";
        } else {
            weightClass = "Light";
        }
    }

    public short getHP() {
        return HP;
    }

    public short getConditioning() {
        return conditioning;
    }

    public Weapon getMainHand() {
        return mainHand;
    }

    public Weapon getOffHand() {
        return offHand;
    }

    public Armor getHeadArmor() {
        return headArmor;
    }

    public Armor getBodyArmor() {
        return bodyArmor;
    }

    public Armor getLegArmor() {
        return legArmor;
    }

    public String getWeightClass() {
        return weightClass;
    }
}
