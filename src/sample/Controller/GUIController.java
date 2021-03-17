package sample.Controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.Model.Gladiator.Gladiator;


public class GUIController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle( "Arena" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        primaryStage.setScene( theScene );

        Canvas canvas = new Canvas( 650, 650 );
        root.getChildren().add( canvas );

        primaryStage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image arena = new Image( "sample/resources/hexagon.gif");
        Image testGlad = new Image( "sample/resources/testGlad.png");

        // Sets gladiator image and position
        Gladiator gladiator = new Gladiator(testGlad, 50, 50);
        gladiator.setPosition(320, 325);

        // Renders arena and gladiator
        gc.drawImage(arena, 100, 100);
        gladiator.render(gc);

        gc.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        gc.fillText("HP: " + String.valueOf(gladiator.getHP()), 500, 60);
        gc.fillText("Condition: " + String.valueOf(gladiator.getConditioning()), 500, 74);

        // Repositions gladiator
        gladiator.setPosition(325,322);

        // Renders arena and gladiator again
        gc.drawImage(arena, 100, 100);
        gladiator.render(gc);




    }
}
