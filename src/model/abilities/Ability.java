package model.abilities;

import model.Player;

import java.util.Random;

/**
 * Abstract class to hold ability attributes.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Ability {
    // Private state of all abilities
    private String name;
    private String description;
    private Player player;
    private Player opponent;

    // Ability random number generator
    protected Random rand;

    /**
     * Ability Constructor.
     * @param name String representing the name of the ability
     * @param description String representing the effect of the ability
     */
    public Ability(String name, String description, Player player, Player opponent){
        this.name = name;
        this.description = description;
        this.player = player;
        this.opponent = opponent;
        this.rand = new Random();
    }

    /**
     * Method to resolve an abilities effects on a player and their opponent.
     */
    public void resolveAbility() {
        System.out.println("Hit: " + isHit() + "\n");
        System.out.println("Damage: " + calculateDamage() + "\n");
    }

    /**
     * Method to check if an ability hits.
     * @return boolean to determine if the ability hits
     */
    public abstract boolean isHit();

    /**
     * Method to calculate the ability damage.
     * @return int representing the ability's damage
     */
    public abstract int calculateDamage();

    /**
     * Getter method for the ability name.
     * @return String representing the name of the ability
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the ability description.
     * @return String representing the description of the ability
     */
    public String getDescription() {
        return description;
    }
}