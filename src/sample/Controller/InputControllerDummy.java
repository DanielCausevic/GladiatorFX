package sample.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InputControllerDummy extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Creating image
        Image leftHand = new Image("sample/resources/lefthand.jpg");
        Image rightHand = new Image("sample/resources/righthand.jpg");
        Image directions = new Image("sample/resources/directions.jpg");
        ImageView viewLeftHand = new ImageView(leftHand);
        ImageView viewRightHand = new ImageView(rightHand);
        ImageView viewDirections = new ImageView(directions);

        //Resizing the image
        viewLeftHand.setFitHeight(140);
        viewLeftHand.setPreserveRatio(true);
        viewRightHand.setFitHeight(140);
        viewRightHand.setPreserveRatio(true);
        viewDirections.setFitHeight(140);
        viewDirections.setPreserveRatio(true);


        //Creating buttons
        Button buttonLeft = new Button();
        Button buttonRight = new Button();
        Button buttonDir = new Button();
        Button buttonAttack = new Button();
        Button buttonDefend = new Button();
        Button buttonNothing = new Button();

        //Placing buttons
        buttonLeft.setTranslateX(30);
        buttonLeft.setTranslateY(500);
        buttonRight.setTranslateX(450);
        buttonRight.setTranslateY(500);
        buttonDir.setTranslateX(240);
        buttonDir.setTranslateY(500);
        buttonAttack.setTranslateX(30);
        buttonAttack.setTranslateY(500);
        buttonDefend.setTranslateX(30);
        buttonDefend.setTranslateY(550);
        buttonNothing.setTranslateX(30);
        buttonNothing.setTranslateY(600);

        //Making the buttons Not visible
        buttonDefend.setVisible(false);
        buttonAttack.setVisible(false);
        buttonNothing.setVisible(false);

        //Resizing the buttons
        buttonLeft.setPrefSize(80, 80);
        buttonRight.setPrefSize(80, 80);
        buttonDir.setPrefSize(80, 80);
        buttonAttack.setPrefSize(151,50);
        buttonDefend.setPrefSize(151,50);
        buttonNothing.setPrefSize(151,47);

        //Putting the images in button placeholder
        buttonLeft.setGraphic(viewLeftHand);
        buttonRight.setGraphic(viewRightHand);
        buttonDir.setGraphic(viewDirections);
        buttonAttack.setText("Attack!");
        buttonDefend.setText("Defend!");
        buttonNothing.setText("Do Nothing");

        primaryStage.setTitle("Arena");

        Image arena = new Image("sample/resources/hexagon.png");
        Image testGlad = new Image( "sample/resources/testGlad.png");

        ImageView viewArena = new ImageView(arena);
        viewArena.setFitHeight(450);
        viewArena.setPreserveRatio(true);

        buttonLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (buttonAttack.isVisible()) {
                    buttonAttack.setVisible(false);
                    buttonDefend.setVisible(false);
                    buttonNothing.setVisible(false);
                } else {
                    buttonAttack.setVisible(true);
                    buttonDefend.setVisible(true);
                    buttonNothing.setVisible(true);
                }
            }
        });

        buttonAttack.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Attack method
                buttonAttack.setVisible(false);
                buttonDefend.setVisible(false);
                buttonNothing.setVisible(false);
            }
        });

        buttonDefend.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Defend method
                buttonAttack.setVisible(false);
                buttonDefend.setVisible(false);
                buttonNothing.setVisible(false);
            }
        });

        buttonNothing.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Nothing method
                buttonAttack.setVisible(false);
                buttonDefend.setVisible(false);
                buttonNothing.setVisible(false);
            }
        });



        Group root = new Group(
                buttonLeft,buttonRight,buttonDir,viewArena,buttonAttack,buttonDefend,buttonNothing);
        Scene theScene = new Scene(root,650,700);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas( 650, 500);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

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
