package cz.stanov.slick2048;

import cz.stanov.slick2048.gameobject.Board;
import cz.stanov.slick2048.render.GameBoardRenderer;
import org.newdawn.slick.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import static cz.stanov.slick2048.Constants.*;
import static cz.stanov.slick2048.render.RenderConstants.*;
import static org.newdawn.slick.Input.*;

public class Main extends BasicGame {

    public static final int WINDOW_SIZE = BOARD_SIZE * TILE_SIZE_PIXELS + (BOARD_SIZE+1) * TILE_MARGIN_PIXELS;

    private Board board;
    private GameBoardManipulator gameBoardManipulator;

    private GameBoardRenderer renderer;

    public Main(String gameName) {
        super(gameName);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        renderer = new GameBoardRenderer(gc.getGraphics());
        board = new Board();

        gameBoardManipulator = new GameBoardManipulator(board);
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        renderer.render(board);
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
            case KEY_RIGHT:
                gameBoardManipulator.moveRight();
                break;
            case KEY_LEFT:
                gameBoardManipulator.moveLeft();
                break;
            case KEY_UP:
                gameBoardManipulator.moveUp();
                break;
            case KEY_DOWN:
                gameBoardManipulator.moveDown();
                break;
        }
    }

    public static void main(String[] args) {

        try {
            AppGameContainer gc;
            gc = new AppGameContainer(new Main("Slick 2D 2048 by StaNov"));
            gc.setDisplayMode(WINDOW_SIZE, WINDOW_SIZE, false);
            gc.setTargetFrameRate(100);
            gc.setShowFPS(false);
            gc.start();
        }
        catch (SlickException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}