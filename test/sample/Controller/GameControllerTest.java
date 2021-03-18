package sample.Controller;

import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.Arena.Arena;
import sample.Arena.Point;
import sample.Model.Gladiator.Gladiator;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    Arena arena;
    Gladiator gladiator;

    @BeforeEach
    public void init(){
        Image testGlad = new Image( "sample/resources/testGlad.png");
        gladiator = new Gladiator(testGlad, 50,50, null);
        //arena = new Arena(10);
        //arena.initArena();
    }


    @Test
    void move() {
        // act
        gladiator.setPositionPoint(new Point(3, 1));
        HashMap<String, Point> possibleMoves = arena.getAdjacent(gladiator.getPosition());
        if(possibleMoves.get("southEast") != null)
            gladiator.setPositionPoint(possibleMoves.get("southEast"));

        // assert
        assertEquals(new Point(4,0), gladiator.getPosition());




    }
}