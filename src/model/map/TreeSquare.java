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

    public static String MAPLE_TREE_SQUARE_FILE = "file:mapletree.png";
    public static String PINE_TREE_SQUARE_FILE = "file:pinetree.png";

    /**
     * TreeSquare Square constructor.
     */
    public TreeSquare(String filename, boolean containsCharacter) {
        super(filename, TREE_SQUARE_NAME, TREE_SQUARE_DESCRIPTION, false, containsCharacter, null);
    }
}
