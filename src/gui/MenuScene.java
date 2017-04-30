package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.GameModel;
import model.items.Item;

import java.util.ArrayList;

/**
 * Class to display the main menu UI on the scene.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class MenuScene {
    // The private state of the main menu
    private Scene currStage;
    private GameModel model;
    private Stage primaryStage;

    // Constant String values
    public static final String INVENTORY_DISPLAY_TITLE = "Main Menu:";

    /**
     * MenuScene constructor.
     * @param currStage The scene to return to after finished with main menu
     * @param model GameModel representing the attributes of the game
     * @param primaryStage Stage of the current game
     */
    public MenuScene(Scene currStage, GameModel model, Stage primaryStage) {
        this.currStage = currStage;
        this.model = model;
        this.primaryStage = primaryStage;
    }

    /**
     * Method to start the scene and update the stage and game data.
     */
    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();
        border.setStyle(GameInterface.COLOR_GRAY);

        // Displays the scene
        Scene inventory = new Scene(border);
        this.primaryStage.setScene(inventory);
    }
}
