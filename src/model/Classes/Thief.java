package model.classes;

/**
 * Warrior player class.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Thief extends PlayerClass {
    // Default thief modifier values
    public static final int THIEF_HEALTH_MODIFIER = -20;
    public static final int THIEF_DEXTERITY_MODIFIER = 40;
    public static final int THIEF_INTELLIGENCE_MODIFIER = -20;
    public static final int THIEF_SPEED_MODIFIER = 20;
    public static final int THIEF_CHARISMA_MODIFIER = 20;
    public static final double THIEF_WEIGHT_MODIFIER = -20;
    public static final int THIEF_POWER_MODIFIER = 0;

    // thief player class name
    public static final String THIEF_PLAYER_CLASS = "Thief";

    /**
     * The thief class constructor.
     */
    public Thief() {
        super(THIEF_PLAYER_CLASS, THIEF_HEALTH_MODIFIER, THIEF_DEXTERITY_MODIFIER, THIEF_INTELLIGENCE_MODIFIER, THIEF_SPEED_MODIFIER,
                THIEF_CHARISMA_MODIFIER, THIEF_WEIGHT_MODIFIER, THIEF_POWER_MODIFIER);
    }
}
