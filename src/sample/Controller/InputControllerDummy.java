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

import javax.swing.*;

public class InputControllerDummy extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Creating image
        Image leftHand = new Image("sample/resources/lefthand.jpg");
        Image rightHand = new Image("sample/resources/righthand.jpg");
        Image directions = new Image("sample/resources/directions.jpg");
        ImageView viewLeftHand = new ImageView(leftHand);
        ImageView viewRightHand = new ImageView(rightHand);
        ImageView viwDirections = new ImageView(directions);

        //Resizing the image
        viewLeftHand.setFitHeight(150);
        viewLeftHand.setPreserveRatio(true);
        viewRightHand.setFitHeight(150);
        viewRightHand.setPreserveRatio(true);
        viwDirections.setFitHeight(150);
        viwDirections.setPreserveRatio(true);


        //Creating buttons
        Button button = new Button();
        Button button1 = new Button();
        Button button2 = new Button();

        //Placing buttons
        button.setTranslateX(30);
        button.setTranslateY(550);
        button1.setTranslateX(450);
        button1.setTranslateY(550);
        button2.setTranslateX(240);
        button2.setTranslateY(550);

        //Resizing the buttons
        button.setPrefSize(80, 80);
        button1.setPrefSize(80, 80);
        button2.setPrefSize(80, 80);

        //Putting the images in button placeholder
        button.setGraphic(viewLeftHand);
        button1.setGraphic(viewRightHand);
        button2.setGraphic(viwDirections);

        primaryStage.setTitle("Arena");

        Group root = new Group(button,button1,button2);
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas( 650, 500);
        root.getChildren().add(canvas);

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
