package sample.Controller;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.Arena.Arena;
import sample.Arena.Hex;
import sample.Arena.Point;
import sample.Model.Gladiator.Gladiator;
import sample.Model.Sources.ImageViewSprite;


public class GuiTest extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // Stage = Main window-frame
        stage.setTitle("Render Test");

        // Scene with root group = primary place to hold objects on.
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Canvas = Primary place in root group to paint on.
        Canvas canvas = new Canvas(600, 600);

        root.getChildren().add(canvas);

        // GraphicsContext = Engine to draw images and text
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // loads single hex

        Hex hex = new Hex(new Point(100,100));
        hex.render(gc);
        Arena arena = new Arena(8, 50, 50);



        // Sets gladiator image and position
        Image northOrient = new Image( "sample/resources/glad_n.gif");
        Image eastOrient = new Image( "sample/resources/glad_e.gif");
        Image southOrient = new Image( "sample/resources/glad_s.gif");
        Image westOrient = new Image( "sample/resources/glad_w.gif");
        Gladiator gladiator = new Gladiator(northOrient, westOrient, southOrient, eastOrient, 30, 48, new Point(0, 0));


        // Positioning test. N.B. if arena size is 5, cannot call positions above 5 - 1 (4)
        Hex gladHex = arena.getArena()[1][2];
        gladiator.setX(gladHex.getX());
        gladiator.setY(gladHex.getY());



        gladiator.render(gc);

        // Gladiator update
        int movement = 2;

        //// Input handling
        // Mouse input (only works if both mouse keys are down
        /*
        scene.setOnMouseClicked(
                new EventHandler<MouseEvent>()
                {
                    public void handle(MouseEvent e) {
                        if (e.isPrimaryButtonDown()) {

                        }
                        if (e.isSecondaryButtonDown()) {
                            double currentX = gladiator.getX();
                            gladiator.setPosition(currentX + movement, gladiator.getY());
                        }
                    }
                });
         */

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                double currentX = gladiator.getX();
                double currentY = gladiator.getY();

                if (keyEvent.getCode().toString().equals("LEFT")) {
                    gladiator.setX(currentX - movement);
                    gladiator.setOrientation("W");
                }
                if (keyEvent.getCode().toString().equals("RIGHT")) {
                    gladiator.setX(currentX + movement);
                    gladiator.setOrientation("E");

                }
                if (keyEvent.getCode().toString().equals("UP")) {
                    gladiator.setY(currentY - movement );
                    gladiator.setOrientation("N");
                }
                if (keyEvent.getCode().toString().equals("DOWN")) {
                    gladiator.setY(currentY + movement );
                    gladiator.setOrientation("S");
                }
            }
        });



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
