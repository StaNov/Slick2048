package cz.stanov.slick2048.render;

import cz.stanov.slick2048.gameobject.Tile;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static cz.stanov.slick2048.render.RenderConstants.*;

public class TileRenderer {

    // TODO vyhodit jinam
    public static final Map<Integer, Color> colors = new HashMap<Integer, Color>();

    private Graphics g;
    private TrueTypeFont tileTextFont;
    private Color tileTextColor;

    public TileRenderer(Graphics g) {
        this.g = g;
        this.tileTextFont = new TrueTypeFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE), true);
        this.tileTextColor = new Color(0,0,0, TILE_TEXT_TRANSPARENCY);
    }

    public void renderTile(Tile tile, int x, int y) {
        drawBackground(tile, x, y);
        drawText(tile, x, y);
    }

    private void drawBackground(Tile tile, int x, int y) {
        g.setColor(colors.get(tile.getValue()));
        g.fillRect(x * TILE_SIZE_PIXELS + (x+1) * TILE_MARGIN_PIXELS,
                   y * TILE_SIZE_PIXELS + (y+1) * TILE_MARGIN_PIXELS,
                   TILE_SIZE_PIXELS,
                   TILE_SIZE_PIXELS);
    }

    private void drawText(Tile tile, int x, int y) {
        if (tile.isEmpty()) {
            // dont draw text of empty tile
            return;
        }

        g.setColor(tileTextColor);
        g.setFont(tileTextFont);
        drawTileValue(tile, x, y);
    }

    private void drawTileValue(Tile tile, int x, int y) {
        int valueTextWidth = g.getFont().getWidth(tile.getValue() + "");
        int valueTextHeight = g.getFont().getHeight(tile.getValue() + "");

        g.drawString(
                tile.getValue() + "",
                x* TILE_SIZE_PIXELS + (x+1)* TILE_MARGIN_PIXELS + (TILE_SIZE_PIXELS - valueTextWidth) / 2,
                y* TILE_SIZE_PIXELS + (y+1)* TILE_MARGIN_PIXELS + (TILE_SIZE_PIXELS - valueTextHeight) / 2);
    }

    static {
        colors.put(0, Color.gray);
        colors.put(2, Color.blue);
        colors.put(4, Color.green);
        colors.put(8, Color.pink);
        colors.put(16, Color.red);
        colors.put(32, Color.lightGray);
        colors.put(64, Color.cyan);
        colors.put(128, Color.magenta);
        colors.put(256, Color.orange);
        colors.put(512, Color.yellow);
        colors.put(1024, Color.white);
        colors.put(2048, Color.blue);
        colors.put(4096, Color.pink);
    }
}
