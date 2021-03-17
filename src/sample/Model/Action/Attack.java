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
        int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * (gladiator.getConditioning() / 100));
        int currentHP = opponent.getHP();
        int newHP = currentHP -= damage;
        opponent.setHP((short) newHP);
    }

    public void hitAttack(Gladiator gladiator, Opponent opponent){
        int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * (gladiator.getConditioning() / 100));
        //if shield is used, the armor of the shield is reduced
        //halvdelen af skaden er fordelt på gladiatoren og ens armor
    }

    public void TreforkNetAttack(Gladiator gladiator, Opponent opponent){

    }

    public void NetAttack(Gladiator gladiator){

    }
/*
    public void attackDummy(Dummy dummy, Gladiator gladiator){
        int damage = (int) Math.ceil(gladiator.getMainHand().calculateHits(gladiator) * (gladiator.getConditioning() / 100));
        int currentHP = dummy.getHP();
        int newHP = currentHP -= damage;
        dummy.setHP(newHP);
    }

 */
}
