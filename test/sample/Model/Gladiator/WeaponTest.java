package sample.Model.Gladiator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    Weapon weapon;

    @BeforeEach
    public void init(){
        weapon = new Weapon("dagger", 0, 0.5);
    }

    @Test
    void getName() {
        //act
        String actName = weapon.getName();
        String expName = "dagger";
        //arrange
        assertEquals(actName,expName);
    }

    @Test
    void getWeaponHP(){
        //act
        int actHP = weapon.hitPoints;
        int expHP = 0;
        //arrange
        assertEquals(actHP,expHP);
    }

    @Test
    void getWeaponWeight(){
        //act
        double actWeight = weapon.weight;
        double expWeight = 0.5;
        //arrange
        assertEquals(actWeight,expWeight);
    }
}