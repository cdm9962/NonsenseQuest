package model;

/**
 * Abstract class for the map squares.
 */
public abstract class Square {
    // The private state of the map square
    private String name;
    private String description;
    private boolean isAdjacent;

    public Square(String name, String description, boolean isAdjacent){
        this.name = name;
        this.description = description;
        this.isAdjacent = isAdjacent;
    }

    public String getDescription(){
        return this.description;
    }
}
