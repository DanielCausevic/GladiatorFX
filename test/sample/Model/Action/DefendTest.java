package sample.Model.Action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Arena.Point;
import sample.Model.Gladiator.Gladiator;
import sample.Model.Gladiator.Weapon;

import static org.junit.jupiter.api.Assertions.*;

class DefendTest {

    Defend defend = new Defend();
    Gladiator player;
    Gladiator opponent;
    Weapon smallShield;
    Weapon shortSword1H;
    Weapon testWeapon;

    @BeforeEach
    public void init(){
        smallShield = new Weapon("Small shield", 60, 6.0);
        shortSword1H = new Weapon("Short sword - 1H", 40, 8.0);
        testWeapon = new Weapon("testWeapon", 2, 6.0);

        player = new Gladiator(null, 50, 50, new Point(330, 325));
        player.addShield(smallShield);
        player.addWeaponToMain(shortSword1H);

        opponent = new Gladiator(null, 50, 50, new Point(250, 250));
        player.addShield(smallShield);
        opponent.addWeaponToMain(shortSword1H);
    }

    @Test
    void defendWithShield() {
        defend.defend(smallShield, player, opponent);

        //vil faile grundet random hitpoints.
        assertEquals(54, player.getOffHand().getHitPoints());
    }

    @Test
    void defendWith1hand() {
        defend.defend(shortSword1H, player, opponent);

        //vil faile grundet random hitpoints.
        assertEquals(34, player.getMainWeapon().getHitPoints());
    }

    @Test
    void defendTakingDamage() {
        player.addWeaponToMain(testWeapon);
        defend.defend(testWeapon, player, opponent);

        //vil faile grundet random hitpoints.
        assertEquals(96, player.getHP());
    }
}