package sample.Controller;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.Arena.Arena;
import sample.Arena.Hex;
import sample.Arena.Point;
import sample.Model.Gladiator.Gladiator;

public class GUIController extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // Stage = Main window-frame
        stage.setTitle("Gladiator FX");

        // Scene with root group = primary place to hold objects on.
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Canvas = Primary place in root group to paint on.
        Canvas canvas = new Canvas(600, 800);

        root.getChildren().add(canvas);

        // GraphicsContext = Engine to draw images and text
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Arena graphics and position
        Arena arena = new Arena(8, 50, 100);

        // Gladiator graphics and position
        Image northOrient = new Image( "sample/resources/glad_n.gif");
        Image eastOrient = new Image( "sample/resources/glad_e.gif");
        Image southOrient = new Image( "sample/resources/glad_s.gif");
        Image westOrient = new Image( "sample/resources/glad_w.gif");
        Gladiator gladiator = new Gladiator(northOrient, westOrient, southOrient, eastOrient, 30, 48, new Point(0, 0));

        Hex gladHex = arena.getArena()[0][0]; // Top left most hex
        gladiator.setX(gladHex.getX());
        gladiator.setY(gladHex.getY());

        // Main rendering loop, insert graphics here:
        // Renders constantly - so all data position updates to objects (weapons etc) should only be done once pr round
        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // Refresh timer
                double t = (currentNanoTime - startNanoTime) / 100000000.0;

                // Clears screen
                gc.clearRect(0, 0, 600, 600);

                // Renders everything
                arena.render(gc);
                gladiator.render(gc);




            }
        }.start();

        stage.show();

    }
}
