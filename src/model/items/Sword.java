package model.items;

/**
 * Class to hold sword type information.
 */
public class Sword extends Weapon {
    // The sword type
    private SWORDTYPE swordtype;

    // All the possible types of swords
    public enum SWORDTYPE {RUSTY, IRON, MASTERWORK, SPIKED, GOD}

    // Constant file paths
    public static final String RUSTY_SWORD_FILE = "/images/items/weapons/swordrusty.png";
    public static final String IRON_SWORD_FILE = "/images/items/weapons/swordiron.png";
    public static final String MASTERWORK_SWORD_FILE = "/images/items/weapons/swordmasterwork.png";
    public static final String SPIKED_SWORD_FILE = "/images/items/weapons/swordspiked.png";
    public static final String GOD_SWORD_FILE = "/images/items/weapons/swordgod.png";

    /**
     * Manual constructor for the weapon item.
     *
     * @param name String representing the items name
     * @param description String representing the items description text
     * @param rarity String representing the rarity of the item
     * @param damage int representing the base damage of the sword
     * @param value double representing the sell value of the item
     * @param weight double representing the carrying weight of the item
     * @param imageFilename String representing the image file location
     * @param swordtype SWORDTYPE representing the type of the sword
     */
    public Sword(String name, String description, String rarity, int damage, double value, double weight, String imageFilename, SWORDTYPE swordtype) {
        super(name, description, rarity, value, weight, imageFilename, damage, TYPE.SWORD);
        this.swordtype = swordtype;
    }

    /**
     * Getter method for the sword type.
     * @return SWORDTPYE representing the type of sword
     */
    public SWORDTYPE getSwordtype() {
        return swordtype;
    }
}
