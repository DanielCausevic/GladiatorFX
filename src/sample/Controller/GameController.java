package sample.Controller;

import sample.Model.Gladiator.Gladiator;

/**
 * @Author Rasmus, Nicolai
 * Klassen styrer main game loop mv.
 */

public class GameController {
    private boolean running;
    private Gladiator gladiator;

    // Constructor
    public GameController() {
    }

    // Instanciates objects needed to launch the main loop (run());
   /* public void init() {
        //Gladiator gladiator = new Gladiator();
        // GUIController guiController;
        run();
    }
    */

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
