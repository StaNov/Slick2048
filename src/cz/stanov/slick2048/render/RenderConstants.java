package cz.stanov.slick2048.render;


import org.newdawn.slick.Color;

public class RenderConstants {
    public static final int TILE_SIZE_PIXELS = 100;
    public static final int TILE_MARGIN_PIXELS = 10;

    public static final String FONT_NAME = "Verdana"; // TODO načítat font, teď je tam ten původní
    public static final int TILE_TEXT_TRANSPARENCY = 180;

    public static final Color BACKGROUND_COLOR = Color.darkGray;
    
    public static final Color TILE_COLOR_EMPTY = Color.gray;
    public static final Color TILE_COLOR_2 = Color.decode("#D4D971");
    public static final Color TILE_COLOR_4 = Color.decode("#86D971");
    public static final Color TILE_COLOR_8 = Color.decode("#71D9C0");
    public static final Color TILE_COLOR_16 = Color.decode("#71BFD9");
    public static final Color TILE_COLOR_32 = Color.decode("#7171D9");
    public static final Color TILE_COLOR_64 = Color.decode("#B671D9");
    public static final Color TILE_COLOR_128 = Color.decode("#D971B8");
    public static final Color TILE_COLOR_256 = Color.decode("#D97171");
    public static final Color TILE_COLOR_512 = Color.decode("#D9A671");
    public static final Color TILE_COLOR_1024 = Color.decode("#35D420");
    public static final Color TILE_COLOR_2048 = Color.decode("#F22929");
    public static final Color TILE_COLOR_OTHER = Color.decode("#FFF700");

    public static final int TILE_FONT_SIZE_1_DIGIT = 70;
    public static final int TILE_FONT_SIZE_2_DIGITS = 60;
    public static final int TILE_FONT_SIZE_3_DIGITS = 40;
    public static final int TILE_FONT_SIZE_4_DIGITS = 30;
    public static final int TILE_FONT_SIZE_OTHER = 20;
}
