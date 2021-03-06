package gui.sceneOne;

import gui.CharacterDisplay;
import gui.GameInterface;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.GameModel;

/**
 * Class for the first scene in the game progression.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class SceneOne {
    // Private state necessary for the scene
    private GameModel model;
    private Stage primaryStage;

    // Constant string values
    public static final String SCENE_ONE_TITLE = "Scene one: Select a stage.";

    /**
     * SceneOne constructor.
     * @param model GameModel representing the attributes of the game
     * @param primaryStage Stage of the current game
     */
    public SceneOne(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    /**
     * Method to start the scene and update the stage and game data.
     */
    public void startScene(){
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();
        border.setStyle(GameInterface.COLOR_GRAY);
        border.setPadding(new Insets(GameInterface.DEFAULT_INSETS));

        // Sets the scene title
        Label title = new Label(SCENE_ONE_TITLE);
        title.setFont(GameInterface.PIXEL_FONT_MEDIUM);
        title.setPadding(new Insets(GameInterface.DEFAULT_INSETS));
        border.setTop(title);

        // Creates the stage buttons
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(GameInterface.BUTTON_INSETS);
        buttonGrid.setVgap(GameInterface.BUTTON_INSETS);
        border.setCenter(buttonGrid);

        // Creates the stage one selection
        Button stageOneButton = new Button(StageOne.STAGE_ONE_TITLE);
        model.getButtonHelper().setNormalButton(stageOneButton);

        // Launches first stage
        stageOneButton.setOnAction(event -> {
            StageOne stageOne = new StageOne(this.model, this.primaryStage);
            stageOne.startScene();
        });
        buttonGrid.add(stageOneButton, 0, 0);

        // Creates the stage two selection
        Button stageTwoButton = new Button(StageTwo.STAGE_TWO_TITLE);
        model.getButtonHelper().setNormalButton(stageTwoButton);
        stageTwoButton.setDisable(true);

        // Launches second stage
        stageTwoButton.setOnAction(event -> {
            StageTwo stageTwo = new StageTwo(this.model, this.primaryStage);
            stageTwo.startScene();
        });
        buttonGrid.add(stageTwoButton, 1, 0);

        // Displays the character stats on the right side of the play screen
        CharacterDisplay characterDisplay = new CharacterDisplay(model);
        border.setRight(characterDisplay.displayStats(model.getPlayer()));

        // Updates the scene
        Scene sceneOne = new Scene(border);
        this.primaryStage.setScene(sceneOne);
    }
}