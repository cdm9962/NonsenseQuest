package model;

/**
 * The model for the game.  Updates based on user interactions.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class GameModel {
    private Player player;

    public GameModel(String name, String race, String playerClass ){
        this.player = new Player(name, race, playerClass);
    };

    public String printCharacterStats(){
        return this.player.displayCharacter();
    }
}
