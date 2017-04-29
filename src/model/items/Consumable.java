package model.items;

/**
 * Class to hold consumable item information
 *
 * @author Connor D. Milligan
 */
public class Consumable extends Item {
    /**
     * Manual constructor for the item.
     *
     * @param name String representing the items name
     * @param description String representing the items description text
     * @param rarity String representing the rarity of the item
     * @param equipable boolean to determine if the item can be equipped
     * @param value double representing the sell value of the item
     * @param weight double representing the carrying weight of the item
     * @param imageFilename String representing the image file location
     */
    public Consumable(String name, String description, String rarity, boolean equipable, double value, double weight, String imageFilename) {
        super(name, description, rarity, equipable, value, weight, imageFilename);
    }
}
