package sample.Model.Action;

import sample.Arena.Arena;
import sample.Arena.Point;
import sample.Model.Dummy.Dummy;
import sample.Model.Gladiator.Gladiator;

public class Attack extends Action{


    public Attack(int time, int condition) {
        super(time, condition);
    }

    //stab is direct damage to the opponent
    public void stabAttack(Gladiator gladiator, Gladiator opponent){
        if(opponent.isDead() == false) {
            int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * ((double) gladiator.getConditioning() / 100));
            int currentHP = opponent.getHP();
            int newHP = currentHP -= damage;
            opponent.setHP((short) newHP);
        }
        if(opponent.getHP() <= 0){
            opponent.setDead(true);
        }
    }

    public int hitAttack(Gladiator gladiator, Gladiator opponent){
        int damage = 0;
        if(!opponent.isDead()) {
            damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * ((double) gladiator.getConditioning() / 100));
            //if shield is used, the armor of the shield is reduced
            //halvdelen af skaden er fordelt på gladiatoren og ens armor
            int currentHP = opponent.getHP();
            int newHP = currentHP -= damage;
            opponent.setHP((short) newHP);
        }
        if(opponent.getHP() <= 0){
            opponent.setDead(true);
        }
        return damage;
    }

    public void TreforkNetAttack(Gladiator gladiator, Gladiator opponent){
        int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * ((double)gladiator.getConditioning() / 100));
        int currentHP = opponent.getHP();
        int newHP = currentHP -= damage;
        opponent.setHP((short) newHP);
    }

    public void NetAttack(Gladiator gladiator, Gladiator opponent){
        int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * ((double)gladiator.getConditioning() / 100));
        int currentHP = opponent.getHP();
        int newHP = currentHP -= damage;
        opponent.setHP((short) newHP);
    }

    public void attackDummy(Dummy dummy, Gladiator gladiator){
        if(dummy.isDead() == false) {
            int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * ((double) gladiator.getConditioning() / 100));
            int currentHP = dummy.getHP();
            int newHP = currentHP -= damage;
            dummy.setHP(newHP);
        }
        if(dummy.getHP() <= 0){
            dummy.setDead(true);
            dummy.setHP(0);
        }
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


    public boolean isAttackPossible(Gladiator gladiator, Gladiator opponent){
        if (new Point(gladiator.getPosition().getX() - 2, gladiator.getPosition().getY()).equals(opponent.getPosition())
                || new Point(gladiator.getPosition().getX() + 2, gladiator.getPosition().getY()).equals(opponent.getPosition())
                || new Point(gladiator.getPosition().getX() - 1, gladiator.getPosition().getY() - 1).equals(opponent.getPosition())
                || new Point(gladiator.getPosition().getX() - 1, gladiator.getPosition().getY() + 1).equals(opponent.getPosition())
                || new Point(gladiator.getPosition().getX() + 1, gladiator.getPosition().getY() - 1).equals(opponent.getPosition())
                || new Point(gladiator.getPosition().getX() + 1, gladiator.getPosition().getY() + 1).equals(opponent.getPosition())){
            return true;
        } else
            return false;


    }

}
