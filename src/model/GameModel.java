package model;

import gui.ButtonHelper;
import model.map.StageMap;

/**
 * The model for the game. Updates based on user interactions.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class GameModel {
    // The private state of the game model
    private Player player;
    private StageMap stageMap;
    private ButtonHelper buttonHelper;
    private String currSquareDescription;

    /**
     * Constructor for the game model.
     * @param name String representing the character's name
     * @param race String representing the character's race
     * @param playerClass String representing the character's class
     */
    public GameModel(String name, String race, String playerClass ) {
        this.player = new Player(name, race, playerClass);
        stageMap = null;
        this.buttonHelper = new ButtonHelper();
        currSquareDescription = null;
    }

    /**
     * Displays the character stats to the scene.
     * @return String representing the character stats
     */
    public String printCharacterStats(){
        return this.player.displayCharacter();
    }

    /**
     * Method to set the stage map.
     * @param filename String representing the file to read the map from
     */
    public void setStageMap(String filename){
        this.stageMap = new StageMap(filename);

    }

    /**
     * Getter method for the stage map.
     * @return char[][] representing the stage map
     */
    public StageMap getStageMap(){
        return this.stageMap;
    }

    /**
     * Getter method for the square description.
     * @return String representing the square description
     */
    public String getCurrSquareDescription(){
        return this.currSquareDescription;
    }

    /**
     * Getter method for the player object.
     * @return Player object representing the player character.
     */
    public Player getPlayer(){
        return this.player;
    }

    /**
     * Getter method for the ButtonHelper object.
     * @return ButtonHelper object to help modify button attributes.
     */
    public ButtonHelper getButtonHelper() { return this.buttonHelper; }
}
