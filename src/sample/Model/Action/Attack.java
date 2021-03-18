package sample.Model.Action;

import sample.Model.Dummy.Dummy;
import sample.Model.Gladiator.Gladiator;
import sample.Model.Gladiator.Opponent;

public class Attack extends Action{


    public Attack(int time, int condition) {
        super(time, condition);
    }

    //stab is direct damage to the opponent
    public void stabAttack(Gladiator gladiator, Opponent opponent){
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

    public void hitAttack(Gladiator gladiator, Opponent opponent){
        int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * ((double)gladiator.getConditioning() / 100));
        //if shield is used, the armor of the shield is reduced
        //halvdelen af skaden er fordelt på gladiatoren og ens armor
        int currentHP = opponent.getHP();
        int newHP = currentHP -= damage;
        opponent.setHP((short) newHP);
    }

    public void TreforkNetAttack(Gladiator gladiator, Opponent opponent){
        int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * ((double)gladiator.getConditioning() / 100));
        int currentHP = opponent.getHP();
        int newHP = currentHP -= damage;
        opponent.setHP((short) newHP);
    }

    public void NetAttack(Gladiator gladiator, Opponent opponent){
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

}
