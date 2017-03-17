package model;

import java.util.ArrayList;

/**
 * The player object class.  Holds all of the player data.
 *
 * @author Connor D. Milligan
 */
public class Player {
    private String name;
    private String race;
    private int health;
    private int mana;
    private int movement;
    private int level;
    private int weight;
    private Limits limits;
    private ArrayList<Item> inventory;

    /**
     * Manual Constructor for testing.
     * @param name String representing the characters name
     * @param race String representing the characters race
     * @param health int representing the characters current health
     * @param mana int representing the characters current mana
     * @param movement int representing the characters current movement distance
     * @param level
     * @param weight
     * @param inventory
     */
    public Player(String name, String race, int health, int mana, int movement, int level, int weight, Limits limits,
                  ArrayList<Item> inventory) {
        this.name = name;
        this.race = race;
        this.health = health;
        this.mana = mana;
        this.movement = movement;
        this.level = level;
        this.weight = weight;
        this.limits = limits;
        this.inventory = inventory;
    }

    public Player(){

    }
}
