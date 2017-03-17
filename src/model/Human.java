package model;

/**
 * Human race class.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Human extends Race {
    // Human starting values
    public static final int HUMAN_DEFAULT_HEALTH = 100;
    public static final int HUMAN_DEFAULT_MANA = 100;
    public static final int HUMAN_DEFAULT_MOVEMENT = 5;
    public static final int HUMAN_DEFAULT_EXPERIENCE = 0;
    public static final int HUMAN_DEFAULT_LEVEL = 1;
    public static final int HUMAN_DEFAULT_WEIGHT = 80;

    public static final String HUMAN_RACE = "Human";
    public static final double HUMAN_HEIGHT = 5.11;
    public static final double HUMAN_WEIGHT = 200.0;

    public Human(){
        super(HUMAN_RACE, HUMAN_HEIGHT, HUMAN_WEIGHT);
    }
}
