package model.items;

/**
 * Sword object class.
 *
 * @author Connor D. Milligan
 */
public class Sword extends Weapon {
    /**
     * Manual constructor for the sword weapon.
     * @param name String representing the items name
     * @param description String representing the items description text
     * @param rarity String representing the rarity of the item
     * @param value double representing the sell value of the item
     * @param weight double representing the carrying weight of the item
     */
    public Sword(String name, String description, String rarity, int damage, double value, double weight) {
        super(name, description, rarity, damage, value, weight);
    }
}
