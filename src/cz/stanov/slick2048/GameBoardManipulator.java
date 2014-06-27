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
                board.setTileAt(x, y, Tile.emptyTile());
            }
        }
    }

    public void generateNewTiles() {
        while (true) {
            int x = random.nextInt(BOARD_SIZE);
            int y = random.nextInt(BOARD_SIZE);

            if (tileIsEmpty(x, y)) {
                board.setTileAt(x,y, new Tile());
                break;
                // TODO přepsat bez breaku
            }
        }
    }

    public void markAllTilesAsNotMerged() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                board.getTileAt(x,y).setAlreadyMerged(false);
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
        boolean anyTileWasMoved = false;

        for (int x = 1; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                boolean tileWasMoved = tryMoveTileFromTo(x, y, x-1, y);

                if (tileWasMoved) {
                    anyTileWasMoved = true;
                }

            }
        }

        return anyTileWasMoved;
    }

    public boolean moveUp() {
        boolean anyTileWasMoved = false;

        for (int y = 1; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                boolean tileWasMoved = tryMoveTileFromTo(x, y, x, y-1);

                if (tileWasMoved) {
                    anyTileWasMoved = true;
                }

            }
        }

        return anyTileWasMoved;
    }

    public boolean moveDown() {
        boolean anyTileWasMoved = false;

        for (int y = BOARD_SIZE - 2; y >= 0; y--) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                boolean tileWasMoved = tryMoveTileFromTo(x, y, x, y+1);

                if (tileWasMoved) {
                    anyTileWasMoved = true;
                }

            }
        }

        return anyTileWasMoved;
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

        if (toTile.isEmpty()) {
            board.setTileAt(toX,toY, fromTile);
            board.setTileAt(fromX,fromY, Tile.emptyTile());
            tryMoveTileFromTo(toX, toY, toX + (toX - fromX), toY + (toY - fromY));

        } else if (toTile.equals(fromTile) && ! toTile.isAlreadyMerged()) {
            Tile mergedTile = new Tile(toTile.getValue() * 2);
            mergedTile.setAlreadyMerged(true);
            board.setTileAt(toX,toY, mergedTile);
            board.setTileAt(fromX,fromY, Tile.emptyTile());

        } else {
            return false;
        }

        return true;
    }


    private boolean tileIsEmpty(int x, int y) {
        return board.getTileAt(x,y).isEmpty();
    }

    private boolean tileIsInMostRightColumn(int xCoordinate) {
        return xCoordinate == BOARD_SIZE - 1;
    }
}
