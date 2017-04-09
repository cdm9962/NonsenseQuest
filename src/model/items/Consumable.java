package model.items;

/**
 * Created by Connor on 4/8/2017.
 */
public class Consumable extends Item {
    /**
     * Manual constructor for the item.
     *
     * @param name        String representing the items name
     * @param description String representing the items description text
     * @param rarity      String representing the rarity of the item
     * @param equipable   boolean to determine if the item can be equipped
     * @param value       double representing the sell value of the item
     * @param weight      double representing the carrying weight of the item
     */
    public Consumable(String name, String description, String rarity, boolean equipable, double value, double weight) {
        super(name, description, rarity, equipable, value, weight);
    }
}
