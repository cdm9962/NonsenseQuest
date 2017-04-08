package model;

import model.items.Weapon;
import model.map.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * File scanner class. Scans through map text files.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public class FileScanner {
    // The scanner object
    private Scanner scanner;
    private int rows;
    private int cols;

    /**
     * Constructor fot the file scanner
     */
    public FileScanner() {
       this.scanner = null;
    }

    /**
     * File scanner method.
     * @return char[][] representing a map the scanned text
     * @throws FileNotFoundException
     */
    public Square[][] scanMap(String filename) throws FileNotFoundException {
        // Creates the scanner object
        InputStream stream = new FileInputStream(getClass().getResource(filename).getFile());
        this.scanner = new Scanner(stream);

        // Variables for file reading
        String curr;
        scanner.nextLine();
        this.rows = Integer.parseInt(scanner.next());
        this.cols = Integer.parseInt(scanner.next());
        int row = 0;
        int col = 0;
        Square[][] map = new Square[this.rows][this.cols];

        // Scans through each character in the file and adds them to the map
        while (scanner.hasNext()){
            curr = scanner.next();
            if(curr.charAt(0) == Square.CHARACTER_SQUARE_CHARACTER) {
                map[row][col] = addSquare(row, col, curr.charAt(1), true, false);
            } else if(curr.charAt(0) == Square.ENEMY_SQUARE_CHARACTER){
                map[row][col] = addSquare(row, col, curr.charAt(1), false, true);
            } else {
                map[row][col] = addSquare(row, col, curr.charAt(0), false, false);
            }
            col++;
            // Updates column and row position
            if(col > this.cols - 1){
                col = 0;
                row++;
            }
        }

        // Closes the file and returns the map
        scanner.close();
        return map;
    }

    /**
     * Method to determine the type of square to add to the stage map.
     * @param label char representing the type of square
     * @param isCharacterSquare boolean representing if the character is located on the square
     * @return Square representing the square to add to the stage map
     */
    public Square addSquare(int row, int col, char label, boolean isCharacterSquare, boolean isEnemySquare) {
        if(label == DirtPathSquare.VERTICAL_DIRT_PATH_SQUARE_CHARACTER) {
            return new DirtPathSquare(row, col, DirtPathSquare.VERTICAL_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);
        } else if(label == DirtPathSquare.HORIZONTAL_DIRT_PATH_SQUARE_CHARACTER) {
                return new DirtPathSquare(row, col, DirtPathSquare.HORIZONTAL_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);
        } else if(label == DirtPathSquare.TOP_LEFT_DIRT_PATH_SQUARE_CHARACTER) {
            return new DirtPathSquare(row, col, DirtPathSquare.TOP_LEFT_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);
        } else if(label == DirtPathSquare.TOP_RIGHT_DIRT_PATH_SQUARE_CHARACTER) {
            return new DirtPathSquare(row, col, DirtPathSquare.TOP_RIGHT_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);
        } else if(label == DirtPathSquare.BOTTOM_RIGHT_DIRT_PATH_SQUARE_CHARACTER) {
            return new DirtPathSquare(row, col, DirtPathSquare.BOTTOM_RIGHT_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);
        } else if(label == DirtPathSquare.BOTTOM_LEFT_DIRT_PATH_SQUARE_CHARACTER) {
            return new DirtPathSquare(row, col, DirtPathSquare.BOTTOM_LEFT_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);
        } else if(label == DirtPathSquare.INTERSECTION_DIRT_PATH_SQUARE_CHARACTER){
            return new DirtPathSquare(row, col, DirtPathSquare.INTERSECTION_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);
        } else if(label == GrassSquare.GRASS_SQUARE_CHARACTER) {
            return new GrassSquare(row, col, isCharacterSquare, isEnemySquare);
        } else if(label == DirtSquare.DIRT_SQUARE_CHARACTER) {
            return new DirtSquare(row, col, isCharacterSquare, isEnemySquare);
        } else if(label == TreeSquare.MAPLE_TREE_SQUARE_CHARACTER) {
            return new TreeSquare(row, col, TreeSquare.MAPLE_TREE_SQUARE_FILE,isCharacterSquare, isEnemySquare);
        } else if(label == TreeSquare.PINE_TREE_SQUARE_CHARACTER){
            return new TreeSquare(row, col, TreeSquare.PINE_TREE_SQUARE_FILE, isCharacterSquare, isEnemySquare);
        } else {
            return null;
        }
    }

    /**
     * Method to scan in a sword weapon from a text file.
     * @param filename String representing the file name to pull the sword from
     * @param row int representing the row to pull the sword from
     * @return Sword object representing the scanned in sword
     * @throws FileNotFoundException
     */
    public Weapon scanWeapon(String filename, int row) throws FileNotFoundException {
        // Creates the scanner object
        InputStream stream = new FileInputStream(getClass().getResource(filename).getFile());
        this.scanner = new Scanner(stream);

        // Run through the rows in the file until it reaches the proper row
        for(int i = 0; i < row; i++){
            scanner.nextLine();
            // Creates the sword object when it reaches the proper line
            if(i == row - 1){
                Weapon sword = new Weapon(getString(), getString(), getString(), getInt(), getDouble(), getDouble(), Weapon.TYPE.SWORD);
                // Closes the file and returns the sword object
                scanner.close();
                return sword;
            }
        }

        // Error sword not found
        return null;
    }

    /**
     * Method to pull a string from an item list.
     * @return String representing the desired text
     */
    public String getString(){
        String string = "";
        // Loops through and concatenates the string until it reaches the stop character
        while (true){
            String temp = this.scanner.next();
            if(temp.equals("|")){
                break;
            } else {
                string += " ";
                string += temp;
            }
        }
        return string;
    }

    /**
     * Method to pull an integer from an item list.
     * @return int representing the desired value
     */
    public int getInt(){
        int result = this.scanner.nextInt();
        this.scanner.next();
        return result;
    }

    /**
     * Method to pull a double from an item list.
     * @return double representing the desired value
     */
    public double getDouble(){
        double result = scanner.nextDouble();
        this.scanner.next();
        return result;
    }

    /**
     * Getter method for the number of rows in the map.
     * @return int representing the number of rows in the map
     */
    public int getRows() {
        return rows;
    }

    /**
     * Getter method for the number of columns in the map.
     * @return int representing the number of columns in the map
     */
    public int getCols() {
        return cols;
    }
}
