package gui.sceneOne;

import gui.GameInterface;
import gui.MapBuilder;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameModel;

/**
 * Class for the first stage in the scene progression.
 *
 * @author Connor D. Milligan
 */
public class StageOne {
    // The private state of the first stage
    private GameModel model;
    private Stage primaryStage;

    // Constant String values
    public static final String STAGE_ONE_TITLE = "Stage One";
    public static final String STAGE_ONE_FILENAME = "/stageMaps/stagetwo.txt";

    /**
     * StageOne constructor.
     * @param model GameModel representing the attributes of the game
     * @param primaryStage Stage of the current game
     */
    public StageOne(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    /**
     * Method to start the scene and update the stage and game data.
     */
    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(GameInterface.DEFAULT_INSETS));

        // Reads the stage map from the text file
        this.model.setStageMap(STAGE_ONE_FILENAME);
        this.model.getStageMap();

        // Prints the character stats on the right side of the screen
        Label playerStats = new Label(this.model.printCharacterStats());
        playerStats.setFont(GameInterface.PIXEL_FONT_SMALL);
        BorderPane rightPane = new BorderPane();
        rightPane.setTop(playerStats);
        border.setRight(rightPane);

        // Builds the stage map in the model
        MapBuilder map = new MapBuilder(this.model, this.primaryStage);
        BorderPane mapGrid = map.buildMap(border);
        border.setCenter(mapGrid);

        // Displays the scene
        Scene stageOne = new Scene(border);
        this.primaryStage.setScene(stageOne);

    }
}