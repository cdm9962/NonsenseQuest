package gui.sceneOne;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.GameModel;
import model.StageMap;

/**
 * @author Connor D. Milligan
 */
public class StageOne {
    private GameModel model;

    private Stage primaryStage;

    public static final String STAGE_ONE_TITLE = "Stage One";
    public static final String STAGE_ONE_FILENAME = "stageone.txt";

    public StageOne(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();

        this.model.setStageMap(STAGE_ONE_FILENAME);
        this.model.getStageMap();

        GridPane mapGrid = new GridPane();
        for(int row = 0; row < this.model.getStageMap().getRows(); row++){
            for(int col = 0; col < this.model.getStageMap().getCols(); col++){
                if(this.model.getStageMap().getLocation(row, col) == StageMap.MAP_EMPTY){
                    Button button = new Button();
                }
            }
        }

        Scene stageOne = new Scene(border);
        this.primaryStage.setScene(stageOne);

    }
}
