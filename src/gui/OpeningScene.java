package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.*;

/**
 * Utility class for the opening scene.  Gathers user information for character creation.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class OpeningScene {
    // Private state for nessisary for the scene
    private GameModel model;
    private Stage primaryStage;

    // User gathered information
    private String name;
    private String race;
    private String playerClass;

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
        border.setPadding(new Insets(50.0));

        // Creates the label for the top of the border pane
        Label description = new Label("Welcome to the world of Nonsense Quest!\n" +
                                      "To begin your adventure:");
        description.setAlignment(Pos.CENTER);
        description.setFont(GameInterface.PIXEL_FONT_MEDIUM);
        description.setPadding(new Insets(50.0));
        border.setTop(description);

        // Creates the text box to gather the users name
        GridPane characterName = new GridPane();
        Label title = new Label("Enter a Character Name: ");
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

        // Adds the label to the race selection
        Label title = new Label("Select a Race: ");
        characterRace.add(title, 0, 0);

        // Adds the human race option to the grid pane
        Button humanButton = new Button(Human.HUMAN_RACE);
        characterRace.add(humanButton, 1, 0);

        // Sets player race to human
        humanButton.setOnAction(event -> {
            this.race = Human.HUMAN_RACE;
            pickClass(border);
        });

        // Adds the dragon race option to the grid pane
        Button dragonButton = new Button(Dragon.DRAGON_RACE);
        characterRace.add(dragonButton, 2, 0);

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

        // Adds the label to the class selction
        Label title = new Label("Select a Class: ");
        characterClass.add(title, 0, 0);

        // Adds the warrior class option to the grid pane
        Button warriorButton = new Button(Warrior.WARRIOR_PLAYER_CLASS);
        characterClass.add(warriorButton, 1, 0);

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
        title.setPadding(new Insets(50.0));
        border.setTop(title);

        // Prints the character stats to the left of the border pane and clears the center border pane
        Label characterStats = new Label(model.printCharacterStats());
        border.setLeft(characterStats);
        Label placeholder = new Label("");
        border.setCenter(placeholder);

        // Creates the label for the character acceptance buttons
        GridPane acceptGrid = new GridPane();
        Label acceptTitle = new Label("Is this okay? ");
        acceptGrid.add(acceptTitle, 0, 0);

        // Adds confirm button to the accept grid pane
        Button yesButton = new Button("Yes");
        acceptGrid.add(yesButton, 1, 0);

        // Adds deny button to the accept grid pane
        Button noButton = new Button("No");
        acceptGrid.add(noButton, 2, 0);
        noButton.setOnAction(event -> {
            OpeningScene redo = new OpeningScene(this.model, this.primaryStage);
            redo.startScene();
        });

        border.setRight(acceptGrid);
    }
}
