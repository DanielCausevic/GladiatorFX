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
        viewDirections.setFitWidth(135);

//----------------------------------------------------------------------------------------------------------------------

        //Creating buttons
        Button buttonLeft = new Button();
        Button buttonRight = new Button();
        Button buttonDir = new Button();

        //Left Hand
        Button buttonAttackLeft = new Button();
        Button buttonDefendLeft = new Button();
        Button buttonNothingLeft = new Button();

        //Movement
        Button buttonRotate = new Button();
        Button buttonMove = new Button();
        Button buttonNothingMove = new Button();

        //Right Hand
        Button buttonAttackRight = new Button();
        Button buttonDefendRight = new Button();
        Button buttonNothingRight = new Button();

        //Rotate
        Button buttonRotateUp = new Button();
        Button buttonRotateDown = new Button();

        //Move
        Button buttonNE = new Button();
        Button buttonE = new Button();
        Button buttonSE = new Button();
        Button buttonSW = new Button();
        Button buttonW = new Button();
        Button buttonNW = new Button();

//----------------------------------------------------------------------------------------------------------------------

        //Placing buttons
        buttonLeft.setTranslateX(30);
        buttonLeft.setTranslateY(500);
        buttonRight.setTranslateX(450);
        buttonRight.setTranslateY(500);
        buttonDir.setTranslateX(240);
        buttonDir.setTranslateY(500);

        buttonAttackLeft.setTranslateX(30);
        buttonAttackLeft.setTranslateY(500);
        buttonDefendLeft.setTranslateX(30);
        buttonDefendLeft.setTranslateY(550);
        buttonNothingLeft.setTranslateX(30);
        buttonNothingLeft.setTranslateY(600);

        buttonRotate.setTranslateX(240);
        buttonRotate.setTranslateY(500);
        buttonMove.setTranslateX(240);
        buttonMove.setTranslateY(550);
        buttonNothingMove.setTranslateX(240);
        buttonNothingMove.setTranslateY(600);

        buttonAttackRight.setTranslateX(450);
        buttonAttackRight.setTranslateY(500);
        buttonDefendRight.setTranslateX(450);
        buttonDefendRight.setTranslateY(550);
        buttonNothingRight.setTranslateX(450);
        buttonNothingRight.setTranslateY(600);

        buttonRotateUp.setTranslateX(240);
        buttonRotateUp.setTranslateY(500);
        buttonRotateDown.setTranslateX(240);
        buttonRotateDown.setTranslateY(575);

        buttonNE.setTranslateX(260);
        buttonNE.setTranslateY(500);
        buttonE.setTranslateX(260);
        buttonE.setTranslateY(550);
        buttonSE.setTranslateX(260);
        buttonSE.setTranslateY(600);
        buttonSW.setTranslateX(240);
        buttonSW.setTranslateY(500);
        buttonW.setTranslateX(240);
        buttonW.setTranslateY(550);
        buttonNW.setTranslateX(240);
        buttonNW.setTranslateY(600);
//----------------------------------------------------------------------------------------------------------------------

        //Making the buttons Not visible
        buttonDefendLeft.setVisible(false);
        buttonAttackLeft.setVisible(false);
        buttonNothingLeft.setVisible(false);

        buttonRotate.setVisible(false);
        buttonMove.setVisible(false);
        buttonNothingMove.setVisible(false);

        buttonDefendRight.setVisible(false);
        buttonAttackRight.setVisible(false);
        buttonNothingRight.setVisible(false);

        buttonRotateUp.setVisible(false);
        buttonRotateDown.setVisible(false);

        buttonNE.setVisible(false);
        buttonE.setVisible(false);
        buttonSE.setVisible(false);
        buttonSW.setVisible(false);
        buttonW.setVisible(false);
        buttonNW.setVisible(false);

//----------------------------------------------------------------------------------------------------------------------

        //Resizing the buttons
        buttonLeft.setPrefSize(80, 80);
        buttonRight.setPrefSize(80, 80);
        buttonDir.setPrefSize(80, 80);

        buttonAttackLeft.setPrefSize(151,49);
        buttonDefendLeft.setPrefSize(151,49);
        buttonNothingLeft.setPrefSize(151,49);

        buttonRotate.setPrefSize(151,49);
        buttonMove.setPrefSize(151,49);
        buttonNothingMove.setPrefSize(151,49);

        buttonAttackRight.setPrefSize(151,49);
        buttonDefendRight.setPrefSize(151,49);
        buttonNothingRight.setPrefSize(151,49);

        buttonRotateUp.setPrefSize(151,75);
        buttonRotateDown.setPrefSize(151,75);

        buttonSE.setPrefSize(75,49);
        buttonE.setPrefSize(75,49);
        buttonSE.setPrefSize(75,49);
        buttonSW.setPrefSize(75,49);
        buttonW.setPrefSize(75,49);
        buttonNW.setPrefSize(75,49);
//----------------------------------------------------------------------------------------------------------------------

        //Putting the images in button placeholder
        buttonLeft.setGraphic(viewLeftHand);
        buttonRight.setGraphic(viewRightHand);
        buttonDir.setGraphic(viewDirections);

        buttonAttackLeft.setText("Attack!");
        buttonDefendLeft.setText("Defend!");
        buttonNothingLeft.setText("Do Nothing");

        buttonRotate.setText("Rotate");
        buttonMove.setText("Move");
        buttonNothingMove.setText("Do Nothing");

        buttonAttackRight.setText("Attack!");
        buttonDefendRight.setText("Defend!");
        buttonNothingRight.setText("Do Nothing");

        buttonRotateUp.setText("Rotate NortWest");
        buttonRotateDown.setText("Rotate SouthEast");

        buttonNE.setText("North East");
        buttonE.setText("East");
        buttonSE.setText("South East");
        buttonSW.setText("South West");
        buttonW.setText("West");
        buttonNW.setText("North West");

//----------------------------------------------------------------------------------------------------------------------

        primaryStage.setTitle("Arena");

        Image arena = new Image("sample/resources/hexagon.png");
        Image testGlad = new Image( "sample/resources/testGlad.png");

        ImageView viewArena = new ImageView(arena);
        viewArena.setFitHeight(450);
        viewArena.setPreserveRatio(true);

//----------------------------------------------------------------------------------------------------------------------

        buttonLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (buttonAttackLeft.isVisible()) {
                    buttonAttackLeft.setVisible(false);
                    buttonDefendLeft.setVisible(false);
                    buttonNothingLeft.setVisible(false);
                } else {
                    buttonAttackLeft.setVisible(true);
                    buttonDefendLeft.setVisible(true);
                    buttonNothingLeft.setVisible(true);
                }
            }
        });

        buttonAttackLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Attack method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
            }
        });

        buttonDefendLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Defend method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
            }
        });

        buttonNothingLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Nothing method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
            }
        });

//----------------------------------------------------------------------------------------------------------------------

        buttonDir.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (buttonRotate.isVisible()) {
                    buttonRotate.setVisible(false);
                    buttonMove.setVisible(false);
                    buttonNothingMove.setVisible(false);
                } else {
                    buttonRotate.setVisible(true);
                    buttonMove.setVisible(true);
                    buttonNothingMove.setVisible(true);
                }
            }
        });

        buttonRotate.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Rotate method
                buttonRotateUp.setVisible(true);
                buttonRotateDown.setVisible(true);
            }
        });

        buttonMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Move method
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonNothingMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Nothing method
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

//----------------------------------------------------------------------------------------------------------------------

        buttonRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (buttonAttackRight.isVisible()) {
                    buttonAttackRight.setVisible(false);
                    buttonDefendRight.setVisible(false);
                    buttonNothingRight.setVisible(false);
                } else {
                    buttonAttackRight.setVisible(true);
                    buttonDefendRight.setVisible(true);
                    buttonNothingRight.setVisible(true);
                }
            }
        });

        buttonAttackRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Attack method
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);
            }
        });

        buttonDefendRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Defend method
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);
            }
        });

        buttonNothingRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //Nothing method
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);
            }
        });


        buttonRotateUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //RotateUp method
                buttonRotateUp.setVisible(false);
                buttonRotateDown.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonRotateDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //RotateDown method
                buttonRotateUp.setVisible(false);
                buttonRotateDown.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });


        Group root = new Group(
                viewArena, buttonLeft,buttonRight,buttonDir,
                buttonAttackLeft,buttonDefendLeft,buttonNothingLeft,
                buttonRotate,buttonMove,buttonNothingMove,
                buttonAttackRight,buttonDefendRight,buttonNothingRight,
                buttonRotateUp,buttonRotateDown);
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
