package model;

import model.classes.PlayerClass;
import model.classes.Thief;
import model.classes.Warrior;
import model.items.Item;
import model.items.Weapon;
import model.races.Dragon;
import model.races.Human;
import model.races.Race;

import java.io.FileNotFoundException;
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
    private int power;
    private int dextarity;
    private int intellegence;
    private int speed;
    private int charisma;
    private long experience;
    private int level;
    private double weight;
    private Limits limits;
    private Item activeItem;
    private ArrayList<Item> inventory;

    /**
     * Player character constructor.
     * @param race String representing the race of the character
     * @param name String representing the name of the character
     * @param playerClass String representing the class of the character
     */
    public Player(String name, String race, String playerClass){
        this.name = name;

        /// Class constructors
        // Warrior character constructor
        if(playerClass.equals(Warrior.WARRIOR_PLAYER_CLASS)){
            this.playerClass = new Warrior();
        // Thief character constructor
        } else if(playerClass.equals(Thief.THIEF_PLAYER_CLASS)){
            this.playerClass = new Thief();
        }

        /// Race constructors
        // Human character constructor
        if(race.equals(Human.HUMAN_RACE)){
            this.race = new Human();
            this.health = Human.HUMAN_DEFAULT_HEALTH + this.playerClass.getHealthModifier();
            this.experience = Human.HUMAN_DEFAULT_EXPERIENCE;
            this.level = Human.HUMAN_DEFAULT_LEVEL;
            this.weight = Limits.DEFAULT_MIN_WEIGHT;
            this.limits = new Limits(race);
            this.power = this.playerClass.getPowerModifier();
            this.limits.setMaxHealth(Human.HUMAN_DEFAULT_HEALTH + this.playerClass.getHealthModifier());
            this.limits.setMaxMana(Human.HUMAN_DEFAULT_MANA + this.playerClass.getManaModifier());
            this.limits.setMaxMovement(Human.HUMAN_DEFAULT_MOVEMENT + this.playerClass.getMovementModifier());
            this.limits.setMaxWeight(Human.HUMAN_DEFAULT_WEIGHT + this.playerClass.getWeightModifier());
            this.inventory = new ArrayList<>();
            FileScanner scanner = new FileScanner();
            try {
                this.inventory.add(scanner.scanWeapon("/resources/entitylists/swords.txt", 1));
                this.inventory.add((scanner.scanWeapon("/resources/entitylists/swords.txt", 2)));
                this.activeItem = this.inventory.get(1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        // Dragon Character constructor
        } else if(race.equals(Dragon.DRAGON_RACE)){
            this.race = new Dragon();
            this.health = Dragon.DRAGON_DEFAULT_HEALTH + this.playerClass.getHealthModifier();
            this.experience = Dragon.DRAGON_DEFAULT_EXPERIENCE;
            this.level = Dragon.DRAGON_DEFAULT_LEVEL;
            this.weight = Limits.DEFAULT_MIN_WEIGHT;
            this.limits = new Limits(race);
            this.limits.setMaxHealth(Dragon.DRAGON_DEFAULT_HEALTH + this.playerClass.getHealthModifier());
            this.limits.setMaxMana(Dragon.DRAGON_DEFAULT_MANA + this.playerClass.getManaModifier());
            this.limits.setMaxMovement(Dragon.DRAGON_DEFAULT_MOVEMENT + this.playerClass.getMovementModifier());
            this.limits.setMaxWeight(Dragon.DRAGON_DEFAULT_WEIGHT + this.playerClass.getWeightModifier());
            this.inventory = new ArrayList<>();
        }
    }

    public String displayCharacter(){
        return "Player:\n" +
                "  name: " + name +
                "\n  race: " + race.getName() +
                "\n  class: " + playerClass.getName() +
                "\n  height: " + race.getHeight() +
                "\n  weight: " + race.getWeight() +
                "\n  health: " + health +
                "\n  experience: " + experience +
                "\n  level: " + level +
                "\n  inventory weight: " + limits.getMinWeight() +
                "\n  inventory: [" + displayInventory() + " ]";
    }

    /**
     * Method to print the inventory items.
     * @return String representing the characters inventory
     */
    public String displayInventory(){
        String result = "";
        // Loops through each item in the inventory and prints the name value
        for(int i = 0; i < inventory.size(); i++){
            result += inventory.get(i).getName();
            if(i != inventory.size() - 1){
                result += ",";
            }
        }
        return result;
    }

    /**
     * Method to do damage to the player character.
     * @param damage int representing the amount of damage the player character is going to take
     */
    public void takeDamage(int damage){
        this.health -= damage;
        if(this.health < this.limits.getMinHealth()){
            this.health = this.limits.getMinHealth();
        }
    }

    /**
     * Getter method for the character health.
     * @return int representing the players current health
     */
    public int getHealth(){
        return this.health;
    }

    /**
     * Method to calculate character damage value.
     * @return int representing the character damage value
     */
    public int calculateDamage(){
        return ((Weapon) this.activeItem).getDamage() + this.power;
    }
}