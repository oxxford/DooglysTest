public abstract class Map  {
    protected int width;
    protected int height;

    /**
     * checks if a robot can go to cell with this coordinates
     * @param x first coordinate
     * @param y second coordinate
     * @return
     */
    public abstract boolean isTrapCell(int x, int y);
}
