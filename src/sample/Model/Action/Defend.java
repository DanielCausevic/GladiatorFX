package sample.Model.Action;

import sample.Model.Gladiator.Armor;
import sample.Model.Gladiator.Gladiator;
import sample.Model.Gladiator.Weapon;

/**
 * @author Thomas S
 * Defend class for the gladiator.
 */

public class Defend extends Action {

    public Defend(int time, int condition) {
        super(time, condition);
    }


    public void defend(Weapon weaponToDefendWith, Gladiator player, Gladiator opponent) {
        Weapon weapon = null;
        Armor attackedArmor = player.getBodyArmor();

        //skal nok ændres når vi har lavet angreb delen, altså vi skal ikke calculatehits her inde :)
        int damageDoneByOpponent = opponent.getMainHand().calculateHits(opponent);


        //if statement for at se om det er mainhand eller offhand wep, han defender med.
        if (player.getMainWeapon().getName().equals(weaponToDefendWith.getName())) {
            weapon = player.getMainWeapon();
        } else if (player.getOffHand().getName().equals(weaponToDefendWith.getName())) {
            weapon = player.getOffHand();
        }

        /* //Afventer på attack delen af dette er done, så jeg ved hvilke metoder jeg kan bruge.
        if(opponent attack is head) {
            attackedArmor = player.getHeadArmor();
        } else if (opponent attack is body) {
            attackedArmor = player.getBodyArmor();
        } else if (opponent attack is legs) {
            attackedArmor = player.getLegArmor();
        }

         */

        //Hvis det er headArmor
        if (attackedArmor == player.getHeadArmor()) {
            if (player.getHeadArmor().getHitPoints() > (damageDoneByOpponent / 2)) {
                player.getHeadArmor().setHitPoints(player.getHeadArmor().getHitPoints() - (damageDoneByOpponent / 2));
                player.setHP((short) (player.getHP() - (damageDoneByOpponent / 2)));
            } else {
                player.setHP((short) (player.getHP() - (damageDoneByOpponent - player.getHeadArmor().getHitPoints())));
                player.dropHeadArmor();
            }
        }

        //If statement hvis vi har et weapon
        if (weapon != null /*&& attackedArmor != player.getHeadArmor() */) {
            player.setConditioning((short) (player.getConditioning() - 1));

            //Hvis wep man defender med har flere hitpoints end den dmg man tager
            if(weapon.getHitPoints() > damageDoneByOpponent) {
                weapon.setHitPoints(weapon.getHitPoints() - damageDoneByOpponent);
                return;
            }

            //hvis ens wep har færre hitpoints en dmg taken, så dropper player wep
            if (damageDoneByOpponent > weapon.getHitPoints()) {
                if (weapon == player.getMainWeapon()) {
                    player.dropMainHand();
                } else if (weapon == player.getOffHand()) {
                    player.dropOffHand();
                }
            }

            //hvis man har bodyArmor
            if (attackedArmor == player.getBodyArmor()) {
                if (player.getBodyArmor().getHitPoints() > (damageDoneByOpponent / 2)) {
                    player.getBodyArmor().setHitPoints(player.getBodyArmor().getHitPoints() - (damageDoneByOpponent / 2));
                    player.setHP((short) (player.getHP() - (damageDoneByOpponent / 2)));
                } else {
                    player.setHP((short) (player.getHP() - (damageDoneByOpponent - player.getBodyArmor().getHitPoints())));
                    player.dropBodyArmor();
                    attackedArmor = null;

                }
            }

            //hvis man har legArmor
            if (attackedArmor == player.getLegArmor()) {
                if (player.getLegArmor().getHitPoints() > (damageDoneByOpponent / 2)) {
                    player.getLegArmor().setHitPoints(player.getLegArmor().getHitPoints() - (damageDoneByOpponent / 2));
                    player.setHP((short) (player.getHP() - (damageDoneByOpponent / 2)));
                } else {
                    player.setHP((short) (player.getHP() - (damageDoneByOpponent - player.getLegArmor().getHitPoints())));
                    player.droplegArmor();
                    attackedArmor = null;

                }
            }

            //Hvis man ikke har armor
            if (attackedArmor != player.getBodyArmor() && attackedArmor != player.getLegArmor() && attackedArmor != null) {
                player.setHP((short) (player.getHP() - (damageDoneByOpponent - weapon.getHitPoints())));
            }

        }

        //hvis man ikke har wep
        if (weapon == null /*&& attackedArmor != player.getHeadArmor() */) {

            //hvis man har bodyArmor
            if (attackedArmor == player.getBodyArmor()) {

                if (player.getBodyArmor().getHitPoints() > (damageDoneByOpponent / 2)) {
                    player.getBodyArmor().setHitPoints(player.getBodyArmor().getHitPoints() - (damageDoneByOpponent / 2));
                    player.setHP((short) (player.getHP() - (damageDoneByOpponent / 2)));

                } else {
                    player.setHP((short) (player.getHP() - (damageDoneByOpponent - player.getBodyArmor().getHitPoints())));
                    player.dropBodyArmor();

                }
            }

            //hvis man har legArmor
            if (attackedArmor == player.getLegArmor()) {

                if (player.getLegArmor().getHitPoints() > (damageDoneByOpponent / 2)) {
                    player.getLegArmor().setHitPoints(player.getLegArmor().getHitPoints() - (damageDoneByOpponent / 2));
                    player.setHP((short) (player.getHP() - (damageDoneByOpponent / 2)));

                } else {
                    player.setHP((short) (player.getHP() - (damageDoneByOpponent - player.getLegArmor().getHitPoints() / 2)));
                    player.droplegArmor();

                }
            }

            //Hvis man ikke har armor
            if(attackedArmor != player.getBodyArmor() && attackedArmor != player.getLegArmor()) {
                player.setHP((short) (player.getHP() - damageDoneByOpponent));

            }
        }
    }



}

