package gui;

import gui.sceneOne.StageOne;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GameModel;

/**
 * Created by Connor on 3/24/2017.
 */
public class CombatScene {
    // Private state necessary for the scene
    private Scene currStage;
    private GameModel model;
    private Stage primaryStage;

    // Constant string values
    public static final String COMBAT_SCENE_TITLE = "FIGHT!!!";

    /**
     * CombatScene constructor.
     * @param model GameModel representing the attributes of the game
     * @param primaryStage Stage of the current game
     */
    public CombatScene(Scene currStage, GameModel model, Stage primaryStage){
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
        border.setPadding(new Insets(50.0));

        Label title = new Label(COMBAT_SCENE_TITLE);
        border.setTop(title);

        Button homeButton = new Button("Return");
        homeButton.setOnAction(event -> {
            primaryStage.setScene(currStage);
        });
        border.setCenter(homeButton);

        Scene combatScene = new Scene(border);
        this.primaryStage.setScene(combatScene);
    }
}
