package sample.Model.Action;

import sample.Model.Dummy.Dummy;
import sample.Model.Gladiator.Gladiator;

public class Attack extends Action{


    public Attack(int time, int condition) {
        super(time, condition);
    }

    public void stabAttack(Gladiator gladiator){

    }

    public void hitAttack(Gladiator gladiator){

    }

    public void TreforkNetAttack(Gladiator gladiator){

    }

    public void NetAttack(Gladiator gladiator){

    }

    public void attackDummy(Dummy dummy, Gladiator gladiator){
        int damage = gladiator.getMainHand().calculateHits(gladiator);
        int currentHP = dummy.getHP();
        int newHP = currentHP -= damage;
        dummy.setHP(newHP);
    }
}
