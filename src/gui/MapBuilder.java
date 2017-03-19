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
    private GameModel model;

    public MapBuilder(GameModel model){
        this.model = model;
    }

    public GridPane buildMap(){
        GridPane mapGrid = new GridPane();

        for(int row = 0; row < this.model.getStageMap().getRows(); row++){
            for(int col = 0; col < this.model.getStageMap().getCols(); col++){


                if(this.model.getStageMap().getLocation(row, col) == StageMap.MAP_EMPTY){
                    Button emptyButton = new Button(Character.toString(StageMap.MAP_EMPTY));
                    emptyButton.setMinSize(50.0, 50.0);
                    mapGrid.add(emptyButton, col, row);


                } else if(this.model.getStageMap().getLocation(row, col) == StageMap.MAP_ROAD){
                    Button roadButton = new Button(Character.toString(StageMap.MAP_ROAD));
                    roadButton.setMinSize(50.0, 50.0);
                    mapGrid.add(roadButton, col, row);
                }
            }
        }

        return mapGrid;
    }
}
