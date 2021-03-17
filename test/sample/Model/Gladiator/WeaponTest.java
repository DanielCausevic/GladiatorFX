package sample.Model.Gladiator;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    Weapon weapon;
    Gladiator gladiator;

    @BeforeEach
    public void init(){
        JFXPanel jfxPanel = new JFXPanel(); //Fix internal bug
        weapon = new Weapon("dagger", 0, 0.5);
        Image testGlad = new Image( "sample/resources/testGlad.png");
        gladiator = new Gladiator(testGlad, 50,50);
        Weapon shortSword1H = new Weapon("Short sword - 1H", 40, 8.0);
        Weapon smallShield = new Weapon("Small shield", 60, 6.0);
        Armor heavyBody = new Armor(80, 8.0, "heavy body armor", "Body");
        gladiator.addArmor(heavyBody);
        gladiator.addShield(smallShield);
        gladiator.addWeaponToMain(shortSword1H);
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

    @Test
    void calculateHits() {
        //act
        int act = gladiator.getMainHand().calculateHits(gladiator);
        int exp = 4;
        //assert
        assertEquals(act,exp); //as the damage is random, sometimes the test will fail
    }
}