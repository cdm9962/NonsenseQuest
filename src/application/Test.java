package application;

import model.Player;

/**
 * Class for testing model functionality.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Test {
    public static void main(String[] args) {
        Player player = new Player("Human", "Connor", "Warrior");
        System.out.println(player.toString());
    }

}
