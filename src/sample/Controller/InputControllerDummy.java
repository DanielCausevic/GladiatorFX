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



//----------------------------------------------------------------------------------------------------------------------

        //Putting images in GUI

        primaryStage.setTitle("Arena");

        Image arena = new Image("sample/resources/hexagon.png");
        Image testGlad = new Image( "sample/resources/testGlad.png");

        ImageView viewArena = new ImageView(arena);
        viewArena.setFitHeight(450);
        viewArena.setPreserveRatio(true);

//----------------------------------------------------------------------------------------------------------------------

       /* //Visualize all the buttons
        Group root = new Group(
                viewArena, buttonLeft,buttonRight,buttonDir,
                buttonAttackLeft,buttonDefendLeft,buttonNothingLeft,
                buttonRotate,buttonMove,buttonNothingMove,
                buttonAttackRight,buttonDefendRight,buttonNothingRight,
                buttonRotateNW, buttonRotateSE, buttonRotateNE, buttonRotateSW,
                buttonNE, buttonE, buttonSE, buttonSW, buttonW, buttonNW);



        //Creating the GUI with the Root (All the buttons & pictues), & scaling the GUI window.
        Scene theScene = new Scene(root,650,700);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas( 650, 500);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Putting in the gladiator
        gc.drawImage(testGlad, 330,325);

        primaryStage.show();

        */



    }



}
