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
    private long maxExperience;
    private long minExperience;
    private int maxLevel;
    private int minLevel;
    private double maxWeight;
    private double minWeight;


    // Default values
    public static final int DEFAULT_MIN_HEALTH = 0;
    public static final int DEFAULT_MAX_LEVEL = 50;
    public static final double DEFAULT_MIN_WEIGHT = 0;
    public static final long LEVEL_ONE_EXPERIENCE = 1000;


    /**
     * Manual constructor for testing.
     * @param maxHealth int representing the maximum health of a character
     * @param minHealth int representing the minimum health of a character
     * @param maxExperience long representing the maximum experience points for the current level
     * @param minExperience long representing the minimum experience points for the current level
     * @param maxLevel int representing the maximum level of a character
     * @param minLevel int representing the minimum level of a character
     * @param maxWeight double representing the maximum weight of a character
     * @param minWeight double representing the minimum weight of a character
     */
    public Limits(int maxHealth, int minHealth, long maxExperience, long minExperience, int maxLevel, int minLevel,
                  double maxWeight, double minWeight) {
        this.maxHealth = maxHealth;
        this.minHealth = minHealth;
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
        if(race.equals(Human.HUMAN_RACE)){
            this.maxHealth = Human.HUMAN_DEFAULT_HEALTH;
            this.minHealth = DEFAULT_MIN_HEALTH;
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
                ", maxExperience=" + maxExperience +
                ", minExperience=" + minExperience +
                ", maxLevel=" + maxLevel +
                ", minLevel=" + minLevel +
                ", maxWeight=" + maxWeight +
                ", minWeight=" + minWeight +
                '}';
    }
}
