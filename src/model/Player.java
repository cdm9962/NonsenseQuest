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
    private Race race;
    private String playerClass;
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
     * @param race Race object representing the character's race
     * @param playerClass String representing the character's class
     * @param health int representing the character's current health
     * @param mana int representing the character's current mana
     * @param movement int representing the character's current movement distance
     * @param experience long representing the character's current experience
     * @param level int representing the character's current level
     * @param weight double representing the character's current carried weight
     * @param limits Limits object representing various maximum and minimum character values
     * @param inventory  ArrayList of Item objects representing the character's inventory
     */
    public Player(String name, Race race, String playerClass, int health, int mana, int movement, long experience,
                  int level, double weight, Limits limits, ArrayList<Item> inventory) {
        this.name = name;
        this.race = race;
        this.playerClass = playerClass;
        this.health = health;
        this.mana = mana;
        this.movement = movement;
        this.experience = experience;
        this.level = level;
        this.weight = weight;
        this.limits = limits;
        this.inventory = inventory;
    }

    /**
     * Player character constructor.
     * @param race String representing the race of the character
     * @param name String representing the name of the character
     * @param playerClass String representing the class of the character
     */
    public Player(String race, String name, String playerClass){
        this.name = name;
        this.playerClass = playerClass;

        // Human character constructor
        if(race.equals("Human")){
            this.race = new Human();
            this.health = Human.HUMAN_DEFAULT_HEALTH;
            this.mana = Human.HUMAN_DEFAULT_MANA;
            this.movement = Human.HUMAN_DEFAULT_MOVEMENT;
            this.experience = Human.HUMAN_DEFAULT_EXPERIENCE;
            this.level = Human.HUMAN_DEFAULT_LEVEL;
            this.weight = Human.HUMAN_DEFAULT_WEIGHT;
            this.limits = new Limits(race);
            this.inventory = new ArrayList<>();
        }
    }
}
