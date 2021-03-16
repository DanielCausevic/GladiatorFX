package sample.Model.Gladiator;
/**
 * @Author Daniel
 * @Author Nicolai
 *
 * This class is used as a blueprint to make weapons
 */
public class Weapon extends Equipment{

    private String name;

    public Weapon(String name, int hitPoints, double weight) {
        super(hitPoints, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
