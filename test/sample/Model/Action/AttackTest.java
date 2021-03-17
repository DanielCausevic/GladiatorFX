package sample.Model.Action;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Model.Dummy.Dummy;
import sample.Model.Gladiator.Armor;
import sample.Model.Gladiator.Gladiator;
import sample.Model.Gladiator.Weapon;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {
    Gladiator gladiator;
    Dummy dummy;

    @BeforeEach
    public void init(){
        JFXPanel jfxPanel = new JFXPanel(); //Fix internal bug
        Image testGlad = new Image( "sample/resources/testGlad.png");
        gladiator = new Gladiator(testGlad, 50,50, null);
        Weapon shortSword1H = new Weapon("Short sword - 1H", 40, 8.0);
        Weapon smallShield = new Weapon("Small shield", 60, 6.0);
        Armor heavyBody = new Armor(80, 8.0, "heavy body armor", "Body");
        gladiator.addArmor(heavyBody);
        gladiator.addShield(smallShield);
        gladiator.addWeaponToMain(shortSword1H);
        dummy = new Dummy(testGlad, 50,50, null);
    }
    @Test
    void attackDummy() {
        Attack attack = new Attack(1, 0);
        attack.attackDummy(dummy, gladiator);

        assertNotEquals(dummy.getHP(), 1000);
    }
}