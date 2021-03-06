package model;

import model.items.Sword;
import model.items.Weapon;
import model.map.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
            try {
                if (curr.charAt(0) == Square.CHARACTER_SQUARE_CHARACTER) {
                    map[row][col] = addSquare(row, col, curr.charAt(1), true, false);
                } else if (curr.charAt(0) == Square.ENEMY_SQUARE_CHARACTER) {
                    map[row][col] = addSquare(row, col, curr.charAt(1), false, true);
                } else {
                    map[row][col] = addSquare(row, col, curr.charAt(0), false, false);
                }

            // Catches invalid characters in the map file
            } catch (IOException e) {
                e.printStackTrace();
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
     * @param row int representing the row to place the square
     * @param col int representing the column to place the square
     * @param label char representing the type of square
     * @param isCharacterSquare boolean representing if the character is located on the square
     * @param isEnemySquare boolean representing if an enemy is located on the square
     * @return Square representing the square to add to the stage map
     */
    public Square addSquare(int row, int col, char label, boolean isCharacterSquare, boolean isEnemySquare) throws IOException {
        // Run through the character set and create the corresponding square
        switch (label) {
            case DirtPathSquare.VERTICAL_DIRT_PATH_SQUARE_CHARACTER:
                return new DirtPathSquare(row, col, DirtPathSquare.VERTICAL_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);

            case DirtPathSquare.HORIZONTAL_DIRT_PATH_SQUARE_CHARACTER:
                return new DirtPathSquare(row, col, DirtPathSquare.HORIZONTAL_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);

            case DirtPathSquare.TOP_LEFT_DIRT_PATH_SQUARE_CHARACTER:
                return new DirtPathSquare(row, col, DirtPathSquare.TOP_LEFT_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);

            case DirtPathSquare.TOP_RIGHT_DIRT_PATH_SQUARE_CHARACTER:
                return new DirtPathSquare(row, col, DirtPathSquare.TOP_RIGHT_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);

            case DirtPathSquare.BOTTOM_LEFT_DIRT_PATH_SQUARE_CHARACTER:
                return new DirtPathSquare(row, col, DirtPathSquare.BOTTOM_LEFT_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);

            case DirtPathSquare.BOTTOM_RIGHT_DIRT_PATH_SQUARE_CHARACTER:
                return new DirtPathSquare(row, col, DirtPathSquare.BOTTOM_RIGHT_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);

            case DirtPathSquare.INTERSECTION_DIRT_PATH_SQUARE_CHARACTER:
                return new DirtPathSquare(row, col, DirtPathSquare.INTERSECTION_DIRT_PATH_FILE, isCharacterSquare, isEnemySquare);

            case GrassSquare.GRASS_SQUARE_CHARACTER:
                return new GrassSquare(row, col, isCharacterSquare, isEnemySquare);

            case DirtSquare.DIRT_SQUARE_CHARACTER:
                return new DirtSquare(row, col, isCharacterSquare, isEnemySquare);

            case TreeSquare.MAPLE_TREE_SQUARE_CHARACTER:
                return new TreeSquare(row, col, TreeSquare.MAPLE_TREE_SQUARE_FILE,isCharacterSquare, isEnemySquare);

            case TreeSquare.PINE_TREE_SQUARE_CHARACTER:
                return new TreeSquare(row, col, TreeSquare.PINE_TREE_SQUARE_FILE, isCharacterSquare, isEnemySquare);

            // Error, character not recognized
            default:
                throw new IOException("Failed to read map from file.");
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
//        URL urlToDictionary = this.getClass().getResource("/" + "Dictionary.txt");
//        InputStream stream = urlToDictionary.openStream();
        this.scanner = new Scanner(stream);

        // Run through the rows in the file until it reaches the proper row
        for(int i = 0; i < row; i++){
            scanner.nextLine();
            // Creates the sword object when it reaches the proper line
            if(i == row - 1){
                Weapon sword = addWeapon();
                // Closes the file and returns the sword object
                scanner.close();
                return sword;
            }
        }

        // Error sword not found
        return null;
    }

    /**
     * Method to create a weapon.
     * @return Weapon representing the newly created weapon.
     */
    public Weapon addWeapon() {
        String name = getString();
        if(name.equals("Rusty Sword")) {
            return new Sword(name, getString(), getString(), getInt(), getDouble(), getDouble(), Sword.RUSTY_SWORD_FILE, Sword.SWORDTYPE.RUSTY);
        } else if(name.equals("Iron Sword")) {
            return new Sword(name, getString(), getString(), getInt(), getDouble(), getDouble(), Sword.IRON_SWORD_FILE, Sword.SWORDTYPE.IRON);
        } else if(name.equals("Masterwork Sword")) {
            return new Sword(name, getString(), getString(), getInt(), getDouble(), getDouble(), Sword.MASTERWORK_SWORD_FILE, Sword.SWORDTYPE.MASTERWORK);
        } else if(name.equals("Spiked Sword")) {
            return new Sword(name, getString(), getString(), getInt(), getDouble(), getDouble(), Sword.SPIKED_SWORD_FILE, Sword.SWORDTYPE.SPIKED);
        } else if(name.equals("God Sword")) {
            return new Sword(name, getString(), getString(), getInt(), getDouble(), getDouble(), Sword.GOD_SWORD_FILE, Sword.SWORDTYPE.GOD);
        } else {
            return null;
        }
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
                if(string.length() > 0) {
                    string += " ";
                }
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