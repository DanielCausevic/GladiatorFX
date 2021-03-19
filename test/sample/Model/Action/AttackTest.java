package sample.Model.Action;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Model.Dummy.Dummy;
import sample.Model.Gladiator.*;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {
    Gladiator gladiator;
    Gladiator opponent;
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

        opponent = new Gladiator(testGlad, 50,50, null);
        opponent.addArmor(heavyBody);
        opponent.addShield(smallShield);
        opponent.addWeaponToMain(shortSword1H);
    }

    /*
    @Test
    void hitAttack() {
        //act
        Attack attack = new Attack();
        attack.hitAttack(gladiator, opponent, BodyParts.BODY);

        int act = opponent.getHP();

        //assert
        assertNotEquals(100,act);

    }

     */
  /*
    @Test
    void testCondition(){
        //act
        Attack attack = new Attack();
        attack.hitAttack(gladiator, opponent, BodyParts.BODY);

        int act = gladiator.getConditioning();
        int exp = 95;

        //assert
        assertEquals(exp,act);
    }
    /*
    @Test
    void attackDummy() {
        Attack attack = new Attack(1, 0);
        attack.attackDummy(dummy, gladiator);

        assertNotEquals(dummy.getHP(), 1000);
    }

     */
}