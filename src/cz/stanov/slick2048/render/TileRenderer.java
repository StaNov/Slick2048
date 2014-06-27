package cz.stanov.slick2048.render;

import cz.stanov.slick2048.gameobject.Tile;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import static cz.stanov.slick2048.render.RenderConstants.*;

public class TileRenderer {

    private Graphics g;

    public TileRenderer(Graphics g) {
        this.g = g;
    }

    public void renderTile(Tile tile, int x, int y) {
        g.setColor(Color.green); // TODO různé barvy
        g.fillRect(x * TILE_SIZE_PIXELS + (x+1) * TILE_MARGIN_PIXELS,
                y * TILE_SIZE_PIXELS + (y+1) * TILE_MARGIN_PIXELS,
                TILE_SIZE_PIXELS, TILE_SIZE_PIXELS);

        if (! tile.isEmpty()) {
            g.setColor(Color.black);
            g.drawString(String.valueOf(tile.getValue()), x* TILE_SIZE_PIXELS + (x+1)* TILE_MARGIN_PIXELS + 20, y* TILE_SIZE_PIXELS + (y+1)* TILE_MARGIN_PIXELS + 20);
            // TODO zarovnat na střed
        }
    }
}
