package model.abilities;

/**
 * Abstract class to hold ability attributes.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Ability {
    // Private state of the ability
    private String name;
    private String description;

    /**
     * Ability Constructor.
     * @param name String representing the name of the ability
     * @param description String representing the effect of the ability
     */
    public Ability(String name, String description){
        this.name = name;
        this.description = description;
    }

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
