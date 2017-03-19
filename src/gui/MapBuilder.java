package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.GameModel;
import model.StageMap;

/**
 * Utility class for building the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class MapBuilder {
    // The private game model for the map builder
    private GameModel model;

    /**
     * Constructor for the map builder.
     * @param model GameModel representing the game attributes
     */
    public MapBuilder(GameModel model){
        this.model = model;
    }

    /**
     * Method to create a map grid based on the map data stored in the model.
     * @return GridPane a visual representation of the stage map
     */
    public GridPane buildMap(){
        // Creates the grid
        GridPane mapGrid = new GridPane();

        // Loops through each row and column in the grid
        for(int row = 0; row < this.model.getStageMap().getRows(); row++){
            for(int col = 0; col < this.model.getStageMap().getCols(); col++){

                // Creates empty space buttons
                if(this.model.getStageMap().getLocation(row, col) == StageMap.MAP_EMPTY){
                    Button emptyButton = new Button(Character.toString(StageMap.MAP_EMPTY));
                    emptyButton.setMinSize(50.0, 50.0);
                    mapGrid.add(emptyButton, col, row);

                // Creates road space buttons
                } else if(this.model.getStageMap().getLocation(row, col) == StageMap.MAP_ROAD){
                    Button roadButton = new Button(Character.toString(StageMap.MAP_ROAD));
                    roadButton.setMinSize(50.0, 50.0);
                    mapGrid.add(roadButton, col, row);

                // Creates character space buttons
                } else if(this.model.getStageMap().getLocation(row, col) == StageMap.MAP_CHARACTER){
                    Button characterButton = new Button(Character.toString(StageMap.MAP_CHARACTER));
                    characterButton.setMinSize(50.0, 50.0);
                    mapGrid.add(characterButton, col, row);
                }
            }
        }

        return mapGrid;
    }
}
