package cz.stanov.slick2048.render;

import cz.stanov.slick2048.gameobject.Tile;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.HashMap;
import java.util.Map;

import static cz.stanov.slick2048.render.RenderConstants.*;

public class TileRenderer {

    private Graphics g;

    public TileRenderer(Graphics g) {
        this.g = g;
    }

    public void renderTile(Tile tile, int x, int y) {
        g.setColor(colors.get(tile.getValue()));
        g.fillRect(x * TILE_SIZE_PIXELS + (x+1) * TILE_MARGIN_PIXELS,
                y * TILE_SIZE_PIXELS + (y+1) * TILE_MARGIN_PIXELS,
                TILE_SIZE_PIXELS, TILE_SIZE_PIXELS);

        if (! tile.isEmpty()) {
            g.setColor(Color.black);
            g.drawString(String.valueOf(tile.getValue()), x* TILE_SIZE_PIXELS + (x+1)* TILE_MARGIN_PIXELS + 20, y* TILE_SIZE_PIXELS + (y+1)* TILE_MARGIN_PIXELS + 20);
            // TODO zarovnat na střed
        }
    }

    private static Map<Integer, Color> colors = new HashMap<Integer, Color>();

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
