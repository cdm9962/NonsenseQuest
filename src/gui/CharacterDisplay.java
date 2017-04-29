package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import model.GameModel;

/**
 * Class to display the character information on the game UI.
 *
 * @author Connor D. Milligan
 */
public class CharacterDisplay {
    // The private state of the character display
    private GameModel model;
    private BorderPane characterPane;

    /**
     * CharacterDisplay constructor.
     * @param model GameModel representing the stored game data.
     */
    public CharacterDisplay(GameModel model){
        this.model = model;
        this.characterPane = new BorderPane();

    }

    /**
     * Method to display the character stats on the game UI.
     * @return BorderPane representing the character stats display
     */
    public BorderPane displayStats() {
        // Gets the character stats text from the model
        Label playerStats = new Label(model.printCharacterStats());
        playerStats.setFont(GameInterface.PIXEL_FONT_SMALL);
        characterPane.setTop(playerStats);

        // Creates the active item grid
        GridPane itemPane = new GridPane();
        itemPane.setPadding(new Insets(5.0));
        characterPane.setCenter(itemPane);

        // Adds the first item to the active item display
        Button itemSlot1 = new Button();
        itemSlot1.setMinSize(GameInterface.DEFAULT_INSETS, GameInterface.DEFAULT_INSETS);
        Background squareTexture1 = new Background(new BackgroundImage(new javafx.scene.image.Image(getClass().getResource(model.getPlayer().getActiveItemLeft().getImageFilename()).toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        itemSlot1.setBackground(squareTexture1);
        itemSlot1.setDisable(true);
        itemSlot1.setOpacity(1.0);
        itemPane.add(itemSlot1, 0, 0);

        // Adds the second item to the active item display
        Button itemSlot2 = new Button();
        itemSlot2.setMinSize(GameInterface.DEFAULT_INSETS, GameInterface.DEFAULT_INSETS);
        Background squareTexture2 = new Background(new BackgroundImage(new javafx.scene.image.Image(getClass().getResource(model.getPlayer().getActiveItemRight().getImageFilename()).toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        itemSlot2.setBackground(squareTexture2);
        itemSlot2.setDisable(true);
        itemSlot2.setOpacity(1.0);
        itemPane.add(itemSlot2, 1, 0);

        return characterPane;
    }

    /**
     * Method to update the character stats on the game UI.
     * @return BorderPane representing the character stats display
     */
    public BorderPane updateStats() {
        // Gets the character stats text from the model
        Label playerStats = new Label(model.printCharacterStats());
        playerStats.setFont(GameInterface.PIXEL_FONT_SMALL);
        characterPane.setTop(playerStats);

        return characterPane;
    }
}
