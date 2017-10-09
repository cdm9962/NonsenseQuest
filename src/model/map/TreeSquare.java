package model.map;

/**
 * Class for the tree squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class TreeSquare extends Square {
    // Constant square values
    public static char MAPLE_TREE_SQUARE_CHARACTER = '*';
    public static char PINE_TREE_SQUARE_CHARACTER = '^';
    public static String TREE_SQUARE_NAME = "TreeSquare";
    public static String TREE_SQUARE_DESCRIPTION = "What a fine looking tree.";

    // Constant file paths
    public static String MAPLE_TREE_SQUARE_FILE = "/images/squares/mapletree.png";
    public static String PINE_TREE_SQUARE_FILE = "/images/squares/pinetree.png";

    /**
     * TreeSquare Square constructor.
     * @param row int representing the row location of the square
     * @param col int representing the column location of the square
     * @param filename String representing the image filename
     * @param containsCharacter boolean to determine if the square holds the character
     * @param containsEnemy boolean to determine if the square holds an enemy
     */
    public TreeSquare(int row, int col, String filename, boolean containsCharacter, boolean containsEnemy) {
        super(row, col, filename, TREE_SQUARE_NAME, TREE_SQUARE_DESCRIPTION, false, containsCharacter, containsEnemy, null);
    }
}
