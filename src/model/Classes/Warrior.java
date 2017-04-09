package model.classes;

/**
 * Warrior player class.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Warrior extends PlayerClass {
    // Default warrior modifier values
    public static final int WARRIOR_HEALTH_MODIFIER = 50;
    public static final int WARRIOR_DEXTERITY_MODIFIER = -20;
    public static final int WARRIOR_INTELLIGENCE_MODIFIER = -20;
    public static final int WARRIOR_SPEED_MODIFIER = 0;
    public static final int WARRIOR_CHARISMA_MODIFIER = 0;
    public static final double WARRIOR_WEIGHT_MODIFIER = 40;
    public static final int WARRIOR_POWER_MODIFIER = 10;

    // Warrior player class name
    public static final String WARRIOR_PLAYER_CLASS = "Warrior";

    /**
     * The warrior class constructor.
     */
    public Warrior() {
        super(WARRIOR_PLAYER_CLASS, WARRIOR_HEALTH_MODIFIER, WARRIOR_DEXTERITY_MODIFIER, WARRIOR_INTELLIGENCE_MODIFIER, WARRIOR_SPEED_MODIFIER,
                WARRIOR_CHARISMA_MODIFIER, WARRIOR_WEIGHT_MODIFIER, WARRIOR_POWER_MODIFIER);
    }
}
