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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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

        Image arena = new Image( "sample/resources/hexagon.gif");
        Image testGlad = new Image( "sample/resources/testGlad.png");

        gc.drawImage(arena, 100, 100);

        // Sets gladiator image and position
        Gladiator gladiator = new Gladiator(testGlad, 50, 50);
        gladiator.setPosition(330, 325);
        gladiator.render(gc);

        // Gladiator update
        double movement = 1;

        //// Input handling
        // Mouse input (only works if both mouse keys are down
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

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().toString().equals("LEFT")) {
                    double currentX = gladiator.getX();
                    gladiator.setPosition(currentX - movement, gladiator.getY());
                }
                if (keyEvent.getCode().toString().equals("RIGHT")) {
                    double currentX = gladiator.getX();
                    gladiator.setPosition(currentX + movement, gladiator.getY());
                }
                if (keyEvent.getCode().toString().equals("UP")) {
                    double currentY = gladiator.getY();
                    gladiator.setPosition(gladiator.getX(), currentY - movement );
                }
                if (keyEvent.getCode().toString().equals("DOWN")) {
                    double currentY = gladiator.getY();
                    gladiator.setPosition(gladiator.getX(), currentY + movement );
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
                gc.drawImage(arena, 100, 100);
                gladiator.render(gc);

            }
        }.start();

        stage.show();
    }
}
