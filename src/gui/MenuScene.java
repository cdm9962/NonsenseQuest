package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

    // Constant values
    public static final String MAIN_MENU_DISPLAY_TITLE = "Main Menu:";
    public static final String HOME_BUTTON = "Return To Game";
    public static final String INVENTORY_BUTTON = "View Inventory";
    public static final double MENU_BUTTON_INSETS = 25.0;


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
        border.setPadding(new Insets(GameInterface.NO_INSETS, GameInterface.NO_INSETS, GameInterface.NO_INSETS, GameInterface.CENTER_INSETS - GameInterface.DEFAULT_INSETS));

        // Creates the scene title
        Label title = new Label(MAIN_MENU_DISPLAY_TITLE);
        title.setFont(GameInterface.PIXEL_FONT_LARGE);
        title.setPadding(new Insets(GameInterface.NO_INSETS, GameInterface.NO_INSETS, GameInterface.DEFAULT_INSETS, GameInterface.NO_INSETS));
        border.setTop(title);

        // Creates the button menu
        GridPane menuGrid = new GridPane();
        menuGrid.setVgap(MENU_BUTTON_INSETS);
        menuGrid.setHgap(GameInterface.BUTTON_INSETS);
        border.setCenter(menuGrid);

        // Creates the return to game button
        Button homeButton = new Button(HOME_BUTTON);
        model.getButtonHelper().setNormalButton(homeButton);

        // Returns to the previous scene
        homeButton.setOnAction(event -> {
            primaryStage.setScene(currStage);
        });
        menuGrid.add(homeButton, 0, 0);

        // Creates the display inventory button
        Button inventoryButton = new Button(INVENTORY_BUTTON);
        model.getButtonHelper().setNormalButton(inventoryButton);

        // Starts the inventory scene
        inventoryButton.setOnAction(event -> {
            InventoryScene inventoryScene = new InventoryScene(primaryStage.getScene(), model, primaryStage);
            inventoryScene.startScene();
        });
        menuGrid.add(inventoryButton, 0, 1);

        // Displays the scene
        Scene menu = new Scene(border);
        this.primaryStage.setScene(menu);
    }
}
