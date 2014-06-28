package cz.stanov.slick2048.render;

import cz.stanov.slick2048.gameobject.Tile;

import java.util.HashMap;
import java.util.Map;

import static cz.stanov.slick2048.render.RenderConstants.*;

public class TileRenderPropertiesGetter {

    private static Map<Integer, TileRenderProperties> PROPS = new HashMap<Integer, TileRenderProperties>();


    public TileRenderProperties getProperties(Tile tile) {
        if (PROPS.containsKey(tile.getValue())) {
            return PROPS.get(tile.getValue());
        }

        return new TileRenderProperties(TILE_COLOR_OTHER, TILE_FONT_SIZE_OTHER);
    }


    static {
        PROPS.put(0, new TileRenderProperties(TILE_COLOR_EMPTY, 0));
        PROPS.put(2, new TileRenderProperties(TILE_COLOR_2, TILE_FONT_SIZE_2));
        PROPS.put(4, new TileRenderProperties(TILE_COLOR_4, TILE_FONT_SIZE_4));
        PROPS.put(8, new TileRenderProperties(TILE_COLOR_8, TILE_FONT_SIZE_8));
        PROPS.put(16, new TileRenderProperties(TILE_COLOR_16, TILE_FONT_SIZE_16));
        PROPS.put(32, new TileRenderProperties(TILE_COLOR_32, TILE_FONT_SIZE_32));
        PROPS.put(64, new TileRenderProperties(TILE_COLOR_64, TILE_FONT_SIZE_64));
        PROPS.put(128, new TileRenderProperties(TILE_COLOR_128, TILE_FONT_SIZE_128));
        PROPS.put(256, new TileRenderProperties(TILE_COLOR_256, TILE_FONT_SIZE_256));
        PROPS.put(512, new TileRenderProperties(TILE_COLOR_512, TILE_FONT_SIZE_512));
        PROPS.put(1024, new TileRenderProperties(TILE_COLOR_1024, TILE_FONT_SIZE_1024));
        PROPS.put(2048, new TileRenderProperties(TILE_COLOR_2048, TILE_FONT_SIZE_2048));
    }
}
