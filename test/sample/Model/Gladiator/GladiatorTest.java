package sample.Model.Gladiator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GladiatorTest {
    Gladiator gladiator;

    @BeforeEach
    public void init(){
        gladiator = new Gladiator();
        Weapon shortSword1H = new Weapon("Short sword - 1H", 40, 8.0);
        Weapon smallShield = new Weapon("Small shield", 60, 6.0);
        Armor heavyBody = new Armor(80, 8.0, "heavy body armor", "Body");
        gladiator.addArmor(heavyBody);
        gladiator.addShield(smallShield);
        gladiator.addWeaponToMain(shortSword1H);
    }

    @Test
    void calculateWeightClass() {
        //act
        double act = gladiator.calculateWeightClass();
        double exp = 22.0;
        //assert
        assertEquals(act,exp);
    }
}