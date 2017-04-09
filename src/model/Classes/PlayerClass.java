package model.classes;

/**
 * Abstract class to hold class attributes.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class PlayerClass {
    private String name;
    private int healthModifier;
    private int manaModifier;
    private int movementModifier;
    private double weightModifier;
    private int powerModifier;

    /**
     * PlayerClass constructor.
     * @param name String representing the class name
     * @param healthModifier int representing the health modifier from the player class
     * @param manaModifier int representing the mana modifier from the player class
     * @param movementModifier int representing the movement modifier from the player class
     * @param weightModifier int representing the weight modifier from the player class
     * @param powerModifier int representing the power modifier from the player class
     */
    public PlayerClass(String name, int healthModifier, int manaModifier, int movementModifier, double weightModifier, int powerModifier) {
        this.name = name;
        this.healthModifier = healthModifier;
        this.manaModifier = manaModifier;
        this.movementModifier = movementModifier;
        this.weightModifier = weightModifier;
        this.powerModifier = powerModifier;
    }

    public String getName(){ return  name; }

    public int getHealthModifier() {
        return healthModifier;
    }

    public void setHealthModifier(int healthModifier) {
        this.healthModifier = healthModifier;
    }

    public int getManaModifier() {
        return manaModifier;
    }

    public void setManaModifier(int manaModifier) {
        this.manaModifier = manaModifier;
    }

    public int getMovementModifier() {
        return movementModifier;
    }

    public void setMovementModifier(int movementModifier) {
        this.movementModifier = movementModifier;
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

    @Override
    public String toString() {
        return "PlayerClass{" +
                "name='" + name + "' " +
                "healthModifier=" + healthModifier +
                ", manaModifier=" + manaModifier +
                ", movementModifier=" + movementModifier +
                ", weightModifier=" + weightModifier +
                '}';
    }
}
