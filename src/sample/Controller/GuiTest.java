package sample.Controller;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.Arena.Arena;
import sample.Arena.Hex;
import sample.Arena.Point;
import sample.Model.Gladiator.Gladiator;

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
        Arena arena = new Arena(5);

        // Sets gladiator image and position
        Image testGlad = new Image( "sample/resources/testGlad.png");
        Gladiator gladiator = new Gladiator(testGlad, 50, 50, new Point(0, 0));

        // Positioning test
        Hex[][] possiblePositions = arena.getArena();
        gladiator.setX(possiblePositions[1][1].getX());
        gladiator.setY(possiblePositions[1][1].getY());

        gladiator.render(gc);

        // Gladiator update
        int movement = 1;

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
                Point position = gladiator.getPosition();

                if (keyEvent.getCode().toString().equals("LEFT")) {
                    int currentX = position.getX();
                    gladiator.setPosition(currentX - movement, position.getY());
                }
                if (keyEvent.getCode().toString().equals("RIGHT")) {
                    int currentX = position.getX();
                    gladiator.setPosition(currentX + movement, position.getY());
                }
                if (keyEvent.getCode().toString().equals("UP")) {
                    int currentY = position.getY();
                    gladiator.setPosition(position.getX(), currentY - movement );
                }
                if (keyEvent.getCode().toString().equals("DOWN")) {
                    int currentY = position.getY();
                    gladiator.setPosition(position.getX(), currentY + movement );
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
