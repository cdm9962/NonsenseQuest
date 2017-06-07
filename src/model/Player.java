package model;

import model.abilities.Ability;
import model.abilities.AbilityController;
import model.abilities.DamageAbility;
import model.abilities.QuickAttack;
import model.classes.PlayerClass;
import model.classes.Thief;
import model.classes.Warrior;
import model.items.Item;
import model.items.Sword;
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
    private int dexterity;
    private int intelligence;
    private int speed;
    private int charisma;
    private long experience;
    private int level;
    private double weight;
    private Limits limits;
    private Item activeItemLeft;
    private Item activeItemRight;
    private ArrayList<Ability> abilities;
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
            this.power = Human.HUMAN_DEFAULT_POWER + this.playerClass.getPowerModifier();
            this.dexterity = Human.HUMAN_DEFAULT_DEXTERITY + this.playerClass.getDexterityModifier();
            this.intelligence = Human.HUMAN_DEFAULT_INTELLIGENCE + this.playerClass.getintelligenceModifier();
            this.speed = Human.HUMAN_DEFAULT_SPEED + this.playerClass.getSpeedModifier();
            this.charisma = Human.HUMAN_DEFAULT_CHARISMA + this.playerClass.getCharismaModifier();
            this.experience = Human.HUMAN_DEFAULT_EXPERIENCE;
            this.level = Human.HUMAN_DEFAULT_LEVEL;
            this.weight = Limits.DEFAULT_MIN_WEIGHT;
            this.limits = new Limits(race);
            this.power = this.playerClass.getPowerModifier();
            this.limits.setMaxHealth(Human.HUMAN_DEFAULT_HEALTH + this.playerClass.getHealthModifier());
            this.limits.setMaxWeight(Human.HUMAN_DEFAULT_WEIGHT + this.playerClass.getWeightModifier());
            this.abilities = new ArrayList<>();
            this.abilities.add(new QuickAttack());
            this.inventory = new ArrayList<>();
            // Add starting items
            FileScanner scanner = new FileScanner();
            try {
                this.inventory.add(scanner.scanWeapon(Sword.SWORD_FILE, 1));
                this.inventory.add((scanner.scanWeapon(Sword.SWORD_FILE, 2)));
                this.inventory.add((scanner.scanWeapon(Sword.SWORD_FILE, 3)));
                this.inventory.add((scanner.scanWeapon(Sword.SWORD_FILE, 4)));
                this.inventory.add((scanner.scanWeapon(Sword.SWORD_FILE, 5)));
                this.activeItemLeft = this.inventory.get(0);
                this.activeItemRight = this.inventory.get(1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        // Dragon Character constructor
        } else if(race.equals(Dragon.DRAGON_RACE)){
            this.race = new Dragon();
            this.health = Dragon.DRAGON_DEFAULT_HEALTH + this.playerClass.getHealthModifier();
            this.power = Dragon.DRAGON_DEFAULT_POWER + this.playerClass.getPowerModifier();
            this.dexterity = Dragon.DRAGON_DEFAULT_DEXTERITY + this.playerClass.getDexterityModifier();
            this.intelligence = Dragon.DRAGON_DEFAULT_INTELLIGENCE + this.playerClass.getintelligenceModifier();
            this.speed = Dragon.DRAGON_DEFAULT_SPEED + this.playerClass.getSpeedModifier();
            this.charisma = Dragon.DRAGON_DEFAULT_CHARISMA + this.playerClass.getCharismaModifier();
            this.experience = Dragon.DRAGON_DEFAULT_EXPERIENCE;
            this.level = Dragon.DRAGON_DEFAULT_LEVEL;
            this.weight = Limits.DEFAULT_MIN_WEIGHT;
            this.limits = new Limits(race);
            this.limits.setMaxHealth(Dragon.DRAGON_DEFAULT_HEALTH + this.playerClass.getHealthModifier());
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
                "\n  power: " + power +
                "\n  dexterity: " + dexterity +
                "\n  intelligence: " + intelligence +
                "\n  speed: " + speed +
                "\n  charisma: " + charisma +
                "\n  experience: " + experience +
                "\n  level: " + level +
                "\n  inventory weight: " + limits.getMinWeight() +
                "\n  inventory: [ " + displayInventory() + " ]";
    }

    /**
     * Method to print the inventory items.
     * @return String representing the characters inventory
     */
    public String displayInventory(){
//        String result = "";
//        // Loops through each item in the inventory and prints the name value
//        for(int i = 0; i < inventory.size(); i++){
//            result += inventory.get(i).getName();
//            if(i != inventory.size() - 1){
//                result += ", ";
//            }
//        }
//        return result;
        return String.valueOf(inventory.size());
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
    public int resolveAbility(Ability ability) {
        return new AbilityController(this).resolveAbility(ability);
    }

    /**
     * Method to check if the player attacks first.
     * @param player Player object to compare the speed value with
     * @return boolean to determine if the character is faster
     */
    public boolean isFaster(Player player){
        return this.speed > player.speed;
    }

    public Item getActiveItemLeft() {
        return activeItemLeft;
    }

    public void setActiveItemLeft(Item activeItemLeft) {
        this.activeItemLeft = activeItemLeft;
    }

    public Item getActiveItemRight() {
        return activeItemRight;
    }

    public void setActiveItemRight(Item activeItemRight) {
        this.activeItemRight = activeItemRight;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }
}