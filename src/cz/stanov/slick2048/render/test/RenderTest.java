package cz.stanov.slick2048.render.test;

import cz.stanov.slick2048.Main;
import cz.stanov.slick2048.gameobject.Board;
import cz.stanov.slick2048.gameobject.Tile;
import cz.stanov.slick2048.render.GameBoardRenderer;
import org.newdawn.slick.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static cz.stanov.slick2048.Main.*;

public class RenderTest extends BasicGame {

    private GameBoardRenderer renderer;

    public RenderTest(String gameName) {
        super(gameName);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        Board board = new Board();
        renderer = new GameBoardRenderer(gc.getGraphics(), board);

        board.setTileAt(0,0, new Tile(2));
        board.setTileAt(0,1, new Tile(4));
        board.setTileAt(0,2, new Tile(8));
        board.setTileAt(0,3, new Tile(16));
        board.setTileAt(1,0, new Tile(32));
        board.setTileAt(1,1, new Tile(64));
        board.setTileAt(1,2, new Tile(128));
        board.setTileAt(1,3, new Tile(256));
        board.setTileAt(2,0, new Tile(512));
        board.setTileAt(2,1, new Tile(1024));
        board.setTileAt(2,2, new Tile(2048));
        board.setTileAt(2,3, new Tile(4096));
        board.setTileAt(3,0, new Tile(0));
        board.setTileAt(3,1, new Tile(0));
        board.setTileAt(3,2, new Tile(0));
        board.setTileAt(3,3, new Tile(0));

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        renderer.render();
    }

    public static void main(String[] args) {

        try {
            AppGameContainer gc;
            gc = new AppGameContainer(new RenderTest("Render Test"));
            gc.setDisplayMode(Main.WINDOW_SIZE, WINDOW_SIZE, false);
            gc.setTargetFrameRate(100);
            gc.setShowFPS(false);
            gc.start();
        }
        catch (SlickException ex) {
            Logger.getLogger(RenderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}