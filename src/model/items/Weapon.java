package model.items;

/**
 * Abstract class for weapon items.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Weapon extends Item{
    // The private state of the weapon
    private int damage;
    private TYPE weaponType;

    public enum TYPE {SWORD, STAFF, DAGGER}

    /**
     * Manual constructor for the weapon item.
     * @param name String representing the items name
     * @param description String representing the items description text
     * @param rarity String representing the rarity of the item
     * @param value double representing the sell value of the item
     * @param weight double representing the carrying weight of the item
     */
    public Weapon(String name, String description, String rarity, int damage, double value, double weight, TYPE weaponType){
        super(name, description, rarity, true, value, weight);
        this.damage = damage;
        this.weaponType = weaponType;
    }

    /**
     * Getter method for the weapon damage.
     * @return int representing the weapon damage.
     */
    public int getDamage(){
        return this.damage;
    }
}
