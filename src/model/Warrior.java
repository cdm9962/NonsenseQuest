package model;

/**
 * Warrior player class.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Warrior extends PlayerClass {
    // Default warrior modifier values
    public static final int WARRIOR_HEALTH_MODIFIER = 50;
    public static final int WARRIOR_MANA_MODIFIER = -30;
    public static final int WARRIOR_MOVEMENT_MODIFIER = -1;
    public static final double WARRIOR_WEIGHT_MODIFIER = 40;

    // Warrior player class name
    public static final String WARRIOR_PLAYER_CLASS = "Warrior";

    /**
     * The warrior class constructor.
     */
    public Warrior() {
        super(WARRIOR_PLAYER_CLASS, WARRIOR_HEALTH_MODIFIER, WARRIOR_MANA_MODIFIER, WARRIOR_MOVEMENT_MODIFIER, WARRIOR_WEIGHT_MODIFIER);
    }
}
