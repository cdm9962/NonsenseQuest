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
        InputStream stream = new FileInputStream(filename);
        Scanner scanner = new Scanner(stream);
        String curr = "";
        scanner.nextLine();
        int rows = Integer.parseInt(scanner.next());
        int cols = Integer.parseInt(scanner.next());
        int row = 0;
        int col = 0;
        char[][] map = new char[rows][cols];

        while (scanner.hasNext()){
            curr = scanner.next();
            map[row][col] = curr.charAt(0);
            col++;
            if(col > cols - 1){
                col = 0;
                row++;
            }
        }

        return map;
    }


}
