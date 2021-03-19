package sample.Controller;

import javafx.animation.AnimationTimer;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.Arena.Arena;
import sample.Arena.Hex;
import sample.Arena.Point;
import sample.Model.Action.Attack;
import sample.Model.Gladiator.Gladiator;
import sample.Model.Gladiator.Weapon;
import sample.Model.Gladiator.Weapons;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author Rasmus, Nicolai
 * Klassen styrer main game loop mv.
 */

public class GameController extends Application {
    private boolean running;

    // May be obsolete
    private Gladiator gladiator;
    private Arena arena;

    // Constructor
    public GameController() {
    }

    // Instanciates objects needed to launch the main loop (run());
    @Override
    public void start(Stage stage) throws Exception{
        // Stage = Main window-frame
        stage.setTitle("Gladiator FX");

        //Creating images
        Image leftHand = new Image("sample/resources/lefthand.jpg");
        Image rightHand = new Image("sample/resources/righthand.jpg");
        Image directions = new Image("sample/resources/directions.jpg");
        ImageView viewLeftHand = new ImageView(leftHand);
        ImageView viewRightHand = new ImageView(rightHand);
        ImageView viewDirections = new ImageView(directions);

        //Resizing the images
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
        Button buttonRotateNW = new Button();
        Button buttonRotateE = new Button();
        Button buttonRotateNE = new Button();
        Button buttonRotateSE = new Button();
        Button buttonRotateW = new Button();
        Button buttonRotateSW = new Button();

        //Move
        Button buttonNE = new Button();
        Button buttonE = new Button();
        Button buttonSE = new Button();
        Button buttonSW = new Button();
        Button buttonW = new Button();
        Button buttonNW = new Button();

        //Attack
        Button buttonStab = new Button();
        Button buttonSlash = new Button();
        Button buttonThrow = new Button();
        Button buttonPull = new Button();

        //Bodypart
        Button buttonHead = new Button();
        Button buttonBody = new Button();
        Button buttonLeg = new Button();

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

        buttonRotateNW.setTranslateX(240);
        buttonRotateNW.setTranslateY(500);
        buttonRotateNE.setTranslateX(315);
        buttonRotateNE.setTranslateY(500);
        buttonRotateW.setTranslateX(240);
        buttonRotateW.setTranslateY(550);
        buttonRotateE.setTranslateX(315);
        buttonRotateE.setTranslateY(550);
        buttonRotateSW.setTranslateX(240);
        buttonRotateSW.setTranslateY(600);
        buttonRotateSE.setTranslateX(315);
        buttonRotateSE.setTranslateY(600);

        buttonNE.setTranslateX(315);
        buttonNE.setTranslateY(500);
        buttonE.setTranslateX(315);
        buttonE.setTranslateY(550);
        buttonSE.setTranslateX(315);
        buttonSE.setTranslateY(600);

        buttonSW.setTranslateX(240);
        buttonSW.setTranslateY(600);
        buttonW.setTranslateX(240);
        buttonW.setTranslateY(550);
        buttonNW.setTranslateX(240);
        buttonNW.setTranslateY(500);

        buttonStab.setTranslateX(450);
        buttonStab.setTranslateY(500);
        buttonSlash.setTranslateX(450);
        buttonSlash.setTranslateY(575);
        buttonThrow.setTranslateX(450);
        buttonThrow.setTranslateY(500);
        buttonPull.setTranslateX(450);
        buttonPull.setTranslateY(575);

        buttonHead.setTranslateX(30);
        buttonHead.setTranslateY(500);
        buttonBody.setTranslateX(30);
        buttonBody.setTranslateY(550);
        buttonLeg.setTranslateX(30);
        buttonLeg.setTranslateY(600);


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

        buttonRotateNW.setVisible(false);
        buttonRotateNE.setVisible(false);
        buttonRotateSW.setVisible(false);
        buttonRotateSE.setVisible(false);
        buttonRotateE.setVisible(false);
        buttonRotateW.setVisible(false);

        buttonNE.setVisible(false);
        buttonE.setVisible(false);
        buttonSE.setVisible(false);
        buttonSW.setVisible(false);
        buttonW.setVisible(false);
        buttonNW.setVisible(false);

        buttonStab.setVisible(false);
        buttonSlash.setVisible(false);
        buttonThrow.setVisible(false);
        buttonPull.setVisible(false);

        buttonHead.setVisible(false);
        buttonBody.setVisible(false);
        buttonLeg.setVisible(false);

//----------------------------------------------------------------------------------------------------------------------

        //Resizing the buttons
        buttonLeft.setPrefSize(80, 80);
        buttonRight.setPrefSize(80, 80);
        buttonDir.setPrefSize(80, 80);

        buttonAttackLeft.setPrefSize(151, 49);
        buttonDefendLeft.setPrefSize(151, 49);
        buttonNothingLeft.setPrefSize(151, 49);

        buttonRotate.setPrefSize(151, 49);
        buttonMove.setPrefSize(151, 49);
        buttonNothingMove.setPrefSize(151, 49);

        buttonAttackRight.setPrefSize(151, 49);
        buttonDefendRight.setPrefSize(151, 49);
        buttonNothingRight.setPrefSize(151, 49);

        buttonRotateNW.setPrefSize(75, 49);
        buttonRotateNE.setPrefSize(75, 49);
        buttonRotateSW.setPrefSize(75, 49);
        buttonRotateSE.setPrefSize(75, 49);
        buttonRotateW.setPrefSize(75, 49);
        buttonRotateE.setPrefSize(75, 49);

        buttonNE.setPrefSize(75, 49);
        buttonE.setPrefSize(75, 49);
        buttonSE.setPrefSize(75, 49);
        buttonSW.setPrefSize(75, 49);
        buttonW.setPrefSize(75, 49);
        buttonNW.setPrefSize(75, 49);

        buttonStab.setPrefSize(151, 75);
        buttonSlash.setPrefSize(151, 75);
        buttonThrow.setPrefSize(75, 75);
        buttonPull.setPrefSize(75, 75);

        buttonHead.setPrefSize(151, 49);
        buttonBody.setPrefSize(151, 49);
        buttonLeg.setPrefSize(151, 49);

//----------------------------------------------------------------------------------------------------------------------

        //Putting the images in button placeholder
        buttonLeft.setGraphic(viewLeftHand);
        buttonRight.setGraphic(viewRightHand);
        buttonDir.setGraphic(viewDirections);

        //Writing text in buttons
        buttonAttackLeft.setText("Attack!");
        buttonDefendLeft.setText("Defend!");
        buttonNothingLeft.setText("Do Nothing");

        buttonRotate.setText("Rotate");
        buttonMove.setText("Move");
        buttonNothingMove.setText("Do Nothing");

        buttonAttackRight.setText("Attack!");
        buttonDefendRight.setText("Defend!");
        buttonNothingRight.setText("Do Nothing");

        buttonRotateNW.setText("Rotate NW");
        buttonRotateNE.setText("Rotate NE");
        buttonRotateSW.setText("Rotate SW");
        buttonRotateSE.setText("Rotate SE");
        buttonRotateW.setText("Rotate W");
        buttonRotateE.setText("Rotate E");

        buttonNE.setText("NE");
        buttonE.setText("E");
        buttonSE.setText("SE");
        buttonSW.setText("SW");
        buttonW.setText("W");
        buttonNW.setText("NW");

        buttonStab.setText("Stab");
        buttonSlash.setText("Slash");
        buttonThrow.setText("Throw Net");
        buttonPull.setText("Pull Net");

        buttonHead.setText("Head");
        buttonBody.setText("Body");
        buttonLeg.setText("Legs");

//----------------------------------------------------------------------------------------------------------------------

        //Making Action when pressing buttons (LEFT HAND)

        buttonLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                buttonAttackLeft.setVisible(true);
                buttonDefendLeft.setVisible(true);
                buttonNothingLeft.setVisible(true);
            }
        });

        buttonAttackLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Attack method
               //(gladiator.getWeapon == sword || axe || dagger) {
                    buttonStab.setVisible(true);
                    buttonSlash.setVisible(true);
                    buttonThrow.setVisible(false);
                    buttonPull.setVisible(false);
                    buttonAttackRight.setVisible(false);
                    buttonDefendRight.setVisible(false);
                    buttonNothingRight.setVisible(false);
                    buttonStab.setPrefSize(151, 75);
                    buttonSlash.setPrefSize(151, 75);
                    buttonStab.setTranslateX(30);
                    buttonStab.setTranslateY(500);
                    buttonSlash.setTranslateX(30);
                    buttonSlash.setTranslateY(575);

              /* } else if (gladiator.getWeapon == trident) {

                buttonStab.setVisible(true);
                buttonSlash.setVisible(true);
                buttonThrow.setVisible(true);
                buttonPull.setVisible(true);
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);

                buttonStab.setPrefSize(75, 75);
                buttonSlash.setPrefSize(75, 75);
                buttonThrow.setPrefSize(75, 75);
                buttonPull.setPrefSize(75, 75);

                buttonStab.setTranslateX(30);
                buttonStab.setTranslateY(500);
                buttonSlash.setTranslateX(105);
                buttonSlash.setTranslateY(500);
                buttonThrow.setTranslateX(30);
                buttonThrow.setTranslateY(575);
                buttonPull.setTranslateX(105);
                buttonPull.setTranslateY(575);
            }

               */

            }
        });

        buttonDefendLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Defend method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
            }
        });

        buttonNothingLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Nothing method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
            }
        });

//----------------------------------------------------------------------------------------------------------------------

        //Making Action when pressing buttons (DIRECTION)

        buttonDir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                buttonRotate.setVisible(true);
                buttonMove.setVisible(true);
                buttonNothingMove.setVisible(true);

            }
        });

        buttonRotate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert Rotate method
                buttonRotateNW.setVisible(true);
                buttonRotateNE.setVisible(true);
                buttonRotateSW.setVisible(true);
                buttonRotateSE.setVisible(true);
                buttonRotateW.setVisible(true);
                buttonRotateE.setVisible(true);

            }
        });

        buttonMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert Move method
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonNothingMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert Nothing method
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

//----------------------------------------------------------------------------------------------------------------------

        //Making Action when pressing buttons (RIGHT HAND)

        buttonRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                buttonAttackRight.setVisible(true);
                buttonDefendRight.setVisible(true);
                buttonNothingRight.setVisible(true);
            }
        });

        buttonAttackRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert Attack method
                //if (gladiator.getWeapon == sword || axe || dagger) {
                buttonStab.setVisible(true);
                buttonSlash.setVisible(true);
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
                buttonThrow.setVisible(false);
                buttonPull.setVisible(false);

                buttonStab.setPrefSize(151, 75);
                buttonSlash.setPrefSize(151, 75);
                buttonStab.setTranslateX(450);
                buttonStab.setTranslateY(500);
                buttonSlash.setTranslateX(450);
                buttonSlash.setTranslateY(575);

               /* } else if (gladiator.getWeapon == trident) {
                    buttonStab.setVisible(true);
                    buttonSlash.setVisible(true);
                    buttonThrow.setVisible(true);
                    buttonPull.setVisible(true);
                    buttonAttackLeft.setVisible(false);
                    buttonDefendLeft.setVisible(false);
                    buttonNothingLeft.setVisible(false);
                    buttonStab.setPrefSize(75, 75);
                    buttonSlash.setPrefSize(75, 75);
                    buttonThrow.setPrefSize(75, 75);
                    buttonPull.setPrefSize(75, 75);
                    buttonStab.setTranslateX(450);
                    buttonStab.setTranslateY(500);
                    buttonSlash.setTranslateX(525);
                    buttonSlash.setTranslateY(500);
                    buttonThrow.setTranslateX(450);
                    buttonThrow.setTranslateY(575);
                    buttonPull.setTranslateX(525);
                    buttonPull.setTranslateY(575);
               }
                 */
            }
        });

        buttonDefendRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert Defend method
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);
            }
        });

        buttonNothingRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert Nothing method
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);
            }
        });

//----------------------------------------------------------------------------------------------------------------------

        //AttackType

        buttonStab.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Defend method
                buttonStab.setVisible(false);
                buttonSlash.setVisible(false);
                buttonThrow.setVisible(false);
                buttonPull.setVisible(false);


                if (buttonAttackRight.isVisible()) {
                    buttonHead.setVisible(true);
                    buttonBody.setVisible(true);
                    buttonLeg.setVisible(true);

                    buttonHead.setTranslateX(450);
                    buttonHead.setTranslateY(500);
                    buttonBody.setTranslateX(450);
                    buttonBody.setTranslateY(550);
                    buttonLeg.setTranslateX(450);
                    buttonLeg.setTranslateY(600);

                } else if (buttonAttackLeft.isVisible()) {

                    buttonHead.setVisible(true);
                    buttonBody.setVisible(true);
                    buttonLeg.setVisible(true);

                    buttonHead.setTranslateX(30);
                    buttonHead.setTranslateY(500);
                    buttonBody.setTranslateX(30);
                    buttonBody.setTranslateY(550);
                    buttonLeg.setTranslateX(30);
                    buttonLeg.setTranslateY(600);
                }
            }
        });

        buttonSlash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Defend method
                buttonStab.setVisible(false);
                buttonSlash.setVisible(false);
                buttonThrow.setVisible(false);
                buttonPull.setVisible(false);


                if (buttonAttackRight.isVisible()) {
                    buttonHead.setVisible(true);
                    buttonBody.setVisible(true);
                    buttonLeg.setVisible(true);

                    buttonHead.setTranslateX(450);
                    buttonHead.setTranslateY(500);
                    buttonBody.setTranslateX(450);
                    buttonBody.setTranslateY(550);
                    buttonLeg.setTranslateX(450);
                    buttonLeg.setTranslateY(600);

                } else if (buttonAttackLeft.isVisible()) {

                    buttonHead.setVisible(true);
                    buttonBody.setVisible(true);
                    buttonLeg.setVisible(true);

                    buttonHead.setTranslateX(30);
                    buttonHead.setTranslateY(500);
                    buttonBody.setTranslateX(30);
                    buttonBody.setTranslateY(550);
                    buttonLeg.setTranslateX(30);
                    buttonLeg.setTranslateY(600);
                }
            }
        });

        buttonThrow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Defend method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);

                buttonStab.setVisible(false);
                buttonSlash.setVisible(false);
                buttonThrow.setVisible(false);
                buttonPull.setVisible(false);
            }
        });

        buttonPull.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Defend method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);

                buttonStab.setVisible(false);
                buttonSlash.setVisible(false);
                buttonThrow.setVisible(false);
                buttonPull.setVisible(false);
            }
        });

//----------------------------------------------------------------------------------------------------------------------

        //Bodyparts

        buttonHead.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Defend method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);

                buttonStab.setVisible(false);
                buttonSlash.setVisible(false);
                buttonThrow.setVisible(false);
                buttonPull.setVisible(false);

                buttonHead.setVisible(false);
                buttonBody.setVisible(false);
                buttonLeg.setVisible(false);
            }
        });

        buttonBody.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Defend method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);

                buttonStab.setVisible(false);
                buttonSlash.setVisible(false);
                buttonThrow.setVisible(false);
                buttonPull.setVisible(false);

                buttonHead.setVisible(false);
                buttonBody.setVisible(false);
                buttonLeg.setVisible(false);
            }
        });

        buttonLeg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //Defend method
                buttonAttackLeft.setVisible(false);
                buttonDefendLeft.setVisible(false);
                buttonNothingLeft.setVisible(false);
                buttonAttackRight.setVisible(false);
                buttonDefendRight.setVisible(false);
                buttonNothingRight.setVisible(false);

                buttonStab.setVisible(false);
                buttonSlash.setVisible(false);
                buttonThrow.setVisible(false);
                buttonPull.setVisible(false);

                buttonHead.setVisible(false);
                buttonBody.setVisible(false);
                buttonLeg.setVisible(false);
            }
        });

//----------------------------------------------------------------------------------------------------------------------

        //Making Action when pressing buttons (ROTATE)

        buttonRotateNW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert RotateNW method
                //When pressing a rotation, then Move & Nothing button will show only
                buttonRotateNW.setVisible(false);
                buttonRotateNE.setVisible(false);
                buttonRotateSW.setVisible(false);
                buttonRotateSE.setVisible(false);
                buttonRotateW.setVisible(false);
                buttonRotateE.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);

            }
        });

        buttonRotateSE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert RotateSE method
                //When pressing a rotation, then Move & Nothing button will show only
                buttonRotateNW.setVisible(false);
                buttonRotateNE.setVisible(false);
                buttonRotateSW.setVisible(false);
                buttonRotateSE.setVisible(false);
                buttonRotateW.setVisible(false);
                buttonRotateE.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonRotateNE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert RotateNE method
                //When pressing a rotation, then Move & Nothing button will show only
                buttonRotateNW.setVisible(false);
                buttonRotateNE.setVisible(false);
                buttonRotateSW.setVisible(false);
                buttonRotateSE.setVisible(false);
                buttonRotateW.setVisible(false);
                buttonRotateE.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonRotateSW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert RotateSW method
                //When pressing a rotation, then Move & Nothing button will show only
                buttonRotateNW.setVisible(false);
                buttonRotateNE.setVisible(false);
                buttonRotateSW.setVisible(false);
                buttonRotateSE.setVisible(false);
                buttonRotateW.setVisible(false);
                buttonRotateE.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }

        });


        buttonRotateW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert RotateNW method
                //When pressing a rotation, then Move & Nothing button will show only
                buttonRotateNW.setVisible(false);
                buttonRotateNE.setVisible(false);
                buttonRotateSW.setVisible(false);
                buttonRotateSE.setVisible(false);
                buttonRotateW.setVisible(false);
                buttonRotateE.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonRotateE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert RotateNW method
                //When pressing a rotation, then Move & Nothing button will show only
                buttonRotateNW.setVisible(false);
                buttonRotateNE.setVisible(false);
                buttonRotateSW.setVisible(false);
                buttonRotateSE.setVisible(false);
                buttonRotateW.setVisible(false);
                buttonRotateE.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });


//----------------------------------------------------------------------------------------------------------------------

        //Making Action when pressing buttons (MOVE)

        buttonMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //When pressing button, all Movebuttons should turn visible
                buttonNE.setVisible(true);
                buttonE.setVisible(true);
                buttonSE.setVisible(true);
                buttonSW.setVisible(true);
                buttonW.setVisible(true);
                buttonNW.setVisible(true);

            }
        });

        buttonNE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert MoveNE Method
                //Make all buttons not visible
                buttonNE.setVisible(false);
                buttonE.setVisible(false);
                buttonSE.setVisible(false);
                buttonSW.setVisible(false);
                buttonW.setVisible(false);
                buttonNW.setVisible(false);

                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert MoveE Method
                //Make all buttons not visible
                buttonNE.setVisible(false);
                buttonE.setVisible(false);
                buttonSE.setVisible(false);
                buttonSW.setVisible(false);
                buttonW.setVisible(false);
                buttonNW.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonSE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //gladiator.move("SE"
                //Make all buttons not visible
                buttonNE.setVisible(false);
                buttonE.setVisible(false);
                buttonSE.setVisible(false);
                buttonSW.setVisible(false);
                buttonW.setVisible(false);
                buttonNW.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonSW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert MoveSW Method
                //Make all buttons not visible
                buttonNE.setVisible(false);
                buttonE.setVisible(false);
                buttonSE.setVisible(false);
                buttonSW.setVisible(false);
                buttonW.setVisible(false);
                buttonNW.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert MoveW Method
                //Make all buttons not visible
                buttonNE.setVisible(false);
                buttonE.setVisible(false);
                buttonSE.setVisible(false);
                buttonSW.setVisible(false);
                buttonW.setVisible(false);
                buttonNW.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

        buttonNW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //insert MoveNW Method
                //Make all buttons not visible
                buttonNE.setVisible(false);
                buttonE.setVisible(false);
                buttonSE.setVisible(false);
                buttonSW.setVisible(false);
                buttonW.setVisible(false);
                buttonNW.setVisible(false);
                buttonRotate.setVisible(false);
                buttonMove.setVisible(false);
                buttonNothingMove.setVisible(false);
            }
        });

//----------------------------------------------------------------------------------------------------------------------


        // Scene with root group = primary place to hold objects on.
        Group root = new Group(buttonLeft, buttonRight, buttonDir,
                buttonAttackLeft, buttonDefendLeft, buttonNothingLeft,
                buttonRotate, buttonMove, buttonNothingMove,
                buttonAttackRight, buttonDefendRight, buttonNothingRight,
                buttonStab, buttonSlash, buttonThrow, buttonPull,
                buttonHead, buttonBody, buttonLeg,
                buttonRotateNW, buttonRotateSE, buttonRotateNE, buttonRotateSW, buttonRotateE, buttonRotateW,
                buttonNE, buttonE, buttonSE, buttonSW, buttonW, buttonNW);
        Scene scene = new Scene(root, 900,700);
        stage.setScene(scene);

        // Canvas = Primary place in root group to paint on.
        Canvas canvas = new Canvas(900, 700);

        root.getChildren().add(canvas);

        // GraphicsContext = Engine to draw images and text
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Arena graphics and position
        Arena arena = new Arena(8, 50, 100);

        //Dummy gladiator graphics and position
        Image dummy = new Image("sample/resources/glad_n.gif");
        Gladiator d_gladiator = new Gladiator(dummy, dummy, dummy, dummy, 30, 48, new Point(0, 0));
        Hex dummyHex = arena.getArena()[5][4]; // NOT actual Point position coordinates, but 2D array indexes
        d_gladiator.setX(dummyHex.getX());
        d_gladiator.setY(dummyHex.getY()-8);

        //Dead dummy gladiator
        Image deadDummy = new Image("sample/resources/glad_down.png",55,55,false,false);
        Gladiator deadD_gladiator = new Gladiator(deadDummy, deadDummy, deadDummy, deadDummy, 30, 64, new Point(0, 0));

        // Gladiator graphics and position
        Image northOrient = new Image("sample/resources/glad_n.gif");
        Image eastOrient = new Image("sample/resources/glad_e.gif");
        Image southOrient = new Image("sample/resources/glad_s.gif");
        Image westOrient = new Image("sample/resources/glad_w.gif");
        Gladiator gladiator = new Gladiator(northOrient, westOrient, southOrient, eastOrient, 30, 48, new Point(0, 0));

        //gladiator start position

        Hex gladHex = arena.getArena()[2][5]; // gladiator start pos

        arena.getArena()[0][2].setHolds(gladiator); //set start hex to hold gladiator
        System.out.println(arena.getArena()[0][2].isContainingObject()); //false, dont know why
        //gladHex.setHolds(gladiator);
        gladiator.setX(gladHex.getX()); //set x for
        gladiator.setY(gladHex.getY()); //set x for
        gladiator.setPosition((int)gladHex.getX(),(int) gladHex.getY()); //set gladiator point

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

                // checks if dummy is dead, and renders accordingly
                if (!d_gladiator.isDead()) {
                    d_gladiator.render(gc);
                    gc.fillText("Dummy", 500,20);
                    gc.fillText("HP: " + String.valueOf(d_gladiator.getHP()), 500, 40);
                } else {
                    deadD_gladiator.setX(d_gladiator.getX()-12);
                    deadD_gladiator.setY(d_gladiator.getY());
                    deadD_gladiator.render(gc);
                    gc.fillText("Dummy", 500,20);
                    gc.fillText("HP: 0" , 500, 40);
                }

                gc.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
                gc.fillText("Player 1", 10,20);
                gc.fillText("HP: " + String.valueOf(gladiator.getHP()), 10, 40);
                gc.fillText("Condition: " + String.valueOf(gladiator.getConditioning()), 10, 60);

            }
        }.start();

        // Example of gladiator re-orientation and rendering
        //int movement = 2;
        /*
         Image testGlad = new Image( "sample/resources/testGlad.png");
    Gladiator gladiator = new Gladiator(testGlad,100, 100, new Point(1,1));
    Dummy dummy = new Dummy(testGlad,100, 100, new Point(1,2), 1000);
    Weapons weapons = new Weapons();
    Weapon Dagger = new Weapon("Dagger", 0, 0.5);
    Weapon longSword2H = new Weapon("Long sword - 2H", 60, 15.0);
    Attack attack = new Attack(2,2);
    System.out.println(dummy.getHP());

    gladiator.addWeaponToMain(longSword2H);
    for (int i = 0; i < 200; i++) {
        attack.attackDummy(dummy, gladiator);
        System.out.println(dummy.getHP());
        if(dummy.getHP() == 0){
            System.out.println("Dummy dead!!");
            break;
        }
         */

        Weapon longSword2H = new Weapon("Long sword - 2H", 60, 15.0);
        Attack attack = new Attack(2,2);


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                double currentX = gladiator.getX();
                double currentY = gladiator.getY();
                int calculateCurrentHexCoordX;
                int calculateCurrentHexCoordY;

                if (keyEvent.getCode().toString().equals("A")) {
                    //gladiator.setX(currentX - movement);
                    gladiator.setOrientation("W");
                    gladiator.move(5, arena.getAdjacent(gladiator.getPosition()));
                    //move gladiator sprite
                    gladiator.setX(gladiator.getPosition().getX()); //set x for sprite pixel coordinate
                    gladiator.setY(gladiator.getPosition().getY()); //set y for sprite pixel coordinate

                    //calculate the hex coordinates to check if hex is containing gladiator
                    calculateCurrentHexCoordX = (gladiator.getPosition().getX() - 146) / 64;
                    calculateCurrentHexCoordY = (gladiator.getPosition().getY() - 196) / 64;
                    Hex currentHex = arena.getArena()[calculateCurrentHexCoordX][calculateCurrentHexCoordY];
                    currentHex.setHolds(gladiator);
                }
                if (keyEvent.getCode().toString().equals("D")) {
                    //gladiator.setX(currentX + movement);
                    gladiator.setOrientation("E");
                    gladiator.move(2, arena.getAdjacent(gladiator.getPosition()));
                    //move gladiator sprite
                    gladiator.setX(gladiator.getPosition().getX()); //set x for sprite pixel coordinate
                    gladiator.setY(gladiator.getPosition().getY()); //set y for sprite pixel coordinate
                    //calculate the hex coordinates to check if hex is containing gladiator
                    calculateCurrentHexCoordX = (gladiator.getPosition().getX() - 146) / 64;
                    calculateCurrentHexCoordY = (gladiator.getPosition().getY() - 196) / 64;
                    Hex currentHex = arena.getArena()[calculateCurrentHexCoordX][calculateCurrentHexCoordY];
                    currentHex.setHolds(gladiator);

                }
                if (keyEvent.getCode().toString().equals("W")) {
                    //gladiator.setOrientation("N");
                    gladiator.setOrientation("NW");
                    gladiator.move(6, arena.getAdjacent(gladiator.getPosition()));
                    //move gladiator sprite
                    gladiator.setX(gladiator.getPosition().getX()); //set x for sprite pixel coordinate
                    gladiator.setY(gladiator.getPosition().getY()); //set y for sprite pixel coordinate
                    //System.out.println("Get x max coordinate: "+arena.getMaxX(arena.getArena()));

                    //calculate the hex coordinates to check if hex is containing gladiator
                    calculateCurrentHexCoordX = (gladiator.getPosition().getX() - 146) / 64;
                    calculateCurrentHexCoordY = (gladiator.getPosition().getY() - 196) / 64;
                    Hex currentHex = arena.getArena()[calculateCurrentHexCoordX][calculateCurrentHexCoordY];
                    currentHex.setHolds(gladiator);
                }
                if (keyEvent.getCode().toString().equals("S")) {
                    //gladiator.setY(currentY + movement );
                    gladiator.setOrientation("NE");

                    gladiator.move(1, arena.getAdjacent(gladiator.getPosition()));
                    //move gladiator sprite
                    gladiator.setX(gladiator.getPosition().getX()); //set x for sprite pixel coordinate
                    gladiator.setY(gladiator.getPosition().getY()); //set y for sprite pixel coordinate
                    //System.out.println("Get x max coordinate: "+arena.getMaxX(arena.getArena()));

                    //calculate the hex coordinates to check if hex is containing gladiator
                    calculateCurrentHexCoordX = (gladiator.getPosition().getX() - 146) / 64;
                    calculateCurrentHexCoordY = (gladiator.getPosition().getY() - 196) / 64;
                    Hex currentHex = arena.getArena()[calculateCurrentHexCoordX][calculateCurrentHexCoordY];
                    currentHex.setHolds(gladiator);
                }
                if (keyEvent.getCode().toString().equals("X")) {
                    //gladiator.setY(currentY + movement );
                    gladiator.setOrientation("S");

                    gladiator.move(3, arena.getAdjacent(gladiator.getPosition()));
                    //move gladiator sprite
                    gladiator.setX(gladiator.getPosition().getX()); //set x for sprite pixel coordinate
                    gladiator.setY(gladiator.getPosition().getY()); //set y for sprite pixel coordinate
                    //System.out.println("Get x max coordinate: "+arena.getMaxX(arena.getArena()));

                    //calculate the hex coordinates to check if hex is containing gladiator
                    calculateCurrentHexCoordX = (gladiator.getPosition().getX() - 146) / 64;
                    calculateCurrentHexCoordY = (gladiator.getPosition().getY() - 196) / 64;
                    Hex currentHex = arena.getArena()[calculateCurrentHexCoordX][calculateCurrentHexCoordY];
                    currentHex.setHolds(gladiator);
                }
                if (keyEvent.getCode().toString().equals("Z")) {
                    //gladiator.setY(currentY + movement );

                    gladiator.move(4, arena.getAdjacent(gladiator.getPosition()));
                    //move gladiator sprite
                    gladiator.setX(gladiator.getPosition().getX()); //set x for sprite pixel coordinate
                    gladiator.setY(gladiator.getPosition().getY()); //set y for sprite pixel coordinate
                    //System.out.println("Get x max coordinate: "+arena.getMaxX(arena.getArena()));

                    //calculate the hex coordinates to check if hex is containing gladiator
                    calculateCurrentHexCoordX = (gladiator.getPosition().getX() - 146) / 64;
                    calculateCurrentHexCoordY = (gladiator.getPosition().getY() - 196) / 64;
                    Hex currentHex = arena.getArena()[calculateCurrentHexCoordX][calculateCurrentHexCoordY];
                    currentHex.setHolds(gladiator);
                }

                if (keyEvent.getCode().toString().equals("P")){
                    gladiator.addWeaponToMain(longSword2H);
                    int damage = attack.hitAttack(gladiator, d_gladiator);
                    if (!d_gladiator.isDead()) {
                        gc.fillText("Player attacked dummy for " + damage , 600, 100+(gladiator.getCounter()*15));
                        gladiator.setCounter(gladiator.getCounter()+1);
                    }

                }
            }
        });

        stage.show();
    }

    // Kører programmet
    public void run() {
        running = true;

        while (running) {

            lobbyLoop();              // Main menu Loop
            gladiatorChoiceLoop();    // Gladiator equipment loop
            arenaChoiceLoop();        // Arena choice loop
            fightLoop();              // Main combat loop
            // endOfFightLoop();

            // When fight loop exits, it loops back to lobby and repeats unless prompted otherwise by user
        }

        // When running != true, exits the program
        System.exit(1);

    }

    public void lobbyLoop() {
    }

    private void gladiatorChoiceLoop() {
        gladiator = null; // Game loop that in the end returns a gladiator with equipment and relevant stats
    }

    private void arenaChoiceLoop() {
    }

    public void fightLoop() {
        int round = 0;
        boolean fightIsOn = true; // bedre navn til variabel?

        // wait for user input
        while (fightIsOn) {

            playerChoiceLoop();

            // After player has made their choices:
            // calculateMovement();
            // calculateOrientation();
            // calculateHits();
            // calculateStats();
            round++;
            // Update & and re-render screen

            // If gladiator hit points <= 0, fightIsOn = false; and loop breaks

        }

    }

    public void playerChoiceLoop() {
        boolean playerReady = false;
        boolean playerOccupied = false;

        while (!playerReady || !playerOccupied) {
            // Run input loop where user gets to choose input for left hand, right hand and movement through a GUI
            // If player is occupied (left hand, right hand, movement), playerOccupied = true and round advances
            // if player checks ready, round advances
            // If player surrenders, fightIsOn = false; and loop breaks
        }

    }




}