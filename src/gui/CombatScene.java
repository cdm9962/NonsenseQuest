package gui;

import gui.sceneOne.StageOne;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.GameModel;
import model.Player;

/**
 * Utility class for all combat scenes.
 *
 * Created by Connor on 3/24/2017.
 */
public class CombatScene {
    // Private state necessary for the scene
    private Scene currStage;
    private GameModel model;
    private Stage primaryStage;
    private Player enemy;

    // Constant string values
    public static final String COMBAT_SCENE_TITLE = "FIGHT!!!";

    /**
     * CombatScene constructor.
     * @param currStage The scene to return to after the fight
     * @param model GameModel representing the attributes of the game
     * @param primaryStage Stage of the current game
     * @param enemy Player that the character is meant to fight
     */
    public CombatScene(Scene currStage, GameModel model, Stage primaryStage, Player enemy){
        this.currStage = currStage;
        this.model = model;
        this.primaryStage = primaryStage;
        this.enemy = enemy;
    }

    /**
     * Method to start the scene and update the stage and game data.
     */
    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(50.0));

        // Sets the scene title
        Label title = new Label(COMBAT_SCENE_TITLE);
        border.setTop(title);

        // Sets the return to stage map button
        GridPane buttonGrid = new GridPane();
        Button homeButton = new Button("Return");
        homeButton.setOnAction(event -> {
            primaryStage.setScene(currStage);
        });
        buttonGrid.add(homeButton, 0, 0);

        // Sets the attack button
        Button attackButton = new Button("Attack!");
        attackButton.setOnAction(event -> {
            enemy.takeDamage(model.getPlayer().calculateDamage());
            Label playerStats = new Label(this.model.printCharacterStats());
            playerStats.setFont(GameInterface.PIXEL_FONT_SMALL);
            border.setRight(playerStats);
            Label enemyStats = new Label(enemy.displayCharacter());
            enemyStats.setFont(GameInterface.PIXEL_FONT_SMALL);
            border.setLeft(enemyStats);
            if(enemy.getHealth() == 0){
                primaryStage.setScene(currStage);
            }
        });
        buttonGrid.add(attackButton,0 , 1);

        border.setCenter(buttonGrid);

        Label playerStats = new Label(this.model.printCharacterStats());
        playerStats.setFont(GameInterface.PIXEL_FONT_SMALL);
        border.setRight(playerStats);

        Label enemyStats = new Label(enemy.displayCharacter());
        enemyStats.setFont(GameInterface.PIXEL_FONT_SMALL);
        border.setLeft(enemyStats);

        Scene combatScene = new Scene(border);
        this.primaryStage.setScene(combatScene);
    }
}
