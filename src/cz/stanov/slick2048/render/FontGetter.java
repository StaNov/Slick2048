package cz.stanov.slick2048.render;

import org.newdawn.slick.TrueTypeFont;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static cz.stanov.slick2048.render.RenderConstants.FONT_NAME;

public class FontGetter {

    public TrueTypeFont getFont(int fontSize) {
        if (! FONTS.containsKey(fontSize)) {
            FONTS.put(fontSize, new TrueTypeFont(new Font(FONT_NAME, Font.BOLD, fontSize), true));
        }

        return FONTS.get(fontSize);
    }

    private static final Map<Integer, TrueTypeFont> FONTS = new HashMap<Integer, TrueTypeFont>();
}
