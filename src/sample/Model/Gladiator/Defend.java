package sample.Model.Gladiator;

import java.util.Objects;

public class Defend{

    Weapon damage = new Weapon();

    public void defend(Weapon weaponToDefendWith, Gladiator player, Gladiator opponent) {
        Weapon weapon = null;

        //if statement for at se om det er mainhand eller offhand wep, han defender med.
        if (player.getMainWeapon().getName().equals(weaponToDefendWith.getName())) {
            weapon = player.getMainWeapon();
        } else if(player.getOffHand() == weaponToDefendWith) {
            weapon = player.getOffHand();
        }

        //skal nok ændres når vi har lavet angreb delen, altså vi skal ikke calculatehits her inde :)
        int damageDoneByOpponent = damage.calculateHits(opponent);

        if (weapon != null) {
            player.setConditioning((short) (player.getConditioning() - 1));

            if (damageDoneByOpponent > weapon.getHitPoints()) {
                if (weapon == player.getMainWeapon()) {
                    player.dropMainHand();
                } else if (weapon == player.getOffHand()) {
                    player.dropOffHand();
                }
                player.setHP((short) (player.getHP() - (damageDoneByOpponent - weapon.getHitPoints())));

            } else {
                weapon.setHitPoints(weapon.getHitPoints() - damageDoneByOpponent);
            }
        }
    }

}
