package cz.stanov.slick2048.gameobject;

import static cz.stanov.slick2048.Constants.*;

public class Board {

    private Tile[][] board;


    public Board() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
    }

    public Tile getTileAt(int x, int y) {
        return board[x][y];
    }

    public void setTileAt(int x, int y, Tile tile) {
        board[x][y] = tile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board that = (Board) o;

        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {

                if (this.board[x][y] != that.board[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int y = 0; y < BOARD_SIZE; y++) {
            result.append('\n');

            for (int x = 0; x < BOARD_SIZE; x++) {
                result.append(board[x][y].getValue());
                result.append(',');
            }
        }

        return result.toString();
    }
}
