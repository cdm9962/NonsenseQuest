package model.items;

/**
 * Sword object class.
 *
 * @author Connor D. Milligan
 */
public class Sword extends Weapon {
    public Sword(String name, String description, int damage, String rarity, boolean equipable, double value, double weight) {
        super(name, description, damage, rarity, equipable, value, weight);
    }
}
