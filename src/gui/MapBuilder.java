package gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

    /**
     * Constructor for the map builder.
     * @param model GameModel representing the game attributes
     */
    public MapBuilder(GameModel model, Stage primaryStage){
        this.model = model;
        this.primaryStage = primaryStage;
    }

    /**
     * Method to create a map grid based on the map data stored in the model.
     * @return BorderPane a visual representation of the stage map
     */
    public BorderPane buildMap(){
        // Creates the grid
        BorderPane border = new BorderPane();
        GridPane mapGrid = new GridPane();
        mapGrid.setHgap(2);
        mapGrid.setVgap(2);
        border.setLeft(mapGrid);
        Label squareDescription = new Label();
        squareDescription.setPadding(new Insets(GameInterface.DEFAULT_INSETS));
        squareDescription.setMinSize(100, 100);
        border.setBottom(squareDescription);

        // Loops through each row and column in the grid
        for(int row = 0; row < this.model.getStageMap().getRows(); row++){
            for(int col = 0; col < this.model.getStageMap().getCols(); col++){
                Square currSquare = this.model.getStageMap().getLocation(row, col);

                // Creates grass space buttons
                if(currSquare instanceof GrassSquare){
                    Button grassButton = new Button();
                    Background grassTexture = new Background(new BackgroundImage(new Image(getClass().getResource(currSquare.getFilename()).toExternalForm()),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
                    grassButton.setBackground(grassTexture);
                    grassButton.setMinSize(50.0, 50.0);
                    mapGrid.add(grassButton, col, row);
                    grassButton.setOnAction(event -> {
                        if(currSquare.getIsAdjacent()){
                            squareDescription.setText("This square is adjacent");
                        } else {
                            squareDescription.setText(currSquare.getDescription());
                        }
                    });

                // Creates road space buttons
                } else if(currSquare instanceof DirtPathSquare){
                    Button roadButton = new Button();
                    Background roadTexture = new Background(new BackgroundImage(new Image(getClass().getResource(currSquare.getFilename()).toExternalForm()),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
                    roadButton.setBackground(roadTexture);
                    roadButton.setMinSize(50.0, 50.0);
                    mapGrid.add(roadButton, col, row);
                    final int finalRow = row;
                    final int finalCol = col;
                    roadButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                        if(currSquare.getIsAdjacent()){
                            moveCharacter(currSquare, mapGrid, finalRow, finalCol);
                        }
                    });

                // Creates dirt space buttons
                } else if(currSquare instanceof DirtSquare){
                    Button dirtButton = new Button();
                    Background dirtTexture = new Background(new BackgroundImage(new Image(getClass().getResource(currSquare.getFilename()).toExternalForm()),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
                    dirtButton.setBackground(dirtTexture);
                    dirtButton.setMinSize(50.0, 50.0);
                    mapGrid.add(dirtButton, col, row);
                    dirtButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                    });

                // Creates tree space buttons
                } else if(currSquare instanceof TreeSquare){
                    Button treeButton = new Button();
                    Background treeTexture = new Background(new BackgroundImage(new Image(getClass().getResource(currSquare.getFilename()).toExternalForm()),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
                    treeButton.setBackground(treeTexture);
                    treeButton.setMinSize(50.0, 50.0);
                    mapGrid.add(treeButton, col, row);
                    treeButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                    });
                }

                // Locates the character square and marks adjacency
                if (currSquare.isContainsCharacter()){
                    setCharacterSquare(mapGrid, col, row);
                    markAdjacentSquares(mapGrid, row, this.model.getStageMap().getRows(), col, this.model.getStageMap().getCols());
                }
            }
        }

        return border;
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
            this.model.getStageMap().getLocation(row - 1, col).toggleIsAdjacent();
            setAdjacentSquare(mapgrid, col, row - 1);
        }

        // Toggles square below
        if(row < rows - 1){
            this.model.getStageMap().getLocation(row + 1, col).toggleIsAdjacent();
            setAdjacentSquare(mapgrid, col, row + 1);
        }

        // Toggles square to the left
        if(col > 0){
            this.model.getStageMap().getLocation(row, col - 1).toggleIsAdjacent();
            setAdjacentSquare(mapgrid, col - 1, row);
        }

        // Toggles square to the right
        if(col < cols - 1){
            this.model.getStageMap().getLocation(row, col + 1).toggleIsAdjacent();
            setAdjacentSquare(mapgrid, col + 1, row);
        }

        // Toggle top left square
        if(row > 0 && col > 0){
            this.model.getStageMap().getLocation(row - 1, col - 1).toggleIsAdjacent();
            setAdjacentSquare(mapgrid, col - 1, row - 1);
        }

        // Toggle top right square
        if(row > 0 && col < cols - 1){
            this.model.getStageMap().getLocation(row - 1, col + 1).toggleIsAdjacent();
            setAdjacentSquare(mapgrid, col + 1, row - 1);
        }

        // Toggle bottom left square
        if(row < rows - 1 && col > 0){
            this.model.getStageMap().getLocation(row + 1, col - 1).toggleIsAdjacent();
            setAdjacentSquare(mapgrid, col - 1, row + 1);
        }

        // Toggle bottom right square
        if(row < rows - 1 && col < cols - 1){
            this.model.getStageMap().getLocation(row + 1, col + 1).toggleIsAdjacent();
            setAdjacentSquare(mapgrid, col + 1, row + 1);
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
                    node.setStyle("-fx-border-color: blue; -fx-border-width: 5px;");
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
                    node.setStyle("-fx-border-color: yellow; -fx-border-width: 5px;");
                }
            }
        }
    }

    public void moveCharacter(Square currSquare, GridPane mapGrid, int row, int col){
        currSquare.togleContainsCharacter();
        setCharacterSquare(mapGrid, col, row);
        markAdjacentSquares(mapGrid, row, this.model.getStageMap().getRows(), col, this.model.getStageMap().getCols());
    }
}
