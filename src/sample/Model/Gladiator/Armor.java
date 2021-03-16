package sample.Model.Gladiator;
/**
 * @Author Daniel
 * @Author Nicolai
 *
 * This class is used as a blueprint to make armors
 */
public class Armor extends Equipment{

    private String name;
    private String bodyLocation;

    public Armor(int hitPoints, double weight, String name, String bodyLocation) {
        super(hitPoints, weight);
        this.name = name;
        this.bodyLocation = bodyLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyLocation() {
        return bodyLocation;
    }

    public void setBodyLocation(String bodyLocation) {
        this.bodyLocation = bodyLocation;
    }
}
