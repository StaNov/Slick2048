package cz.stanov.slick2048.render.dto;

import org.newdawn.slick.Color;

public class TileRenderProperties {

    private Color backgroundColor;
    private int fontSize;

    public TileRenderProperties(Color backgroundColor, int fontSize) {
        this.backgroundColor = backgroundColor;
        this.fontSize = fontSize;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public int getFontSize() {
        return fontSize;
    }
}
