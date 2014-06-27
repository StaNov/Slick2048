package cz.stanov.slick2048.util;


import cz.stanov.slick2048.gameobject.Board;
import cz.stanov.slick2048.gameobject.Tile;

import static cz.stanov.slick2048.Constants.BOARD_SIZE;

public class GameBoardCreator {

    private static final String TILE_VALUES_SEPARATOR = ",";

    public Board create(String s) {
        Board result = new Board();

        String[] tileValues = s.split(TILE_VALUES_SEPARATOR);

        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                int tileValue = Integer.valueOf(tileValues[y*BOARD_SIZE + x]);
                result.setTileAt(x, y, new Tile(tileValue));
            }
        }

        return result;
    }
}
