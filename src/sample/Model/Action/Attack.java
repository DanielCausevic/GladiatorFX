package sample.Model.Action;

import sample.Model.Dummy.Dummy;
import sample.Model.Gladiator.BodyParts;
import sample.Model.Gladiator.Gladiator;

public class Attack extends Action {


    public Attack(){
    }

    //stab is direct damage to the opponent
    public void stabAttack(Gladiator gladiator, Gladiator opponent) {
        int damage = calculateDamage(gladiator);
        int currentHP = opponent.getHP();
        int currentGladiatorCon = gladiator.getConditioning();
        int newHP = currentHP -= damage;
        opponent.setHP((short) newHP);
        gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
    }

    public void hitAttack(Gladiator gladiator, Gladiator opponent, BodyParts bodyPartToAttack) {
        int damage = calculateDamage(gladiator);
        int currentHP = opponent.getHP();
        int currentGladiatorCon = gladiator.getConditioning();
        int damageDistribution = damage / 2;
        int currentArmorHP;
        opponent.setHP((short) (currentHP - damageDistribution)); //set new gladiator condition

        switch (bodyPartToAttack) {
            case HEAD:
                currentArmorHP = opponent.getHeadArmor().getHitPoints();

                /*This if statement checks if the damage the armor is gonna take is less or bigger than the current armor hp,
                  and reduces the current armor hp or gives the damage to the opponent.
                 */
                if (currentArmorHP > damageDistribution) {
                    opponent.getHeadArmor().setHitPoints(currentArmorHP - damageDistribution);
                    opponent.setHP((short) (currentHP - damageDistribution));
                    gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
                } else{
                    int dif = damageDistribution - currentArmorHP; //this is the damage left after the armor hp hits 0
                    opponent.getHeadArmor().setHitPoints(0);
                    opponent.setHP((short) (currentHP - damageDistribution + dif));
                    gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
                }
                break;
            case BODY:
                currentArmorHP = opponent.getBodyArmor().getHitPoints();
                if (currentArmorHP > damageDistribution) {
                    opponent.getBodyArmor().setHitPoints(currentArmorHP - damageDistribution);
                    opponent.setHP((short) (currentHP - damageDistribution));
                    gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
                } else{
                    int dif = damageDistribution - currentArmorHP; //this is the damage left after the armor hp hits 0
                    opponent.getBodyArmor().setHitPoints(0);
                    opponent.setHP((short) (currentHP - damageDistribution + dif));
                    gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
                }
                break;
            case LEG:
                currentArmorHP = opponent.getLegArmor().getHitPoints();
                if (currentArmorHP > damageDistribution) {
                    opponent.getLegArmor().setHitPoints(currentArmorHP - damageDistribution);
                    opponent.setHP((short) (currentHP - damageDistribution));
                    gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
                } else{
                    int dif = damageDistribution - currentArmorHP; //this is the damage left after the armor hp hits 0
                    opponent.getLegArmor().setHitPoints(0);
                    opponent.setHP((short) (currentHP - damageDistribution + dif));
                    gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
                }
                break;
        }
    }

    public void TreforkNetAttack(Gladiator gladiator, Gladiator opponent) {
        int damage = calculateDamage(gladiator);
        int currentHP = opponent.getHP();
        int currentGladiatorCon = gladiator.getConditioning();
        int newHP = currentHP -= damage;
        opponent.setHP((short) newHP);
        gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
    }

    public void NetAttack(Gladiator gladiator, Gladiator opponent) {
        int damage = calculateDamage(gladiator);
        int currentHP = opponent.getHP();
        int currentGladiatorCon = gladiator.getConditioning();
        int newHP = currentHP -= damage;
        opponent.setHP((short) newHP);
        gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
    }

    public void attackDummy(Dummy dummy, Gladiator gladiator) {
        int damage = calculateDamage(gladiator);
        int currentHP = dummy.getHP();
        int currentGladiatorCon = gladiator.getConditioning();
        int newHP = currentHP -= damage;
        dummy.setHP(newHP);
        gladiator.setConditioning((short)(currentGladiatorCon - getWeaponConditionValue(gladiator))); //set new gladiator condition
    }

    public int getWeaponConditionValue(Gladiator gladiator){
        if(gladiator.getMainHand() != null){
            switch (gladiator.getMainWeapon().getName()){
                case "Dagger":
                    return 5;
                case "Trefork & net":
                    return 6;
                case "Short sword - 1H":
                    return 5;
                case "Long sword - 2H":
                    return 10;
                case "Battle axe":
                    return 12;
            }
        }
            return 0;
    }

    //calculate damage
    public int calculateDamage(Gladiator gladiator){
        return (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * ((double) gladiator.getConditioning() / 100));
    }
}
