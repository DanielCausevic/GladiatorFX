package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class RunGladiator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
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

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }
//test
//nytest
    public static void main(String[] args) {
        launch(args);
    }
}
