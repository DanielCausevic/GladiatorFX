package sample.Model.Gladiator;

import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GladiatorTest {

    Gladiator gladiator;

    @BeforeEach
    public void init(){
        Image testGlad = new Image( "sample/resources/testGlad.png");
        gladiator = new Gladiator(testGlad, 50, 50, null);
    }

    @Test
    void getHp() {
        int hp = 100;

        assertEquals(hp, gladiator.getHP());
    }
}