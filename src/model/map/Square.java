package model.map;

/**
 * Abstract class for the map squares.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Square {
    // The private state of the map square
    private String name;
    private String description;
    private boolean isAdjacent;

    /**
     * Sqaure constructor.
     * @param name String representing the name of the square
     * @param description String representing the description of the square
     * @param isAdjacent boolean representing if the square is adjacent to the character
     */
    public Square(String name, String description, boolean isAdjacent){
        this.name = name;
        this.description = description;
        this.isAdjacent = isAdjacent;
    }

    /**
     * Getter method for the square description.
     * @return String representing the square description
     */
    public String getDescription(){
        return this.description;
    }

    public void toggleIsAdjacent(){
        this.isAdjacent = !this.isAdjacent;
    }

    public boolean getIsAdjacent(){
        return this.isAdjacent;
    }
}
