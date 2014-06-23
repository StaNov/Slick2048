package cz.stanov.slick2048;


import cz.stanov.slick2048.gameobject.Board;
import cz.stanov.slick2048.gameobject.Tile;

import java.util.Random;

import static cz.stanov.slick2048.Constants.BOARD_SIZE;
import static cz.stanov.slick2048.Constants.INITIAL_FILLED_TILES;

public class GameBoardManipulator {

    private Board board;
    private Random random;

    public GameBoardManipulator(Board board) {
        this.board = board;
        this.random = new Random();

        fillBoardWithEmptyTiles(board);

        for (int i = 0; i < INITIAL_FILLED_TILES; i++) {
            generateNewTile();
        }
    }


    private void fillBoardWithEmptyTiles(Board board) {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                board.setTileAt(x,y, Tile.T_EMPTY);
            }
        }
    }

    public void moveRight() {
        for (int x = BOARD_SIZE - 2; x >= 0; x--) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (tileIsEmpty(x, y)) {
                    // dont move an empty tile
                    continue;
                }

                moveTileRightAsFarAsPossible(x,y);
            }
        }

        generateNewTile(); // TODO nějak udělat, aby se v testech negenerovalo nové
    }

    private boolean tileIsEmpty(int x, int y) {
        return board.getTileAt(x,y) == Tile.T_EMPTY;
    }

    private void moveTileRightAsFarAsPossible(int x, int y) {
        if (tileIsInMostRightColumn(x)) {
            return;
        }

        Tile thisTile = board.getTileAt(x, y);
        Tile rightNeighbor = board.getTileAt(x + 1, y);

        if (rightNeighbor == Tile.T_EMPTY) {
            board.setTileAt(x+1,y, thisTile);
            board.setTileAt(x,y, Tile.T_EMPTY);
            moveTileRightAsFarAsPossible(x+1,y);

        } else if (rightNeighbor == thisTile) {
            board.setTileAt(x+1,y, Tile.getByValue(rightNeighbor.getValue() * 2));
            board.setTileAt(x,y, Tile.T_EMPTY);
        }

    }

    private boolean tileIsInMostRightColumn(int xCoordinate) {
        return xCoordinate == BOARD_SIZE - 1;
    }

    public void moveLeft() {

    }

    public void moveUp() {

    }

    public void moveDown() {

    }

    private void generateNewTile() {
        while (true) {
            int x = random.nextInt(BOARD_SIZE);
            int y = random.nextInt(BOARD_SIZE);

            if (tileIsEmpty(x, y)) {
                board.setTileAt(x,y, Tile.T_2);
                break;
                // TODO přepsat bez breaku
            }
        }
    }
}
