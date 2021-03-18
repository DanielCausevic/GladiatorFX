package sample.Model.Action;

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
import sample.Model.Gladiator.Gladiator;


public class Buttons extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

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
               /*if (gladiator.getWeapon == sword || axe || dagger) {
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


               } else if (gladiator.getWeapon == trident) {

                */
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
                // }

                //Attack method
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
                //insert MoveSE Method
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

//Putting images in GUI

        primaryStage.setTitle("Arena");

        Image arena = new Image("sample/resources/hexagon.png");
        Image testGlad = new Image("sample/resources/testGlad.png");

        ImageView viewArena = new ImageView(arena);
        viewArena.setFitHeight(450);
        viewArena.setPreserveRatio(true);

//----------------------------------------------------------------------------------------------------------------------

        //Visualize all the buttons
        Group root = new Group(
                viewArena, buttonLeft, buttonRight, buttonDir,
                buttonAttackLeft, buttonDefendLeft, buttonNothingLeft,
                buttonRotate, buttonMove, buttonNothingMove,
                buttonAttackRight, buttonDefendRight, buttonNothingRight,
                buttonStab, buttonSlash, buttonThrow, buttonPull,
                buttonHead, buttonBody, buttonLeg,
                buttonRotateNW, buttonRotateSE, buttonRotateNE, buttonRotateSW, buttonRotateE, buttonRotateW,
                buttonNE, buttonE, buttonSE, buttonSW, buttonW, buttonNW);


        //Creating the GUI with the Root (All the buttons & pictues), & scaling the GUI window.
        Scene theScene = new Scene(root, 650, 700);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas(650, 500);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Putting in the gladiator
        gc.drawImage(testGlad, 330, 325);

        primaryStage.show();


    }
}

