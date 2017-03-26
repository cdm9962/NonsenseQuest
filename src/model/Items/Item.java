package model.items;

/**
 * A player usable value object.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Item {
    // The private state of the item
    private String name;
    private  String description;
    private String rarity;
    private boolean equipable;
    private double value;
    private double weight;

    /**
     * Manual constructor for the item.
     * @param name String representing the items name
     * @param description String representing the items description text
     * @param rarity String representing the rarity of the item
     * @param equipable boolean to determine if the item can be equipped
     * @param value double representing the sell value of the item
     * @param weight double representing the carrying weight of the item
     */
    public Item(String name, String description, String rarity, boolean equipable, double value, double weight) {
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.equipable = equipable;
        this.value = value;
        this.weight = weight;
    }

    /**
     * Getter method for the item's name.
     * @return String representing the items name
     */
    public String getName(){
        return this.name;
    }
}
