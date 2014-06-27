package cz.stanov.slick2048.gameobject;

public class Tile {

    public static final int DEFAULT_INITIAL_TILE_VALUE = 2;

    private int value;
    private boolean alreadyMerged;

    public Tile() {
        this.value = DEFAULT_INITIAL_TILE_VALUE;
    }

    public Tile(int value) {
        this.value = value;
        this.alreadyMerged = false;
    }

    public static Tile emptyTile() {
        return new Tile(0);
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isAlreadyMerged() {
        return alreadyMerged;
    }

    public void setAlreadyMerged(boolean alreadyMerged) {
        this.alreadyMerged = alreadyMerged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        return value == tile.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}
