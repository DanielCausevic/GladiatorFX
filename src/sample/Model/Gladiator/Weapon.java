package sample.Model.Gladiator;

public class Weapon extends Equipment{

    String name;
    boolean isDefensive;

    public Weapon(String name, boolean isDefensive, int hitPoints, double weight) {
        super(hitPoints, weight);
        this.name = name;
        this.isDefensive = isDefensive;
    }
}
