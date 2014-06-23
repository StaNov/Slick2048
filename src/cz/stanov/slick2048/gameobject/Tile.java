package cz.stanov.slick2048.gameobject;

import org.newdawn.slick.Color;

public enum Tile {

    T_EMPTY(0, Color.lightGray),
    T_2(2, Color.magenta),
    T_4(4, Color.green),
    T_8(8, Color.blue),
    T_16(16, Color.red),
    T_32(32, Color.blue),
    T_64(64, Color.blue),
    T_128(128, Color.blue),
    T_256(256, Color.blue),
    T_512(512, Color.blue),
    T_1024(1024, Color.blue),
    T_2048(2048, Color.blue),
    T_4096(4096, Color.blue);

    private int value = 2;
    private Color color = Color.white;

    private Tile(int value, Color color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public static Tile getByValue(int value) {
        for (Tile t : values()) {
            if (t.value == value) {
                return t;
            }
        }

        return null;
    }
}
