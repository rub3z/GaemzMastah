package mazeGame.model;

public class Cell {
    private double x, y;
    private boolean north, west, east, south;

    public Cell() {
        x = 0;
        y = 0;
        north = false;
        west = false;
        east = false;
        south = false;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        north = false;
        west = false;
        east = false;
        south = false;
    }

    public Cell(int x, int y, boolean north, boolean west, boolean east, boolean south) {
        this.x = x;
        this.y = y;
        this.north = north;
        this.west = west;
        this.east = east;
        this.south = south;
    }

    public void setSide(boolean walled, Direction direction) {
        switch (direction) {
            case North:
                this.north = walled;
                break;
            case East:
                this.east = walled;
                break;
            case West:
                this.west = walled;
                break;
            case South:
                this.south = walled;
                break;
        }
    }

    public boolean getSide(Direction direction) {
        switch (direction) {
            case North:
                return north;
            case East:
                return east;
            case West:
                return west;
            case South:
                return south;
            default:
                return false;
        }
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return "X: " + x + " Y: " + y + " North: " + north + " South: " + south + " East: " + east + " West: " + west;
    }

}
