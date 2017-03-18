package model;

import model.races.Human;

/**
 * Class to hold the minimum and maximum player values.
 *
 * @author Connor D. Milligan
 */
public class Limits {
    // The private limit values
    private int maxHealth;
    private int minHealth;
    private int maxMana;
    private int minMana;
    private int maxMovement;
    private int minMovement;
    private long maxExperience;
    private long minExperience;
    private int maxLevel;
    private int minLevel;
    private double maxWeight;
    private double minWeight;

    public static final String HUMAN_RACE = "Human";

    public static final int DEFAULT_MIN_HEALTH = 0;
    public static final int DEFAULT_MIN_MANA = 0;
    public static final int DEFAULT_MIN_MOVEMENT = 0;
    public static final int DEFAULT_MAX_LEVEL = 50;
    public static final double DEFAULT_MIN_WEIGHT = 0;

    public static final long LEVEL_ONE_EXPERIENCE = 1000;


    /**
     * Manual constructor for testing.
     * @param maxHealth int representing the maximum health of a character
     * @param minHealth int representing the minimum health of a character
     * @param maxMana int representing the maximum mana of a character
     * @param minMana int representing the minimum mana of a character
     * @param maxMovement int representing the maximum movement distance of a character
     * @param minMovement int representing the minimum movement distance of a character
     * @param maxExperience long representing the maximum experience points for the current level
     * @param minExperience long representing the minimum experience points for the current level
     * @param maxLevel int representing the maximum level of a character
     * @param minLevel int representing the minimum level of a character
     * @param maxWeight double representing the maximum weight of a character
     * @param minWeight double representing the minimum weight of a character
     */
    public Limits(int maxHealth, int minHealth, int maxMana, int minMana, int maxMovement, int minMovement, long maxExperience,
                  long minExperience, int maxLevel, int minLevel, double maxWeight, double minWeight) {
        this.maxHealth = maxHealth;
        this.minHealth = minHealth;
        this.maxMana = maxMana;
        this.minMana = minMana;
        this.maxMovement = maxMovement;
        this.minMovement = minMovement;
        this.maxExperience = maxExperience;
        this.minExperience = minExperience;
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    /**
     * Limit constructor for the various races.
     * @param race String representing the character's race
     */
    public Limits(String race){
        // Human limit constructor
        if(race.equals(HUMAN_RACE)){
            this.maxHealth = Human.HUMAN_DEFAULT_HEALTH;
            this.minHealth = DEFAULT_MIN_HEALTH;
            this.maxMana = Human.HUMAN_DEFAULT_MANA;
            this.minMana = DEFAULT_MIN_MANA;
            this.maxMovement = Human.HUMAN_DEFAULT_MOVEMENT;
            this.minMovement = DEFAULT_MIN_MOVEMENT;
            this.maxExperience = LEVEL_ONE_EXPERIENCE;
            this.minExperience = Human.HUMAN_DEFAULT_EXPERIENCE;
            this.maxLevel = DEFAULT_MAX_LEVEL;
            this.minLevel = Human.HUMAN_DEFAULT_LEVEL;
            this.maxWeight = Human.HUMAN_DEFAULT_WEIGHT;
            this.minWeight = DEFAULT_MIN_WEIGHT;
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMinHealth() {
        return minHealth;
    }

    public void setMinHealth(int minHealth) {
        this.minHealth = minHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getMinMana() {
        return minMana;
    }

    public void setMinMana(int minMana) {
        this.minMana = minMana;
    }

    public int getMaxMovement() {
        return maxMovement;
    }

    public void setMaxMovement(int maxMovement) {
        this.maxMovement = maxMovement;
    }

    public int getMinMovement() {
        return minMovement;
    }

    public void setMinMovement(int minMovement) {
        this.minMovement = minMovement;
    }

    public long getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(long maxExperience) {
        this.maxExperience = maxExperience;
    }

    public long getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(long minExperience) {
        this.minExperience = minExperience;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    @Override
    public String toString() {
        return "Limits{" +
                "maxHealth=" + maxHealth +
                ", minHealth=" + minHealth +
                ", maxMana=" + maxMana +
                ", minMana=" + minMana +
                ", maxMovement=" + maxMovement +
                ", minMovement=" + minMovement +
                ", maxExperience=" + maxExperience +
                ", minExperience=" + minExperience +
                ", maxLevel=" + maxLevel +
                ", minLevel=" + minLevel +
                ", maxWeight=" + maxWeight +
                ", minWeight=" + minWeight +
                '}';
    }
}
