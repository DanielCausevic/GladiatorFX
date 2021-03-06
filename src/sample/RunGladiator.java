package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Arena.Point;
import sample.Controller.GameController;
import sample.Controller.GuiTest;
import sample.Model.Action.Attack;
import sample.Model.Dummy.Dummy;
import sample.Model.Gladiator.Gladiator;
import sample.Model.Gladiator.Weapon;
import sample.Model.Gladiator.Weapons;

import java.io.File;


public class RunGladiator extends Application {

    //Bruger ikke denne metode.
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        File img = new File("sample/resources/hexagon.gif");
        Image image = new Image(String.valueOf(img));

        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(25);

        imageView.setFitHeight(455);
        imageView.setFitWidth(500);

        imageView.setPreserveRatio(true);

        Group root = new Group(imageView);

        primaryStage.setTitle("Arena");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        Canvas canvas = new Canvas(500, 500);
        //Image restart = new Image("restart.png");

        root.getChildren().add(canvas);
    }

    //Først movement
    //Kalder vores ArenaController start metode.
    public static void main(String[] args) {
        Application.launch(GameController.class, args);
    }
}




