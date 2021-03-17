package sample.Model.Gladiator;

import javafx.scene.image.Image;
import sample.Arena.Point;
import sample.Model.Dummy.Dummy;
import sample.Model.Sources.Sprite;

/**
 * @Auhtor Daniel
 * @Auhtor Nicolai
 */
public class Gladiator extends Sprite{
    short HP = 100;
    short conditioning = 100;
    Weapon mainHand; //if null, the gladiator has no attack weapon
    Weapon offHand; //if null, the gladiator has no attack weapon/or shield
    Armor headArmor;
    Armor bodyArmor;
    Armor legArmor;
    String weightClass = "";

    public Gladiator(Image image, double width, double height, Point position) {
        super(image, width, height, position);
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
        double totalWeight = mainHand.weight + offHand.weight + headArmor.weight +
                            bodyArmor.weight + legArmor.weight;
        return totalWeight;
    }

    public void setWeightClass(){
        if(calculateWeightClass()>25){
            weightClass = "Heavy";
        } else {
            weightClass = "Light";
        }
    }

    public void setHP(short HP) {
        this.HP = HP;
    }

    public void setConditioning(short conditioning) {
        this.conditioning = conditioning;
    }

    public void setMainHand(Weapon mainHand) {
        this.mainHand = mainHand;
    }

    public void setOffHand(Weapon offHand) {
        this.offHand = offHand;
    }

    public void setHeadArmor(Armor headArmor) {
        this.headArmor = headArmor;
    }

    public void setBodyArmor(Armor bodyArmor) {
        this.bodyArmor = bodyArmor;
    }

    public void setLegArmor(Armor legArmor) {
        this.legArmor = legArmor;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public short getHP() {
        return HP;
    }

    public short getConditioning() {
        return conditioning;
    }

    public Weapon getOffHand() {
        if (!(offHand == null)) {
            return offHand;
        } else {
            return null;
        }
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

    public void setHP(short HP) {
        this.HP = HP;
    }

    public void setConditioning(short conditioning) {
        this.conditioning = conditioning;
    }
}
