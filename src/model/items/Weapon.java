package model.items;

/**
 * Abstract class for weapon items.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Weapon extends Item{
    // The private state of the weapon
    private int damage;

    /**
     * Manual constructor for the weapon item.
     * @param name String representing the items name
     * @param description String representing the items description text
     * @param rarity String representing the rarity of the item
     * @param value double representing the sell value of the item
     * @param weight double representing the carrying weight of the item
     */
    public Weapon(String name, String description, String rarity, int damage, double value, double weight){
        super(name, description, rarity, true, value, weight);
        this.damage = damage;
    }
}
