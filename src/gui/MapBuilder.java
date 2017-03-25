package gui;

import javafx.geometry.Insets;
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
                    //Button emptyButton = new Button(Character.toString(GrassSquare.EMPTY_SQUARE_CHARACTER));
                    Button grassButton = new Button();
                    Background grassTexture = new Background(new BackgroundImage(new Image("file:grass.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
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
                } else if(currSquare instanceof DirtRoadSquare){
                    //Button roadButton = new Button(Character.toString(DirtRoadSquare.ROAD_SQUARE_CHARACTER));
                    Button roadButton = new Button();
                    Background roadTexture = new Background(new BackgroundImage(new Image(currSquare.getFilename()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
                    roadButton.setBackground(roadTexture);
                    roadButton.setMinSize(50.0, 50.0);
                    mapGrid.add(roadButton, col, row);
                    roadButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                    });

                } else if(currSquare instanceof DirtSquare){
                    //Button roadButton = new Button(Character.toString(DirtRoadSquare.ROAD_SQUARE_CHARACTER));
                    Button dirtButton = new Button();
                    Background dirtTexture = new Background(new BackgroundImage(new Image("file:dirt.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
                    dirtButton.setBackground(dirtTexture);
                    dirtButton.setMinSize(50.0, 50.0);
                    mapGrid.add(dirtButton, col, row);
                    dirtButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                    });

                } else if(currSquare instanceof TreeSquare){
                    //Button roadButton = new Button(Character.toString(DirtRoadSquare.ROAD_SQUARE_CHARACTER));
                    Button treeButton = new Button();
                    Background treeTexture = new Background(new BackgroundImage(new Image(currSquare.getFilename()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
                    treeButton.setBackground(treeTexture);
                    treeButton.setMinSize(50.0, 50.0);
                    mapGrid.add(treeButton, col, row);
                    treeButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                    });

                // Creates character space buttons
//                } else if(currSquare instanceof CharacterSquare){
//                    Button characterButton = new Button(Character.toString(CharacterSquare.CHARACTER_SQUARE_CHARACTER));
//                    characterButton.setMinSize(50.0, 50.0);
//                    mapGrid.add(characterButton, col, row);
//                    characterButton.setOnAction(event -> {
//                        squareDescription.setText(currSquare.getDescription());
//                    });
//                    markAdjacentSquares(row, this.model.getStageMap().getRows(), col, this.model.getStageMap().getCols());
                }
            }
        }

        return border;
    }

    public void markAdjacentSquares(int row, int rows, int col, int cols){
        // Toggles square above
        if(row > 0){
            this.model.getStageMap().getLocation(row - 1, col).toggleIsAdjacent();
        }

        // Toggles square below
        if(row < rows - 1){
            this.model.getStageMap().getLocation(row + 1, col).toggleIsAdjacent();
        }

        // Toggles square to the left
        if(col > 0){
            this.model.getStageMap().getLocation(row, col - 1).toggleIsAdjacent();
        }

        // Toggles square to the right
        if(col < cols - 1){
            this.model.getStageMap().getLocation(row, col + 1).toggleIsAdjacent();
        }
    }
}
