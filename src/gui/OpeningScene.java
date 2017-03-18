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
import model.GameModel;

/**
 * Utility class for the opening scene
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class OpeningScene {
    private GameModel model;
    private Stage primaryStage;
    private String name;
    private String race;
    private String playerClass;

    public OpeningScene(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    public void startScene(){
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(50.0));

        Label description = new Label("Welcome to the world of Nonsense Quest!\n" +
                                      "To begin your adventure:");
        description.setAlignment(Pos.CENTER);
        border.setTop(description);

        GridPane characterName = new GridPane();
        Label title = new Label("Enter a Character Name: ");
        characterName.add(title, 0, 0);
        TextField input = new TextField();
        characterName.add(input, 1, 0);
        border.setCenter(characterName);
        input.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                this.name = input.getCharacters().toString();
                pickRace(border);
            }
        });


        Scene opening = new Scene(border);
        this.primaryStage.setScene(opening);
        this.primaryStage.setResizable(true);
        this.primaryStage.show();
    }

    private void pickRace(BorderPane border){
        GridPane characterRace = new GridPane();
        Label title = new Label("Select a Race: ");
        Button humanButton = new Button("Human");
        characterRace.add(title, 0, 0);
        characterRace.add(humanButton, 1, 0);
        border.setCenter(characterRace);

        humanButton.setOnAction(event -> {
            this.race = "Human";
            pickClass(border);
        });
    }

    private void pickClass(BorderPane border){
        GridPane characterClass = new GridPane();
        Label title = new Label("Select a Class: ");
        Button warriorButton = new Button("Warrior");
        characterClass.add(title, 0, 0);
        characterClass.add(warriorButton, 1, 0);
        border.setCenter(characterClass);

        warriorButton.setOnAction(event -> {
            this.playerClass = "Warrior";
            GameModel modelUpdate = new GameModel(this.name, this.race, this.playerClass);
            this.model = modelUpdate;
            displayCharacter(border);
        });
    }

    public void displayCharacter(BorderPane border){
        Label title = new Label("Your Character Stats: ");
        border.setTop(title);

        Label characterStats = new Label(model.printCharacterStats());
        border.setCenter(characterStats);

        GridPane acceptGrid = new GridPane();
        Label acceptTitle = new Label("Is this okay? ");
        acceptGrid.add(acceptTitle, 0, 0);

        Button yesButton = new Button("Yes");
        acceptGrid.add(yesButton, 1, 0);

        Button noButton = new Button("No");
        acceptGrid.add(noButton, 2, 0);

        border.setRight(acceptGrid);
    }
}
