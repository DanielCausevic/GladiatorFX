package sample.Model.Gladiator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    Armor armor;

    @BeforeEach
    public void init(){
        armor = new Armor(40, 3.0, "Light helmet", "Head");
    }

    @Test
    void getName() {
        //act
        String actName =armor.getName();
        String expName = "Light helmet";
        //arrange
        assertEquals(actName,expName);
    }

    @Test
    void getArmorHP(){
        //act
        int actHP = armor.hitPoints;
        int expHP = 40;
        //arrange
        assertEquals(actHP,expHP);
    }

    @Test
    void getArmorWeight(){
        //act
        double actWeight = armor.weight;
        double expWeight = 3.0;
        //arrange
        assertEquals(actWeight,expWeight);
    }
}