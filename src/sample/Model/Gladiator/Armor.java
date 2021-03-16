package sample.Model.Gladiator;

public class Armor extends Equipment{

    String name;
    String bodyLocation;

    public Armor(int hitPoints, int weight, String name, String bodyLocation) {
        super(hitPoints, weight);
        this.name = name;
        this.bodyLocation = bodyLocation;
    }
}
