package sample.GuiController;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class ArenaController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle( "Arena" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        primaryStage.setScene( theScene );

        Canvas canvas = new Canvas( 650, 650 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image arena = new Image( "sample/resources/hexagon.gif");
        Image testGlad   = new Image( "sample/resources/testGlad.png");

        gc.drawImage(arena, 100, 100);
        gc.drawImage(testGlad, 330,325);

        primaryStage.show();

    }
}
