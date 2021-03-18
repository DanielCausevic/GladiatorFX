package sample.Controller;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.Arena.Arena;
import sample.Arena.Hex;
import sample.Arena.Point;
import sample.Model.Gladiator.Gladiator;
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

        // Scene with root group = primary place to hold objects on.
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Canvas = Primary place in root group to paint on.
        Canvas canvas = new Canvas(600, 800);

        root.getChildren().add(canvas);

        // GraphicsContext = Engine to draw images and text
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Arena graphics and position
        Arena arena = new Arena(8, 50, 100);

        // Gladiator graphics and position
        Image northOrient = new Image("sample/resources/glad_n.gif");
        Image eastOrient = new Image("sample/resources/glad_e.gif");
        Image southOrient = new Image("sample/resources/glad_s.gif");
        Image westOrient = new Image("sample/resources/glad_w.gif");
        Gladiator gladiator = new Gladiator(northOrient, westOrient, southOrient, eastOrient, 30, 48, new Point(0, 0));

        Hex gladHex = arena.getArena()[0][0]; // Top left most hex
        gladiator.setX(gladHex.getX());
        gladiator.setY(gladHex.getY());

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
                gc.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
                gc.fillText("HP: " + String.valueOf(gladiator.getHP()), 10, 20);
                gc.fillText("Condition: " + String.valueOf(gladiator.getConditioning()), 10, 40);
            }
        }.start();

        // Example of gladiator re-orientation and rendering
        int movement = 2;
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                double currentX = gladiator.getX();
                double currentY = gladiator.getY();

                if (keyEvent.getCode().toString().equals("LEFT")) {
                    gladiator.setX(currentX - movement);
                    gladiator.setOrientation("W");
                }
                if (keyEvent.getCode().toString().equals("RIGHT")) {
                    gladiator.setX(currentX + movement);
                    gladiator.setOrientation("E");

                }
                if (keyEvent.getCode().toString().equals("UP")) {
                    gladiator.setY(currentY - movement );
                    gladiator.setOrientation("N");
                }
                if (keyEvent.getCode().toString().equals("DOWN")) {
                    gladiator.setY(currentY + movement );
                    gladiator.setOrientation("S");
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

    public void move(int direction){
        HashMap<String, Point> possibleMoves = arena.getAdjacent(gladiator.getPosition());
        switch(direction) {
            // northEast
            case 1:
                if(possibleMoves.get("northEast") != null)
                    gladiator.setPositionPoint(possibleMoves.get("northEast"));
                break;

           // east
            case 2:
                if(possibleMoves.get("east") != null)
                    gladiator.setPositionPoint(possibleMoves.get("east"));
                break;

            // southEast
            case 3:
                if(possibleMoves.get("southEast") != null)
                    gladiator.setPositionPoint(possibleMoves.get("southEast"));
                break;
            // southWest
            case 4:
                if(possibleMoves.get("southWest") != null)
                    gladiator.setPositionPoint(possibleMoves.get("southWest"));
                break;

            // west
            case 5:
                if(possibleMoves.get("west") != null)
                    gladiator.setPositionPoint(possibleMoves.get("west"));
                break;

            // northWest
            case 6:
                if(possibleMoves.get("northWest") != null)
                    gladiator.setPositionPoint(possibleMoves.get("northWest"));
                break;

            default:
                System.err.println("Not a valid move");


        }
    }


}
