package model;

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

    public PlayerClass(String name, int healthModifier, int manaModifier, int movementModifier, double weightModifier) {
        this.name = name;
        this.healthModifier = healthModifier;
        this.manaModifier = manaModifier;
        this.movementModifier = movementModifier;
        this.weightModifier = weightModifier;
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
