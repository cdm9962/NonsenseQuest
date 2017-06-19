package gui;

import gui.sceneOne.StageOne;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.GameModel;
import model.Player;
import model.abilities.*;

/**
 * Utility class for managing all combat scenes.
 *
 * Created by Connor on 3/24/2017.
 */
public class CombatScene {
    // Private state necessary for the scene
    private Scene currStage;
    private GameModel model;
    private Stage primaryStage;
    private Player player;
    private Player enemy;
    private int enemyRow;
    private int enemyCol;

    // Constant string values
    public static final String COMBAT_SCENE_TITLE = "FIGHT!!!";
    public static final String HOME_BUTTON = "Return";

    /**
     * CombatScene constructor.
     * @param currStage The scene to return to after the fight
     * @param model GameModel representing the attributes of the game
     * @param primaryStage Stage of the current game
     * @param enemy Player that the character is meant to fight
     */
    public CombatScene(Scene currStage, GameModel model, Stage primaryStage, Player enemy, int enemyRow, int enemyCol){
        this.currStage = currStage;
        this.model = model;
        this.primaryStage = primaryStage;
        this.player = model.getPlayer();
        this.enemy = enemy;
        this.enemyRow = enemyRow;
        this.enemyCol = enemyCol;
    }

    /**
     * Method to start the scene and update the stage and game data.
     */
    public void startScene() {
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(GameInterface.DEFAULT_INSETS));

        // Sets the scene title
        Label title = new Label(COMBAT_SCENE_TITLE);
        border.setTop(title);

        // Creates the player action buttons
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(GameInterface.BUTTON_INSETS);
        buttonGrid.setVgap(GameInterface.BUTTON_INSETS);
        border.setCenter(buttonGrid);

        // Sets the return to stage map button
        Button homeButton = new Button(HOME_BUTTON);
        buttonGrid.add(homeButton, 0, 0);
        homeButton.setMinSize(200, 30);
        homeButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        homeButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        homeButton.setOnAction(event -> {
            primaryStage.setScene(currStage);
        });

        // Sets the quick attack button
        Button quickAttackButton = new Button(QuickAttack.QUICK_ATTACK_NAME);
        buttonGrid.add(quickAttackButton,0 , 1);
        quickAttackButton.setMinSize(200, 30);
        quickAttackButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        quickAttackButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        quickAttackButton.setOnAction(event -> {
            activateBasicAbility(border, new QuickAttack(player, enemy));
        });

        // Sets the medium attack button
        Button mediumAttackButton = new Button(MediumAttack.MEDIUM_ATTACK_NAME);
        buttonGrid.add(mediumAttackButton,0 , 2);
        mediumAttackButton.setMinSize(200, 30);
        mediumAttackButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        mediumAttackButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        mediumAttackButton.setOnAction(event -> {
            activateBasicAbility(border, new MediumAttack(player, enemy));
        });

        // Sets the heavy attack button
        Button heavyAttackButton = new Button(HeavyAttack.HEAVY_ATTACK_NAME);
        buttonGrid.add(heavyAttackButton,0 , 3);
        model.getButtonHelper().setNormalButton(heavyAttackButton);
        heavyAttackButton.setOnAction(event -> {
            activateBasicAbility(border, new HeavyAttack(player, enemy));
        });

        CharacterDisplay characterDisplay = new CharacterDisplay(model);
        border.setRight(characterDisplay.displayStats(player));

        CharacterDisplay enemyDisplay = new CharacterDisplay(model);
        border.setLeft(enemyDisplay.displayStats(enemy));

        Scene combatScene = new Scene(border);
        this.primaryStage.setScene(combatScene);
    }

    /**
     * Method to activate a basic damage ability after the user has selected it.
     * @param border BorderPane representing the current scene
     * @param ability Ability representing the ability to execute
     */
    public void activateBasicAbility(BorderPane border, Ability ability) {
        // Faster Player attacks first
        if(player.isFaster(enemy)){
            player.resolveAbility(ability);
        } else {
            enemy.resolveAbility(ability);
        }

        // Checks for death after first attack
        checkDeath(border);

        // Slower player attacks second
        if(player.isFaster(enemy)){
            enemy.resolveAbility(ability);
        } else {
            player.resolveAbility(ability);
        }

        // Checks for death after second attack
        checkDeath(border);
    }

    /**
     * Method to check if one of the players has died.
     * @param border BorderPane representing the current scene
     */
    public void checkDeath(BorderPane border) {
        // Updates character display for both players
        CharacterDisplay characterDisplay = new CharacterDisplay(model);
        border.setRight(characterDisplay.displayStats(player));
        CharacterDisplay enemyDisplay = new CharacterDisplay(model);
        border.setLeft(enemyDisplay.displayStats(enemy));

        // Checks if the enemy has died
        if(enemy.isDead()){
            System.out.println("\n" + enemy.getName() + " is dead!\n");
            primaryStage.setScene(currStage);
            model.getStageMap().getLocation(enemyRow, enemyCol).toggleIsEnemy();
            model.getStageMap().getLocation(enemyRow, enemyCol).setEnemy(null);

        }

        // Checks if the player has died
        if(player.isDead()) {
            System.out.println("\nYou are dead!\n");
            primaryStage.setScene(currStage);
        }
    }
}
