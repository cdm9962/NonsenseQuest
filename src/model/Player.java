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
    private String playerClass;
    private int health;
    private int mana;
    private int movement;
    private long experience;
    private int level;
    private double weight;
    private Limits limits;
    private ArrayList<Item> inventory;

    // Human starting values
    public static final int HUMAN_DEFAULT_HEALTH = 100;
    public static final int HUMAN_DEFAULT_MANA = 100;
    public static final int HUMAN_DEFAULT_MOVEMENT = 5;
    public static final int HUMAN_DEFAULT_EXPERIENCE = 0;
    public static final int HUMAN_DEFAULT_LEVEL = 1;
    public static final int HUMAN_DEFAULT_WEIGHT = 80;

    /**
     * Manual Constructor for testing.
     * @param name String representing the character's name
     * @param race String representing the character's race
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
    public Player(String name, String race, String playerClass, int health, int mana, int movement, long experience,
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
        this.race = race;
        this.name = name;
        this.playerClass = playerClass;

        // Human character constructor
        if(race.equals("Human")){
            this.health = HUMAN_DEFAULT_HEALTH;
            this.mana = HUMAN_DEFAULT_MANA;
            this.movement = HUMAN_DEFAULT_MOVEMENT;
            this.experience = HUMAN_DEFAULT_EXPERIENCE;
            this.level = HUMAN_DEFAULT_LEVEL;
            this.weight = HUMAN_DEFAULT_WEIGHT;
            this.limits = new Limits(race);
            this.inventory = new ArrayList<>();
        }
    }
}
