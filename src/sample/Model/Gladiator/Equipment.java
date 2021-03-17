package sample.Model.Gladiator;
/**
 * @Author Daniel
 * @Author Nicolai
 *
 * This class is used as a super class for armor and weapon as they both have hit points and weight
 */
public class Equipment {

    protected int hitPoints;
    protected double weight;

    public Equipment(int hitPoints, double weight) {
        this.hitPoints = hitPoints;
        this.weight = weight;
    }

    public Equipment() {

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
