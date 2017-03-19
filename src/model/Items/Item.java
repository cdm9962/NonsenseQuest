package model.items;

/**
 * A player usable value object.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Item {
    private String name;
    private  String description;
    private String rarity;
    private boolean equipable;
    private double value;
    private double weight;

    public Item(String name, String description, String rarity, boolean equipable, double value, double weight) {
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.equipable = equipable;
        this.value = value;
        this.weight = weight;
    }

    public String getName(){
        return this.name;
    }
}
