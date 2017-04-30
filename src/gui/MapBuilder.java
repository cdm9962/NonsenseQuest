package gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;
import model.map.*;

/**
 * Utility class for building the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class MapBuilder {
    // The private state necessary for the map builder
    private GameModel model;
    private Stage primaryStage;
    private BorderPane stagePane;
    private GridPane mapGrid;
    private Label squareDescription;

    /**
     * Constructor for the map builder.
     * @param model GameModel representing the game attributes
     */
    public MapBuilder(GameModel model, Stage primaryStage, BorderPane stagePane){
        this.model = model;
        this.primaryStage = primaryStage;
        this.stagePane = stagePane;
        this.mapGrid = new GridPane();
        this.squareDescription = new Label();
    }

    /**
     * Method to create a map grid based on the map data stored in the model.
     * @return BorderPane representing a visual representation of the stage map
     */
    public BorderPane buildMap(){
        // Creates the grid and square description
        BorderPane border = new BorderPane();
        mapGrid.setHgap(2);
        mapGrid.setVgap(2);
        border.setLeft(mapGrid);
        squareDescription.setPadding(new Insets(GameInterface.DEFAULT_INSETS));
        squareDescription.setMinSize(100, 100);
        ((BorderPane) stagePane.getRight()).setBottom(squareDescription);

        // Loops through each row and column in the grid
        for(int row = 0; row < model.getStageMap().getRows(); row++){
            for(int col = 0; col < model.getStageMap().getCols(); col++){
                Square currSquare = model.getStageMap().getLocation(row, col);
                createSquare(currSquare, row, col);

                // Locates the character square and marks adjacency
                if (currSquare.isContainsCharacter()){
                    currSquare.togleContainsCharacter();
                    model.getStageMap().setCharacterSquare(currSquare);
                // Marks all enemy squares
                } else if(currSquare.isContainsEnemy()){
                    currSquare.createEnemy();
                    setEnemySquare(mapGrid, col, row);
                }
            }
        }
        // Highlights the character and enemy squares
        setCharacterSquare(mapGrid, model.getStageMap().getCharacterSquare().getCol(), model.getStageMap().getCharacterSquare().getRow());
        markAdjacentSquares(mapGrid, model.getStageMap().getCharacterSquare().getRow(), model.getStageMap().getRows(),
                model.getStageMap().getCharacterSquare().getCol(), model.getStageMap().getCols());

        return border;
    }

    /**
     * Method to create a map square
     * @param currSquare Square representing the currently selected square on the stage map
     * @param row int representing the row location of the current square
     * @param col int representing the column location of the current square
     */
    public void createSquare(Square currSquare, int row, int col) {
        // Creates the button and textures
        Button squareButton = new Button();
        Background squareTexture = new Background(new BackgroundImage(new Image(getClass().getResource(currSquare.getImageFilename()).toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        squareButton.setBackground(squareTexture);
        squareButton.setMinSize(50.0, 50.0);
        mapGrid.add(squareButton, col, row);

        // Displays the square description when a square is clicked on
        squareButton.setOnAction(event -> {
            squareDescription.setText(currSquare.getDescription());
        });

        // Sets WASD movement tracking as well as other key listening
        squareButton.setOnKeyPressed((KeyEvent event) -> {
            // Launches game menu
            if(event.getCode() == KeyCode.ESCAPE) {
                MenuScene menuScene = new MenuScene(primaryStage.getScene(), model, primaryStage);
                menuScene.startScene();
            }

            // Character movement
            boolean characterMoved = false;
            for(int i = 0; i < model.getStageMap().getRows(); i++) {
                // Stops the character from moving down more that one square at a time
                if(characterMoved) {
                    break;
                }
                // Loops until it finds the desired square to move to
                for(int j = 0; j < model.getStageMap().getCols(); j++) {
                    Square eventSquare = model.getStageMap().getLocation(i, j);
                    // Move the character up
                    if ((event.getCode() == KeyCode.W) && (eventSquare.getCol() == model.getStageMap().getCharacterSquare().getCol())
                            && (eventSquare.getRow() == (model.getStageMap().getCharacterSquare().getRow() - 1)) && eventSquare.getIsAdjacent()) {
                        // Starts combat if the next square is an enemy square
                        if(eventSquare.containsEnemy()) {
                            CombatScene combatScene = new CombatScene(primaryStage.getScene(), model, primaryStage,
                                    eventSquare.getEnemy(), eventSquare.getRow(), eventSquare.getCol());
                            combatScene.startScene();
                        }
                        // Moves normally
                        if(!eventSquare.containsEnemy()) {
                            moveCharacter(eventSquare, mapGrid, eventSquare.getRow(), eventSquare.getCol());
                        }
                        break;

                    // Move the character left
                    } else if ((event.getCode() == KeyCode.A) && (eventSquare.getCol() == model.getStageMap().getCharacterSquare().getCol() - 1)
                            && (eventSquare.getRow() == (model.getStageMap().getCharacterSquare().getRow())) && eventSquare.getIsAdjacent()) {
                        // Starts combat if the next square is an enemy square
                        if(eventSquare.containsEnemy()) {
                            CombatScene combatScene = new CombatScene(primaryStage.getScene(), model, primaryStage,
                                    eventSquare.getEnemy(), eventSquare.getRow(), eventSquare.getCol());
                            combatScene.startScene();
                        }
                        // Moves normally
                        if(!eventSquare.containsEnemy()) {
                            moveCharacter(eventSquare, mapGrid, eventSquare.getRow(), eventSquare.getCol());
                        }
                        break;

                    // Move the character down
                    } else if ((event.getCode() == KeyCode.S) && (eventSquare.getCol() == model.getStageMap().getCharacterSquare().getCol())
                            && (eventSquare.getRow() == (model.getStageMap().getCharacterSquare().getRow() + 1)) && eventSquare.getIsAdjacent()) {
                        // Starts combat if the next square is an enemy square
                        if(eventSquare.containsEnemy()) {
                            CombatScene combatScene = new CombatScene(primaryStage.getScene(), model, primaryStage,
                                    eventSquare.getEnemy(), eventSquare.getRow(), eventSquare.getCol());
                            combatScene.startScene();
                        }
                        // Moves normally
                        if(!eventSquare.containsEnemy()) {
                            moveCharacter(eventSquare, mapGrid, eventSquare.getRow(), eventSquare.getCol());
                            characterMoved = true;
                        }
                        break;

                    // Move the character right
                    } else if ((event.getCode() == KeyCode.D) && (eventSquare.getCol() == model.getStageMap().getCharacterSquare().getCol() + 1)
                            && (eventSquare.getRow() == (model.getStageMap().getCharacterSquare().getRow())) && eventSquare.getIsAdjacent()) {
                        // Starts combat if the next square is an enemy square
                        if(eventSquare.containsEnemy()) {
                            CombatScene combatScene = new CombatScene(primaryStage.getScene(), model, primaryStage,
                                    eventSquare.getEnemy(), eventSquare.getRow(), eventSquare.getCol());
                            combatScene.startScene();
                        }
                        // Moves normally
                        if(!eventSquare.containsEnemy()) {
                            moveCharacter(eventSquare, mapGrid, eventSquare.getRow(), eventSquare.getCol());
                        }
                        break;
                    }
                }
            }
            // Updates the character stats every time the character moves to a new square
            CharacterDisplay characterDisplay = new CharacterDisplay(model);
            ((BorderPane) ((BorderPane) stagePane.getRight()).getTop()).setTop(characterDisplay.updateStats(model.getPlayer()));
        });
    }

    /**
     * Method to updated the model with adjacent squares.
     * @param row int representing the row the character is in
     * @param rows int representing the total number of rows
     * @param col int representing the column the character is in
     * @param cols int representing the total number of columns
     */
    public void markAdjacentSquares(GridPane mapgrid, int row, int rows, int col, int cols){
        // Toggles square above
        if(row > 0){
            model.getStageMap().getLocation(row - 1, col).toggleIsAdjacent();
            if(model.getStageMap().getLocation(row - 1, col).getIsAdjacent() && !model.getStageMap().getLocation(row - 1, col).isContainsEnemy()) {
                setAdjacentSquare(mapgrid, col, row - 1);
            }
        }

        // Toggles square below
        if(row < rows - 1){
            model.getStageMap().getLocation(row + 1, col).toggleIsAdjacent();
            if(model.getStageMap().getLocation(row + 1, col).getIsAdjacent() && !model.getStageMap().getLocation(row + 1, col).isContainsEnemy()) {
                setAdjacentSquare(mapgrid, col, row + 1);
            }
        }

        // Toggles square to the left
        if(col > 0){
            model.getStageMap().getLocation(row, col - 1).toggleIsAdjacent();
            if(model.getStageMap().getLocation(row, col - 1).getIsAdjacent() && !model.getStageMap().getLocation(row, col - 1).isContainsEnemy()) {
                setAdjacentSquare(mapgrid, col - 1, row);
            }
        }

        // Toggles square to the right
        if(col < cols - 1){
            model.getStageMap().getLocation(row, col + 1).toggleIsAdjacent();
            if(model.getStageMap().getLocation(row, col + 1).getIsAdjacent() && !model.getStageMap().getLocation(row, col + 1).isContainsEnemy()) {
                setAdjacentSquare(mapgrid, col + 1, row );
            }
        }

        // Toggle top left square
        if(row > 0 && col > 0){
            model.getStageMap().getLocation(row - 1, col - 1).toggleIsAdjacent();
            if(model.getStageMap().getLocation(row - 1, col - 1).getIsAdjacent() && !model.getStageMap().getLocation(row - 1, col - 1).isContainsEnemy()) {
                setAdjacentSquare(mapgrid, col - 1, row - 1);
            }
        }

        // Toggle top right square
        if(row > 0 && col < cols - 1){
            model.getStageMap().getLocation(row - 1, col + 1).toggleIsAdjacent();
            if(model.getStageMap().getLocation(row - 1, col + 1).getIsAdjacent() && !model.getStageMap().getLocation(row - 1, col + 1).isContainsEnemy()) {
                setAdjacentSquare(mapgrid, col + 1, row - 1);
            }
        }

        // Toggle bottom left square
        if(row < rows - 1 && col > 0){
            model.getStageMap().getLocation(row + 1, col - 1).toggleIsAdjacent();
            if(model.getStageMap().getLocation(row + 1, col - 1).getIsAdjacent() && !model.getStageMap().getLocation(row + 1, col - 1).isContainsEnemy()) {
                setAdjacentSquare(mapgrid, col - 1, row + 1);
            }
        }

        // Toggle bottom right square
        if(row < rows - 1 && col < cols - 1){
            model.getStageMap().getLocation(row + 1, col + 1).toggleIsAdjacent();
            if(model.getStageMap().getLocation(row + 1, col + 1).getIsAdjacent() && !model.getStageMap().getLocation(row + 1, col + 1).isContainsEnemy()) {
                setAdjacentSquare(mapgrid, col + 1, row + 1);
            }
        }
    }

    /**
     * Method to set the characters current location on the stage map.
     * @param gridPane GridPane representing the stage map
     * @param col int representing the column location of the character
     * @param row int representing the row location of the character
     */
    public void setCharacterSquare(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                if(node instanceof Button){
                    node.setStyle("-fx-border-color: blue; -fx-border-width: 3px;");
                }
            }
        }
    }

    /**
     * Method to set the enemies current location on the stage map.
     * @param gridPane GridPane representing the stage map
     * @param col int representing the column location of the enemy
     * @param row int representing the row location of the enemy
     */
    public void setEnemySquare(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                if(node instanceof Button){
                    node.setStyle("-fx-border-color: red; -fx-border-width: 3px;");
                }
            }
        }
    }

    /**
     * Method to set the adjacent square locations on the stage map.
     * @param gridPane GridPane representing the stage map
     * @param col int representing the column location of an adjacent square
     * @param row int representing the row location of the and adjacent square
     */
    public void setAdjacentSquare(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                if(node instanceof Button){
                    node.setStyle("-fx-border-color: yellow; -fx-border-width: 3px;");
                }
            }
        }
    }

    /**
     * Method to move the character square to a new location.
     * @param currSquare Square object representing the square currently holding the character
     * @param mapGrid GridPane representing the stage map
     * @param row int representing the row location of the new square location
     * @param col int representing the column location of the new square location
     */
    public void moveCharacter(Square currSquare, GridPane mapGrid, int row, int col){
        markAdjacentSquares(mapGrid, model.getStageMap().getCharacterSquare().getRow(), model.getStageMap().getRows(),
                model.getStageMap().getCharacterSquare().getCol(), model.getStageMap().getCols());
        model.getStageMap().getCharacterSquare().togleContainsCharacter();
        model.getStageMap().setCharacterSquare(currSquare);
        model.getStageMap().getCharacterSquare().togleContainsCharacter();
        clearGrid(mapGrid);
        setCharacterSquare(mapGrid, col, row);
        markAdjacentSquares(mapGrid, row, model.getStageMap().getRows(), col, model.getStageMap().getCols());
    }

    /**
     * Method to clear all highlighting from the stage map.
     * @param mapgrid GirdPane representing the stage map
     */
    public void clearGrid(GridPane mapgrid){
        for(Node node : mapgrid.getChildren()) {
            if(!node.getStyle().equals("-fx-border-color: red; -fx-border-width: 3px;")) {
                node.setStyle("");
            }
        }
    }
}