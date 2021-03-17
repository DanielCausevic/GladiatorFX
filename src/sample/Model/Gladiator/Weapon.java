package sample.Model.Gladiator;

import java.util.Random;

/**
 * @Author Daniel
 * @Author Nicolai
 * <p>
 * This class is used as a blueprint to make weapons
 */
public class Weapon extends Equipment {

    private String name;

    public Weapon(String name, int hitPoints, double weight) {
        super(hitPoints, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Check for different attack cases and calculate damage output
    public int calculateHits(Gladiator gladiator) {

        Random random = new Random();

        int diceRoll = random.nextInt(20) + 1;

        //TODO: check for 0 og 20
        if(gladiator.getWeightClass().equals("Light")){
            diceRoll -= 2;
        }else if(gladiator.getWeightClass().equals("Heavy")){
            diceRoll += 3;
        }

        if(diceRoll>20){
            diceRoll = 20;
        } else if(diceRoll<0){
            diceRoll = 0;
        }

        if (gladiator.getMainWeapon().getName().equals("Short sword - 1H") || gladiator.getMainWeapon().getName().equals("Dagger")) {
            if (diceRoll >= 2 && diceRoll <= 5) {
                return 4;
            } else if(diceRoll >= 6 && diceRoll <= 12){
                return 6;
            }else if(diceRoll >= 13 && diceRoll <= 19){
                return 8;
            }else if(diceRoll == 20){
                return 10;
            }
        } else if(gladiator.getMainWeapon().getName().equals("Long sword - 2H")){
            if (diceRoll >= 2 && diceRoll <= 5) {
                return 4;
            } else if(diceRoll >= 6 && diceRoll <= 13){
                return 7;
            }else if(diceRoll >= 14 && diceRoll <= 19){
                return 16;
            }else if(diceRoll == 20){
                return 30;
            }
        } else if(gladiator.getMainWeapon().getName().equals("Long sword - 2H")) {
            if (diceRoll >= 2 && diceRoll <= 3) {
                return 4;
            } else if (diceRoll >= 4 && diceRoll <= 10) {
                return 16;
            } else if (diceRoll >= 11 && diceRoll <= 19) {
                return 28;
            } else if (diceRoll == 20) {
                return 50;
            }
        }else if(gladiator.getMainWeapon().getName().equals("Trefork & net")) {
            if (diceRoll >= 2 && diceRoll <= 5) {
                return 4;
            } else if (diceRoll >= 6 && diceRoll <= 12) {
                return 6;
            } else if (diceRoll >= 13 && diceRoll <= 19) {
                return 8;
            } else if (diceRoll == 20) {
                return 20;
            }
        }
        return 0; //attack miss
    }
}
