package gui.sceneOne;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameModel;

/**
 * @author Connor D. Milligan
 */
public class StageOne {
    private GameModel model;

    private Stage primaryStage;

    public static final String STAGE_ONE_TITLE = "Stage one: Select a stage.";

    public StageOne(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();

    }
}
