package sample.Controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InputControllerDummy extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Image leftHand = new Image("sample/resources/lefthand.jpg", 150, 150, false, false);
        Image rightHand = new Image("sample/resources/righthand.jpg", 100, 100, false, false);

        ImageView viewLeftHand = new ImageView(leftHand);
        viewLeftHand.setFitHeight(80);
        viewLeftHand.setPreserveRatio(true);

        Button button = new Button();
        button.setTranslateX(100);
        button.setTranslateY(650);
        button.setPrefSize(80, 80);

        button.setGraphic(viewLeftHand);

        primaryStage.setTitle( "Arena" );

        Group root = new Group(button);
        Scene theScene = new Scene( root );
        primaryStage.setScene( theScene );

        Canvas canvas = new Canvas( 650, 650 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image arena = new Image( "sample/resources/hexagon.gif");
        Image testGlad = new Image( "sample/resources/testGlad.png");

        gc.drawImage(arena, 100, 100);
        gc.drawImage(testGlad, 330,325);

        primaryStage.show();

        /*
        primaryStage.getScene().setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent e) {
                        if (pressedOnMovement) {
                            if (pressedMoveRight) {
                                moveRight();
                            } else if (pressedMoveLeft) {
                                moveLeft()
                            } else {
                                characterStay();
                            }
                        } else if (pressedOnAttack) {
                            if (enemyGetShield == true) {
                                get.shieldHP - hitValue;
                            } else if (enemyHasNoShield) {
                                (get.health-(hitvalue/2) && get.ArmorHP-(hitvalue/2));
                            } else if (enemyHasNoShieldAndNoArmor) {
                                get.healthHp - hitValue;
                            }
                        }
                    }
                });


         */
    }

}
