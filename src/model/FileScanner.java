package model;

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
    public char[][] scanFile(String filename) throws FileNotFoundException {
        // Creates the scanner object
        InputStream stream = new FileInputStream(filename);
        Scanner scanner = new Scanner(stream);

        // Variables for file reading
        String curr;
        scanner.nextLine();
        int rows = Integer.parseInt(scanner.next());
        int cols = Integer.parseInt(scanner.next());
        int row = 0;
        int col = 0;
        char[][] map = new char[rows][cols];

        // Scans through each character in the file and adds them to the map
        while (scanner.hasNext()){
            curr = scanner.next();
            map[row][col] = curr.charAt(0);
            col++;
            // Updates column and row position
            if(col > cols - 1){
                col = 0;
                row++;
            }
        }

        // Closes the file and returns the map
        scanner.close();
        return map;
    }


}
