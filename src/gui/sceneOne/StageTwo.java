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
    private GameModel model;

    private Stage primaryStage;

    public static final String STAGE_TWO_TITLE = "Stage one: Select a stage.";

    public StageTwo(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();

    }
}
