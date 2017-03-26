package model.map;

import model.FileScanner;

import java.io.FileNotFoundException;

/**
 * Class to hold the map for each of the stages.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class StageMap {
    // Character array representative of the stage map
    private Square[][] map;
    private int rows;
    private int cols;
    private Square characterSquare;

    /**
     * Constructor for the stage map. Reads the map from a given file.
     * @param filename String representing the filename that holds the map
     */
    public StageMap(String filename){
        FileScanner scanner = new FileScanner();

        try {
            this.map = scanner.scanMap(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.rows = scanner.getRows();
        this.cols = scanner.getCols();
    }

    /**
     * Getter method for the map.
     * @return char[][] representing the stage map
     */
    public Square[][] getMap(){
        return this.map;
    }

    /**
     * Getter method for the number of rows in the map.
     * @return int representing the number of rows in the map
     */
    public int getRows(){
        return this.rows;
    }

    /**
     * Getter method for the number of columns in the map.
     * @return int representing the number of columns in the map
     */
    public int getCols(){
        return this.cols;
    }

    /**
     * Method to get the character at a specific location on the map. Uses zero based indexing.
     * @param row int representing the desired row
     * @param col int representing the desired column
     * @return char representing the desired character
     */
    public Square getLocation(int row, int col){
        return this.map[row][col];
    }

    public void setCharacterSquare(Square characterSquare){
        this.characterSquare = characterSquare;
    }

    public Square getCharacterSquare(){
        return this.characterSquare;
    }
}
