package sample.Model.Gladiator;
/**
 * @Author Daniel
 * @Author Nicolai
 *
 * This class is used as a super class for armor and weapon as they both have hit points and weight
 */
public class Equipment {

    private int hitPoints;
    private double weight;

    public Equipment(int hitPoints, double weight) {
        this.hitPoints = hitPoints;
        this.weight = weight;
    }
}
