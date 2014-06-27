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
    }


    public void init() {
        fillBoardWithEmptyTiles(board);

        for (int i = 0; i < INITIAL_FILLED_TILES; i++) {
            generateNewTiles();
        }
    }

    private void fillBoardWithEmptyTiles(Board board) {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                board.setTileAt(x, y, Tile.T_EMPTY);
            }
        }
    }

    public void generateNewTiles() {
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

    public boolean moveRight() {
        boolean anyTileWasMoved = false;

        for (int x = BOARD_SIZE - 2; x >= 0; x--) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                boolean tileWasMoved = tryMoveTileFromTo(x, y, x+1, y);

                if (tileWasMoved) {
                    anyTileWasMoved = true;
                }

            }
        }

        return anyTileWasMoved;
    }

    public boolean moveLeft() {
        return false;
    }

    public boolean moveUp() {
        return false;
    }

    public boolean moveDown() {
        return false;
    }

    private boolean tryMoveTileFromTo(int fromX, int fromY, int toX, int toY) {

        if (tileIsEmpty(fromX, fromY)) {
            // dont move an empty tile
            return false;
        }

        if (toX < 0 || toY < 0 || toX >= BOARD_SIZE || toY >= BOARD_SIZE) {
            // dont move an edge tile
            return false;
        }

        Tile fromTile = board.getTileAt(fromX, fromY);
        Tile toTile = board.getTileAt(toX, toY);

        if (toTile == Tile.T_EMPTY) {
            board.setTileAt(toX,toY, fromTile);
            board.setTileAt(fromX,fromY, Tile.T_EMPTY);

        } else if (toTile == fromTile) {
            board.setTileAt(toX,toY, Tile.getByValue(toTile.getValue() * 2));
            board.setTileAt(fromX,fromY, Tile.T_EMPTY);

        } else {
            return false;
        }

        tryMoveTileFromTo(toX, toY, toX + (toX - fromX), toY + (toY - fromY));

        return true;
    }

    private boolean tileIsEmpty(int x, int y) {
        return board.getTileAt(x,y) == Tile.T_EMPTY;
    }


    private boolean tileIsInMostRightColumn(int xCoordinate) {
        return xCoordinate == BOARD_SIZE - 1;
    }
}
