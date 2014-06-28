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

    private TileRenderPropertiesGetter propertiesGetter;
    private FontGetter fontGetter;

    private Graphics g;
    private Color tileTextColor;

    public TileRenderer(Graphics g) {
        this.g = g;
        this.tileTextColor = new Color(0,0,0, TILE_TEXT_TRANSPARENCY);
        this.propertiesGetter = new TileRenderPropertiesGetter();
        this.fontGetter = new FontGetter();
    }

    public void renderTile(Tile tile, int x, int y) {
        drawBackground(tile, x, y);
        drawText(tile, x, y);
    }

    private void drawBackground(Tile tile, int x, int y) {
        g.setColor(backgroundColor(tile));
        g.fillRect(x * TILE_SIZE_PIXELS + (x + 1) * TILE_MARGIN_PIXELS,
                y * TILE_SIZE_PIXELS + (y + 1) * TILE_MARGIN_PIXELS,
                TILE_SIZE_PIXELS,
                TILE_SIZE_PIXELS);
    }

    private void drawText(Tile tile, int x, int y) {
        if (tile.isEmpty()) {
            // dont draw text of empty tile
            return;
        }

        g.setColor(tileTextColor);
        g.setFont(fontGetter.getFont(fontSize(tile)));
        drawTileValue(tile, x, y);
    }

    private void drawTileValue(Tile tile, int x, int y) {
        int valueTextWidth = g.getFont().getWidth(tile.getValue() + "");
        int valueTextHeight = g.getFont().getHeight(tile.getValue() + "");

        g.drawString(
                tile.getValue() + "",
                x * TILE_SIZE_PIXELS + (x + 1) * TILE_MARGIN_PIXELS + (TILE_SIZE_PIXELS - valueTextWidth) / 2,
                y * TILE_SIZE_PIXELS + (y + 1) * TILE_MARGIN_PIXELS + (TILE_SIZE_PIXELS - valueTextHeight) / 2);
    }

    private Color backgroundColor(Tile tile) {
        return propertiesGetter.getProperties(tile).getBackgroundColor();
    }

    private int fontSize(Tile tile) {
        return propertiesGetter.getProperties(tile).getFontSize();
    }

}
