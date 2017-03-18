package model.races;

/**
 * Dragon race class.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Dragon extends Race {
    // Dragon starting values
    public static final int DRAGON_DEFAULT_HEALTH = 500;
    public static final int DRAGON_DEFAULT_MANA = 400;
    public static final int DRAGON_DEFAULT_MOVEMENT = 10;
    public static final int DRAGON_DEFAULT_EXPERIENCE = 0;
    public static final int DRAGON_DEFAULT_LEVEL = 1;
    public static final int DRAGON_DEFAULT_WEIGHT = 250;

    public static final String DRAGON_RACE = "Dragon";
    public static final double DRAGON_HEIGHT = 12.5;
    public static final double DRAGON_WEIGHT = 750.0;

    public Dragon(){
        super(DRAGON_RACE, DRAGON_HEIGHT, DRAGON_WEIGHT);
    }
}