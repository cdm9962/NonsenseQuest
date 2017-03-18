package model.classes;

/**
 * Warrior player class.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Thief extends PlayerClass {
    // Default thief modifier values
    public static final int THIEF_HEALTH_MODIFIER = -20;
    public static final int THIEF_MANA_MODIFIER = -20;
    public static final int THIEF_MOVEMENT_MODIFIER = 3;
    public static final double THIEF_WEIGHT_MODIFIER = 0;

    // thief player class name
    public static final String THIEF_PLAYER_CLASS = "Thief";

    /**
     * The thief class constructor.
     */
    public Thief() {
        super(THIEF_PLAYER_CLASS, THIEF_HEALTH_MODIFIER, THIEF_MANA_MODIFIER, THIEF_MOVEMENT_MODIFIER, THIEF_WEIGHT_MODIFIER);
    }
}
