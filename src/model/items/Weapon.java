package model.items;

/**
 * Abstract class for weapon items.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Weapon extends Item {
    // The private state of the weapon
    private int damage;
    private TYPE weaponType;

    // The weapon type
    public enum TYPE {SWORD, STAFF, DAGGER}

    /**
     * Manual constructor for the weapon item.
     * @param name String representing the items name
     * @param description String representing the items description text
     * @param rarity String representing the rarity of the item
     * @param value double representing the sell value of the item
     * @param weight double representing the carrying weight of the item
     * @param imageFilename String representing the image file location
     * @param damage int representing the base damage of the weapon
     * @param weaponType TYPE representing the type of weapon it is
     */
    public Weapon(String name, String description, String rarity, double value, double weight, String imageFilename, int damage, TYPE weaponType) {
        super(name, description, rarity, true, value, weight, imageFilename);
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

    @Override
    public String toString() {
        String result = super.toString();
        return result +
                "\tweaponType: " + weaponType + "\n" +
                "\tdamage: " + damage + "\n";
    }
}
