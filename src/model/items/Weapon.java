package model.items;

/**
 * Abstract class for weapon items.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Weapon extends Item{
    private int damage;

    public Weapon(String name, String description, int damage, String rarity, boolean equipable, double value, double weight){
        super(name, description, rarity, equipable, value, weight);
        this.damage = damage;
    }
}