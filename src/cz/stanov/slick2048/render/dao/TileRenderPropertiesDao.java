package cz.stanov.slick2048.render.dao;

import cz.stanov.slick2048.gameobject.Tile;
import cz.stanov.slick2048.render.dto.TileRenderProperties;

import java.util.HashMap;
import java.util.Map;

import static cz.stanov.slick2048.render.RenderConstants.*;

public class TileRenderPropertiesDao {

    private static final int OTHER_TILE_VALUE = -1;
    private static Map<Integer, TileRenderProperties> PROPS = new HashMap<Integer, TileRenderProperties>();


    public TileRenderProperties getProperties(Tile tile) {
        if (PROPS.containsKey(tile.getValue())) {
            return PROPS.get(tile.getValue());
        }

        return PROPS.get(OTHER_TILE_VALUE);
    }


    static {
        PROPS.put(-1, new TileRenderProperties(TILE_COLOR_OTHER, TILE_FONT_SIZE_OTHER));
        PROPS.put(0, new TileRenderProperties(TILE_COLOR_EMPTY, 0));
        PROPS.put(2, new TileRenderProperties(TILE_COLOR_2, TILE_FONT_SIZE_1_DIGIT));
        PROPS.put(4, new TileRenderProperties(TILE_COLOR_4, TILE_FONT_SIZE_1_DIGIT));
        PROPS.put(8, new TileRenderProperties(TILE_COLOR_8, TILE_FONT_SIZE_1_DIGIT));
        PROPS.put(16, new TileRenderProperties(TILE_COLOR_16, TILE_FONT_SIZE_2_DIGITS));
        PROPS.put(32, new TileRenderProperties(TILE_COLOR_32, TILE_FONT_SIZE_2_DIGITS));
        PROPS.put(64, new TileRenderProperties(TILE_COLOR_64, TILE_FONT_SIZE_2_DIGITS));
        PROPS.put(128, new TileRenderProperties(TILE_COLOR_128, TILE_FONT_SIZE_3_DIGITS));
        PROPS.put(256, new TileRenderProperties(TILE_COLOR_256, TILE_FONT_SIZE_3_DIGITS));
        PROPS.put(512, new TileRenderProperties(TILE_COLOR_512, TILE_FONT_SIZE_3_DIGITS));
        PROPS.put(1024, new TileRenderProperties(TILE_COLOR_1024, TILE_FONT_SIZE_4_DIGITS));
        PROPS.put(2048, new TileRenderProperties(TILE_COLOR_2048, TILE_FONT_SIZE_4_DIGITS));
    }
}
