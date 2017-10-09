package model.classes;

/**
 * Abstract class to hold class attributes.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class PlayerClass {
    // The private attributes of the player class
    private String name;
    private int healthModifier;
    private int dexterityModifier;
    private int intelligenceModifier;
    private int speedModifier;
    private int charismaModifier;
    private double weightModifier;
    private int powerModifier;

    /**
     * PlayerClass Constructor.
     * @param name String representing the name of the class
     * @param healthModifier int representing the amount to modify the base health value
     * @param dexterityModifier int representing the amount to modify the base dexterity value
     * @param intelligenceModifier int representing the amount to modify the base intelligence value
     * @param speedModifier int representing the amount to modify the base speed value
     * @param charismaModifier int representing the amount to modify the base charisma value
     * @param weightModifier double representing the amount to modify the base weight value
     * @param powerModifier int representing the amount to modify the base power value
     */
    public PlayerClass(String name, int healthModifier, int dexterityModifier, int intelligenceModifier, int speedModifier,
                       int charismaModifier, double weightModifier, int powerModifier) {
        this.name = name;
        this.healthModifier = healthModifier;
        this.dexterityModifier = dexterityModifier;
        this.intelligenceModifier = intelligenceModifier;
        this.speedModifier = speedModifier;
        this.charismaModifier = charismaModifier;
        this.weightModifier = weightModifier;
        this.powerModifier = powerModifier;
    }

    ///
    /// Temporary Getter and Setter methods
    ///

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthModifier() {
        return healthModifier;
    }

    public void setHealthModifier(int healthModifier) {
        this.healthModifier = healthModifier;
    }

    public int getintelligenceModifier() {
        return intelligenceModifier;
    }

    public void setintelligenceModifier(int intelligenceModifier) {this.intelligenceModifier = intelligenceModifier;}

    public int getDexterityModifier() {
        return dexterityModifier;
    }

    public void setDexterityModifier(int dexterityModifier) {
        this.dexterityModifier = dexterityModifier;
    }

    public int getSpeedModifier() {
        return speedModifier;
    }

    public void setSpeedModifier(int speedModifier) {
        this.speedModifier = speedModifier;
    }

    public int getCharismaModifier() {
        return charismaModifier;
    }

    public void setCharismaModifier(int charismaModifier) {
        this.charismaModifier = charismaModifier;
    }

    public double getWeightModifier() {
        return weightModifier;
    }

    public void setWeightModifier(double weightModifier) {
        this.weightModifier = weightModifier;
    }

    public int getPowerModifier() {
        return powerModifier;
    }

    public void setPowerModifier(int powerModifier) {
        this.powerModifier = powerModifier;
    }
}
