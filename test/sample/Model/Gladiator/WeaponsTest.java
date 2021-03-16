package sample.Model.Gladiator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponsTest {
    Weapons weapons;

    @BeforeEach
    public void init(){
        weapons = new Weapons();
        weapons.initWeapons();
    }

    @Test
    void initWeapons() {
        //act
        int act = weapons.getWeaponList().size();
        int exp = 7;
        //assert
        assertEquals(act,exp);
    }
}