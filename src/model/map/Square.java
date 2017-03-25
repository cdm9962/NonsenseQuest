package model.map;

/**
 * Abstract class for the map squares.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Square {
    // The private state of the map square
    private String filename;
    private String name;
    private String description;
    private boolean isAdjacent;
    private boolean containsCharacter;
    private Character enemy;

    public static char CHARACTER_SQUARE_CHARACTER = 'C';
    public static String CHARACTER_SQUARE_NAME = "Character";
    public static String CHARACTER_SQUARE_DESCRIPTION = "This is you.";

    /**
     * Sqaure constructor.
     * @param filename String representing the image filename for the square
     * @param name String representing the name of the square
     * @param description String representing the description of the square
     * @param isAdjacent boolean representing if the square is adjacent to the character
     */
    public Square(String filename, String name, String description, boolean isAdjacent, boolean containsCharacter, Character enemy){
        this.filename = filename;
        this.name = name;
        this.description = description;
        this.isAdjacent = isAdjacent;
        this.containsCharacter = containsCharacter;
        this.enemy = enemy;
    }

    /**
     * Getter method for the square description.
     * @return String representing the square description
     */
    public String getDescription(){
        if(this.isAdjacent){
            return "You can move to this square.";
        } else if (this.containsCharacter) {
            return "You are here.";
        } else {
            return this.description;
        }
    }

    public void toggleIsAdjacent(){
        this.isAdjacent = !this.isAdjacent;
    }

    public boolean getIsAdjacent(){
        return this.isAdjacent;
    }

    public String getFilename(){
        return this.filename;
    }

    public boolean containsEnemy(){
        return this.enemy != null;
    }

    public boolean isContainsCharacter(){
        return this.containsCharacter;
    }
    public void togleContainsCharacter(){
        this.containsCharacter = !this.containsCharacter;
    }
}
