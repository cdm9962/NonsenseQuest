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
 * Class to display the inventory UI on the scene.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class InventoryScene {
    // The private state of the inventory scene
    private Scene currStage;
    private GameModel model;
    private Stage primaryStage;

    // Constant String values
    public static final String INVENTORY_DISPLAY_TITLE = "Character Inventory:";

    /**
     * InventoryScene constructor.
     * @param currStage The scene to return to after finished with inventory
     * @param model GameModel representing the attributes of the game
     * @param primaryStage Stage of the current game
     */
    public InventoryScene(Scene currStage, GameModel model, Stage primaryStage) {
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

        // Sets the scene title
        Label title = new Label(INVENTORY_DISPLAY_TITLE);
        title.setFont(GameInterface.PIXEL_FONT_MEDIUM);
        border.setTop(title);

        // Sets the return to stage map button
        GridPane buttonGrid = new GridPane();
        Button homeButton = new Button("Return");
        homeButton.setOnAction(event -> {
            primaryStage.setScene(currStage);
        });
        buttonGrid.add(homeButton, 0, 0);
        border.setRight(buttonGrid);

        // Creates the active item grid
        GridPane itemPane = new GridPane();
        itemPane.setPadding(new Insets(5.0));
        itemPane.setHgap(2.0);
        itemPane.setVgap(2.0);
        border.setLeft(itemPane);

        // Adds items to the inventory display
        ArrayList<Item> items = model.getPlayer().getInventory();
        for(int itemIndex = 0; itemIndex < items.size(); itemIndex++) {
            Button itemSlot = new Button();
            itemSlot.setMinSize(GameInterface.DEFAULT_INSETS, GameInterface.DEFAULT_INSETS);
            Background squareTexture = new Background(new BackgroundImage(new javafx.scene.image.Image(getClass().getResource(model.getPlayer().getInventory().get(itemIndex).getImageFilename()).toExternalForm()),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
            itemSlot.setBackground(squareTexture);
            itemPane.add(itemSlot, itemIndex, 0);

            int finalItemIndex = itemIndex;
            itemSlot.setOnAction(event -> {
                Label itemStats = new Label(items.get(finalItemIndex).printItemStats());
                border.setCenter(itemStats);
            });
        }

        // Displays the scene
        Scene inventory = new Scene(border);
        this.primaryStage.setScene(inventory);

    }
}