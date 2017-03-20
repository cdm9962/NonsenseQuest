package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.*;

/**
 * Utility class for building the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class MapBuilder {
    // The private game model for the map builder
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
     * @return GridPane a visual representation of the stage map
     */
    public BorderPane buildMap(){
        // Creates the grid
        BorderPane border = new BorderPane();
        GridPane mapGrid = new GridPane();
        border.setLeft(mapGrid);
        Label squareDescription = new Label();
        squareDescription.setPadding(new Insets(GameInterface.DEFAULT_INSETS));
        squareDescription.setMinSize(100, 100);
        border.setBottom(squareDescription);

        // Loops through each row and column in the grid
        for(int row = 0; row < this.model.getStageMap().getRows(); row++){
            for(int col = 0; col < this.model.getStageMap().getCols(); col++){
                Square currSquare = this.model.getStageMap().getLocation(row, col);

                // Creates empty space buttons
                if(currSquare instanceof EmptySquare){
                    Button emptyButton = new Button(Character.toString(EmptySquare.EMPTY_SQUARE_CHARACTER));
                    emptyButton.setMinSize(50.0, 50.0);
                    mapGrid.add(emptyButton, col, row);
                    emptyButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                    });

                // Creates road space buttons
                } else if(currSquare instanceof RoadSquare){
                    Button roadButton = new Button(Character.toString(RoadSquare.ROAD_SQUARE_CHARACTER));
                    roadButton.setMinSize(50.0, 50.0);
                    mapGrid.add(roadButton, col, row);
                    roadButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                    });

                // Creates character space buttons
                } else if(currSquare instanceof CharacterSquare){
                    Button characterButton = new Button(Character.toString(CharacterSquare.CHARACTER_SQUARE_CHARACTER));
                    characterButton.setMinSize(50.0, 50.0);
                    mapGrid.add(characterButton, col, row);
                    characterButton.setOnAction(event -> {
                        squareDescription.setText(currSquare.getDescription());
                    });
                }
            }
        }

        return border;
    }
}
