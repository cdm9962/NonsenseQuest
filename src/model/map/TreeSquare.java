package model.map;

/**
 * Class for the tree squares on the stage map.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class TreeSquare extends Square {
    // Constant square values
    public static char TREE_SQUARE_CHARACTER = '/';
    public static String TREE_SQUARE_NAME = "TreeSquare";
    public static String TREE_SQUARE_DESCRIPTION = "This area looks to be well traveled.";
    public static String TREE_SQUARE_FILE = "file:dirt";

    /**
     * TreeSquare Square constructor.
     */
    public TreeSquare() {
        super(TREE_SQUARE_FILE, TREE_SQUARE_NAME, TREE_SQUARE_DESCRIPTION, false);
    }
}
