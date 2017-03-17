package model;

import java.util.ArrayList;

/**
 * The player object class.  Holds all of the player data.
 *
 * @author Connor D. Milligan
 */
public class Player {
    // The private player state
    private String name;
    private String race;
    private int health;
    private int mana;
    private int movement;
    private long experience;
    private int level;
    private double weight;
    private Limits limits;
    private ArrayList<Item> inventory;

    /**
     * Manual Constructor for testing.
     * @param name String representing the character's name
     * @param race String representing the character's race
     * @param health int representing the character's current health
     * @param mana int representing the character's current mana
     * @param movement int representing the character's current movement distance
     * @param experience long representing the character's current experience
     * @param level int representing the character's current level
     * @param weight double representing the character's current carried weight
     * @param inventory  ArrayList of Item objects representing the character's inventory
     */
    public Player(String name, String race, int health, int mana, int movement, long experience, int level, double weight,
                  Limits limits, ArrayList<Item> inventory) {
        this.name = name;
        this.race = race;
        this.health = health;
        this.mana = mana;
        this.movement = movement;
        this.experience = experience;
        this.level = level;
        this.weight = weight;
        this.limits = limits;
        this.inventory = inventory;
    }

    public Player(){

    }
}
