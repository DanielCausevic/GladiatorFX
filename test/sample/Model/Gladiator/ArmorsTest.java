package sample.Model.Gladiator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorsTest {
    Armors armors;

    @BeforeEach
    public void init(){
        armors = new Armors();
        armors.initArmors();
    }

    @Test
    void initArmors() {
        //act
        int act = armors.getArmorList().size();
        int exp = 6;
        //assert
        assertEquals(act,exp);
    }
}