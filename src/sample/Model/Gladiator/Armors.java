package sample.Model.Gladiator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Daniel
 * @Author Nicolai
 *
 * This class initilize armors and add them to a list
 */
public class Armors {

    List<Armor> armorList = new ArrayList<>();

    //init armors and add to arraylist
    public void initArmors(){
        Armor lightHelmet = new Armor(40, 3.0, "Light helmet", "Head");
        Armor heavyHelmet = new Armor(60, 6.0, "heavy helmet", "Head");
        Armor lightBody = new Armor(50, 5.0, "Light body armor", "Body");
        Armor heavyBody = new Armor(80, 8.0, "heavy body armor", "Body");
        Armor lightLeg = new Armor(25, 2.5, "Light leg armor", "Leg");
        Armor heavyLeg = new Armor(40, 4.0, "heavy leg armor", "Leg");

        armorList.add(lightHelmet);
        armorList.add(heavyHelmet);
        armorList.add(lightBody);
        armorList.add(heavyBody);
        armorList.add(lightLeg);
        armorList.add(heavyLeg);
    }

    public List<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
    }
}
