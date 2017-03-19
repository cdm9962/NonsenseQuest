package model;

import java.io.FileNotFoundException;

/**
 * Created by Connor on 3/18/2017.
 */
public class StageMap {
    private char[][] map;

    public static final char MAP_ROAD = '|';
    public static final char MAP_EMPTY = '.';

    public StageMap(String filename){
        FileScanner scanner = new FileScanner();

        try {
            this.map = scanner.scanFile(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
