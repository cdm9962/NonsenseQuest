package gui;

import gui.sceneOne.SceneOne;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;
import model.classes.Thief;
import model.classes.Warrior;
import model.races.Dragon;
import model.races.Human;

import java.awt.*;

import static gui.GameInterface.PIXEL_FONT_SMALL;

/**
 * Utility class for the opening scene.  Gathers user information for character creation.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class OpeningScene {
    // Private state necessary for the scene
    private GameModel model;
    private Stage primaryStage;

    // User gathered information
    private String name;
    private String race;
    private String playerClass;

    // Constant String values
    private static final String OPENING_LABEL = "Welcome to the world of Nonsense Quest!\n" +
                                                "To begin your adventure:";
    private static final String NAME_LABEL = "Enter a Character Name: ";


    /**
     * Constructor for the opening scene.
     * @param model GameModel of the current game
     * @param primaryStage Stage of the current game
     */
    public OpeningScene(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    /**
     * Method to start the opening scene. Gathers user's name choice.
     */
    public void startScene(){
        // Creates the border pane for the scene
        BorderPane border = new BorderPane();
        border.setStyle(GameInterface.COLOR_GRAY);
        border.setPadding(new Insets(GameInterface.DEFAULT_INSETS));

        // Creates the label for the top of the border pane
        Label description = new Label(OPENING_LABEL);
        description.setAlignment(Pos.CENTER);
        description.setFont(GameInterface.PIXEL_FONT_MEDIUM);
        description.setPadding(new Insets(GameInterface.DEFAULT_INSETS));
        border.setTop(description);

        // Creates the text box to gather the users name
        GridPane characterName = new GridPane();
        Label title = new Label(NAME_LABEL);
        title.setFont(GameInterface.PIXEL_FONT_SMALL);
        characterName.add(title, 0, 0);
        TextField input = new TextField();
        characterName.add(input, 1, 0);
        border.setCenter(characterName);

        // Gathers the user input
        input.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                this.name = input.getCharacters().toString();
                pickRace(border);
            }
        });

        // Updates the scene
        Scene opening = new Scene(border);
        this.primaryStage.setScene(opening);
    }

    /**
     * Method to gather user's race choice.
     * @param border BorderPane to update
     */
    private void pickRace(BorderPane border){
        // Creates the race selection grid pane
        GridPane characterRace = new GridPane();
        characterRace.setVgap(GameInterface.BUTTON_INSETS);
        characterRace.setHgap(GameInterface.BUTTON_INSETS);

        // Adds the label to the race selection
        Label title = new Label("Select a Race: ");
        title.setFont(GameInterface.PIXEL_FONT_SMALL);
        characterRace.add(title, 0, 0);


        // Adds the human race option to the grid pane
        Button humanButton = new Button(Human.HUMAN_RACE);
        characterRace.add(humanButton, 1, 0);
        humanButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        humanButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        // Sets player race to human
        humanButton.setOnAction(event -> {
            this.race = Human.HUMAN_RACE;
            pickClass(border);
        });

        // Adds the dragon race option to the grid pane
        Button dragonButton = new Button(Dragon.DRAGON_RACE);
        characterRace.add(dragonButton, 2, 0);
        dragonButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        dragonButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        // Sets player race to dragon
        dragonButton.setOnAction(event -> {
            this.race = Dragon.DRAGON_RACE;
            pickClass(border);
        });

        border.setCenter(characterRace);
    }

    /**
     * Method to gather user's class choice.
     * @param border BorderPane to update
     */
    private void pickClass(BorderPane border){
        // Creates the class selection grid pane
        GridPane characterClass = new GridPane();
        characterClass.setHgap(GameInterface.BUTTON_INSETS);
        characterClass.setVgap(GameInterface.BUTTON_INSETS);

        // Adds the label to the class selction
        Label title = new Label("Select a Class: ");
        title.setFont(GameInterface.PIXEL_FONT_SMALL);
        characterClass.add(title, 0, 0);

        // Adds the warrior class option to the grid pane
        Button warriorButton = new Button(Warrior.WARRIOR_PLAYER_CLASS);
        characterClass.add(warriorButton, 1, 0);
        warriorButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        warriorButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        // Sets player class to warrior and updates the rest of the model
        warriorButton.setOnAction(event -> {
            this.playerClass = Warrior.WARRIOR_PLAYER_CLASS;
            GameModel modelUpdate = new GameModel(this.name, this.race, this.playerClass);
            this.model = modelUpdate;
            displayCharacter(border);
        });

        // Adds the thief class option to the grid pane
        Button thiefButton = new Button(Thief.THIEF_PLAYER_CLASS);
        characterClass.add(thiefButton, 2, 0);
        thiefButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        thiefButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        // Sets player class to thief and updates the rest of the model
        thiefButton.setOnAction(event -> {
            this.playerClass = Thief.THIEF_PLAYER_CLASS;
            GameModel modelUpdate = new GameModel(this.name, this.race, this.playerClass);
            this.model = modelUpdate;
            displayCharacter(border);
        });

        border.setCenter(characterClass);
    }

    /**
     * Method to display the character stats on the scene.
     * @param border Border Pane to update
     */
    public void displayCharacter(BorderPane border){
        // Creates the top label for the border pane
        Label title = new Label("Your Character Stats: ");
        title.setFont(GameInterface.PIXEL_FONT_MEDIUM);
        title.setPadding(new Insets(GameInterface.DEFAULT_INSETS));
        border.setTop(title);

        // Prints the character stats to the left of the border pane and clears the center border pane
        CharacterDisplay characterDisplay = new CharacterDisplay(model);
        border.setLeft(characterDisplay.displayStats(model.getPlayer()));

        // Removes text from the previous scene
        Label placeholder = new Label("");
        border.setCenter(placeholder);

        // Creates the acceptance buttons gid
        GridPane acceptGrid = new GridPane();
        acceptGrid.setVgap(GameInterface.BUTTON_INSETS);
        acceptGrid.setHgap(GameInterface.BUTTON_INSETS);

        // Creates the label for the character acceptance buttons
        Label acceptTitle = new Label("Is this okay? ");
        acceptTitle.setFont(GameInterface.PIXEL_FONT_SMALL);
        acceptGrid.add(acceptTitle, 0, 0);

        // Adds confirm button to the accept grid pane
        Button yesButton = new Button("Yes");
        acceptGrid.add(yesButton, 1, 0);
        yesButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        yesButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        yesButton.setOnAction(event1 -> {
            SceneOne nextScene = new SceneOne(this.model, this.primaryStage);
            nextScene.startScene();
        });

        // Adds deny button to the accept grid pane
        Button noButton = new Button("No");
        noButton.setFont(GameInterface.PIXEL_FONT_SMALL);
        noButton.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource(GameInterface.WOOD_BUTTON_FILE).toExternalForm()),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        acceptGrid.add(noButton, 2, 0);
        noButton.setOnAction(event -> {
            OpeningScene redo = new OpeningScene(this.model, this.primaryStage);
            redo.startScene();
        });

        border.setRight(acceptGrid);
    }
}