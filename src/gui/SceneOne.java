package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.GameModel;

/**
 * @author Connor D. Milligan, Nathan Hall
 */
public class SceneOne {
    private GameModel model;

    private Stage primaryStage;

    public static final String STAGE_ONE_TITLE = "Scene one: Select a stage.";

    public SceneOne(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    public void startScene(){
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(50.0));

        Label title = new Label(STAGE_ONE_TITLE);
        border.setTop(title);

        GridPane buttonGrid = new GridPane();

        Button stageOneButton = new Button("Stage One");
        stageOneButton.setOnAction(event -> {
            StageOne stageOne = new StageOne(this.model, this.primaryStage);
            stageOne.startScene();
        });
        buttonGrid.add(stageOneButton, 0, 0);

        Button stageTwoButton = new Button("Stage Two");
        stageTwoButton.setDisable(true);
        stageTwoButton.setOnAction(event -> {
            StageTwo stageTwo = new StageTwo(this.model, this.primaryStage);
            stageTwo.startScene();
        });
        buttonGrid.add(stageTwoButton, 1, 0);

        border.setCenter(buttonGrid);

        Label playerStats = new Label(this.model.printCharacterStats());
        border.setRight(playerStats);

        // Updates the scene
        Scene sceneOne = new Scene(border);
        this.primaryStage.setScene(sceneOne);
    }
}
