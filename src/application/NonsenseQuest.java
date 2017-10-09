package application;

import gui.GameInterface;
import javafx.application.Application;

/**
 * The launcher for NonsenseQuest.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class NonsenseQuest {
    /**
     * Main application method. Launches the game interface.
     * @param args should be no command line arguments
     */
    public static void main(String[] args) {
        Application.launch(GameInterface.class);
    }
}
