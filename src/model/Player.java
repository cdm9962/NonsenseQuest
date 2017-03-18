package model;

import java.util.ArrayList;

/**
 * The player object class.  Holds all of the player data.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class Player {
    // The private player state
    private String name;
    private Race race;
    private PlayerClass playerClass;
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
     * @param playerClass PlayerClass object representing the character's class
     * @param health int representing the character's current health
     * @param mana int representing the character's current mana
     * @param movement int representing the character's current movement distance
     * @param experience long representing the character's current experience
     * @param level int representing the character's current level
     * @param weight double representing the character's current carried weight
     * @param limits Limits object representing various maximum and minimum character values
     * @param inventory  ArrayList of Item objects representing the character's inventory
     */
    public Player(String name, Race race, PlayerClass playerClass, int health, int mana, int movement, long experience,
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
    public Player(String name, String race, String playerClass){
        this.name = name;

        // Warrior character constructor
        if(playerClass.equals(Warrior.WARRIOR_PLAYER_CLASS)){
            this.playerClass = new Warrior();
        }

        // Human character constructor
        if(race.equals("Human")){
            this.race = new Human();
            this.health = Human.HUMAN_DEFAULT_HEALTH + this.playerClass.getHealthModifier();
            this.mana = Human.HUMAN_DEFAULT_MANA + this.playerClass.getManaModifier();
            this.movement = Human.HUMAN_DEFAULT_MOVEMENT + this.playerClass.getMovementModifier();
            this.experience = Human.HUMAN_DEFAULT_EXPERIENCE;
            this.level = Human.HUMAN_DEFAULT_LEVEL;
            this.weight = Limits.DEFAULT_MIN_WEIGHT;
            this.limits = new Limits(race);
            this.limits.setMaxHealth(Human.HUMAN_DEFAULT_HEALTH + this.playerClass.getHealthModifier());
            this.limits.setMaxMana(Human.HUMAN_DEFAULT_MANA + this.playerClass.getManaModifier());
            this.limits.setMaxMovement(Human.HUMAN_DEFAULT_MOVEMENT + this.playerClass.getMovementModifier());
            this.limits.setMaxWeight(Human.HUMAN_DEFAULT_WEIGHT + this.playerClass.getWeightModifier());
            this.inventory = new ArrayList<>();
        }
    }

    public String displayCharacter(){
        return "Player:\n" +
                " name: '" + name + '\'' +
                "\n race: " + race.getName() +
                "\n height: " + race.getHeight() +
                "\n weight: " + race.getWeight() +
                "\n playerClass: " + playerClass.getName() +
                "\n health: " + health +
                "\n mana: " + mana +
                "\n movement: " + movement +
                "\n experience: " + experience +
                "\n level: " + level +
                "\n weight: " + limits.getMaxWeight() +
                "\n inventory: " + inventory;
    }

    @Override
    public String toString() {
        return "Player:\n" +
                " name: '" + name + '\'' +
                "\n race: " + race.toString() +
                "\n playerClass: " + playerClass.toString() +
                "\n health: " + health +
                "\n mana: " + mana +
                "\n movement: " + movement +
                "\n experience: " + experience +
                "\n level: " + level +
                "\n weight: " + weight +
                "\n limits: " + limits.toString() +
                "\n inventory: " + inventory;
    }
}
