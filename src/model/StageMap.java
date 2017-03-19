package model;

import java.io.FileNotFoundException;

/**
 * Class to hold the map for each of the stages.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class StageMap {
    // Character array representative of the stage map
    private char[][] map;

    // Constant character representations of map objects
    public static final char MAP_ROAD = '|';
    public static final char MAP_EMPTY = '.';

    /**
     * Constructor for the stage map. Reads the map from a given file.
     * @param filename String representing the filename that holds the map
     */
    public StageMap(String filename){
        FileScanner scanner = new FileScanner();

        try {
            this.map = scanner.scanFile(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter method for the map.
     * @return char[][] representing the stage map
     */
    public char[][] getMap(){
        return this.map;
    }
}
