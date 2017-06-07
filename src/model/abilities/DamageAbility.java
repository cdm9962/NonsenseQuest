package model.abilities;

/**
 * Abstract class to hold attributes for damage abilities.
 *
 * @author Connor D. Milligan
 */
public abstract class DamageAbility extends Ability {
    // Private state of damage abilities
    private int damage;
    private int accuracy;

    /**
     * DamageAbility Constructor.
     * @param name String representing the name of the ability
     * @param description String representing the effect of the ability
     * @param damage int representing the damage value of the ability
     * @param accuracy int representing the accuracy value of the ability
     */
    public DamageAbility(String name, String description, int damage, int accuracy) {
        super(name, description);
        this.damage = damage;
        this.accuracy = accuracy;
    }

    /**
     * Getter method for the ability damage.
     * @return int representing the damage of the ability
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Getter method for the ability accuracy.
     * @return int representing the accuracy of the ability
     */
    public int getAccuracy() {
        return accuracy;
    }
}
