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
 * @author Connor D. Milligan
 */
public class StageOne {
    private GameModel model;

    private Stage primaryStage;

    public static final String STAGE_ONE_TITLE = "Stage One";
    public static final String STAGE_ONE_FILENAME = "/resources/stagemaps/stageone.txt";

    public StageOne(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(50.0));

        this.model.setStageMap(STAGE_ONE_FILENAME);
        this.model.getStageMap();

        MapBuilder map = new MapBuilder(this.model, this.primaryStage);
        BorderPane mapGrid = map.buildMap();
        border.setCenter(mapGrid);

        Label playerStats = new Label(this.model.printCharacterStats());
        playerStats.setFont(GameInterface.PIXEL_FONT_SMALL);
        border.setRight(playerStats);

        Scene stageOne = new Scene(border);
        this.primaryStage.setScene(stageOne);

    }
}
