package application;

import gui.GameInterface;
import javafx.application.Application;

/**
 * The launcher for NonsenseQuest.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class NonsenseQuest {
    public static void main(String[] args) {
        GameInterface game = new GameInterface();
        Application.launch(GameInterface.class);
    }
}
