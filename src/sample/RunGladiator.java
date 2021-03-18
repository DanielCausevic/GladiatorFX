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
    public static void main(String[] args) { Application.launch(GameController.class, args); }

    public void dummyAttacking(){
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

        }
    }
}




