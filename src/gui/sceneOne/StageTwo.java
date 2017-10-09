package gui.sceneOne;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameModel;

/**
 * Class for the second stage in the scene progression.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class StageTwo {
    // The private state of the second stage
    private GameModel model;
    private Stage primaryStage;

    // Constant String values
    public static final String STAGE_TWO_TITLE = "Stage Two";

    /**
     * StageTwo constructor.
     * @param model GameModel representing the attributes of the game
     * @param primaryStage Stage of the current game
     */
    public StageTwo(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    /**
     * Method to start the scene and update the stage and game data.
     */
    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();

    }
}