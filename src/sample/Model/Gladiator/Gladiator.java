package sample.Model.Gladiator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Arena.Point;
import sample.Model.Sources.Sprite;

/**
 * @Auhtor Daniel
 * @Auhtor Nicolai
 */
public class Gladiator extends Sprite {
    short HP = 100;
    short conditioning = 100;
    Weapon mainHand; //if null, the gladiator has no attack weapon
    Weapon offHand; //if null, the gladiator has no attack weapon/or shield
    Armor headArmor;
    Armor bodyArmor;
    Armor legArmor;
    String weightClass = "";
    boolean dead = false;

    // Attributes for rotating
    private String orientation;
    private Image north, east, west, south, downed;

    public Gladiator(Image north, Image west, Image south, Image east, double width, double height, Point position) {
        super(south, width, height, position);
        this.north = north;
        this.west = west;
        this.south = south;
        this.east = east;
        this.mainHand = new Weapon("Fist", 0, 0.0);
        this.offHand = new Weapon("Fist", 0, 0.0);
        this.headArmor = new Armor(0, 0.0, "Naked", "Head");
        this.bodyArmor = new Armor(0, 0.0, "Naked", "Body");
        this.legArmor = new Armor(0, 0.0, "Naked", "Leg");
        this.HP = 100;
        this.conditioning = 100;
        this.orientation = "S";
    }

    public Gladiator(Image image, double width, double height, Point position) {
        super(image, width, height, position);
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

    public void dropMainHand() {
        mainHand = null;
    }

    public void dropOffHand() {
        offHand = null;
    }

    public void dropHeadArmor() {
        headArmor = null;
    }

    public void dropBodyArmor() {
        bodyArmor = null;
    }

    public void droplegArmor() {
        legArmor = null;
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

    public double calculateWeightClass() {
        double totalWeight = mainHand.weight + offHand.weight + headArmor.weight +
                bodyArmor.weight + legArmor.weight;
        return totalWeight;
    }

    public void setWeightClass() {
        if (calculateWeightClass() > 25) {
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

    public Weapon getMainHand() {
        return mainHand;
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

    @Override
    public void render(GraphicsContext gc) {
        double xOffset = 2;
        double yOffset = 1.2;

        switch (orientation) {
            case "N", "NW", "NE" -> gc.drawImage(north, getX() - getWidth() / xOffset, getY() - getHeight() / yOffset);
            case "W" -> gc.drawImage(west, getX() - getWidth() / xOffset, getY() - getHeight() / yOffset);
            case "E" -> gc.drawImage(east, getX() - getWidth() / xOffset, getY() - getHeight() / yOffset);
            case "DOWNED" -> gc.drawImage(downed, getX() - getWidth() / xOffset, getY() - getHeight() / yOffset);
            default -> gc.drawImage(south, getX() - getWidth() / xOffset, getY() - getHeight() / yOffset);
        }
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

}




