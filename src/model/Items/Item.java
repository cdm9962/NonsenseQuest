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
    private String imageFilename;

    /**
     * Manual constructor for the item.
     * @param name String representing the items name
     * @param description String representing the items description text
     * @param rarity String representing the rarity of the item
     * @param equipable boolean to determine if the item can be equipped
     * @param value double representing the sell value of the item
     * @param weight double representing the carrying weight of the item
     */
    public Item(String name, String description, String rarity, boolean equipable, double value, double weight, String imageFilename) {
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.equipable = equipable;
        this.value = value;
        this.weight = weight;
        this.imageFilename = imageFilename;
    }

    /**
     * Method to display the item stats.
     * @return String representing the item stats
     */
    public String printItemStats() {
        return  "Name: " + name + "\n" +
                "\tDescription: " + description + "\n" +
                "\tRarity: " + rarity + "\n" +
                "\tEquipable: " + equipable + "\n" +
                "\tValue: " + value + "\n" +
                "\tWeight: " + weight + "\n" +
                "\tImage Filename: " + imageFilename + "\n";
    }


    ///
    /// Temporary Getter and Setter methods
    ///

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRarity() {
        return rarity;
    }

    public boolean isEquipable() {
        return equipable;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public String getImageFilename() {
        return imageFilename;
    }

}
