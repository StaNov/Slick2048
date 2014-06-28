package cz.stanov.slick2048.render;


import cz.stanov.slick2048.gameobject.Board;
import cz.stanov.slick2048.gameobject.Tile;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import static cz.stanov.slick2048.Constants.*;

// TODO rozdělit na GameBoardGraphics a jejich renderera, udělat tam metodu isMoving, která bude říkat, jesi už přesuny proběhly
public class GameBoardRenderer {

    private TileRenderer tileRenderer;
    private Graphics g;

    private Board board;

    public GameBoardRenderer(Graphics graphics, Board board) {
        this.tileRenderer = new TileRenderer(graphics);
        this.board = board;
        this.g = graphics;
    }


    public void render() {
        drawBackground();
        drawTiles();
    }

    private void drawBackground() {
        g.setBackground(Color.darkGray);
    }

    private void drawTiles() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                Tile tileToRender = board.getTileAt(x, y);
                tileRenderer.renderTile(tileToRender, x, y);
            }
        }
    }
}
