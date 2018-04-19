public class RobotModel {
    private Coordinates cordinates;
    private Directions direction;

    public RobotModel() {
        cordinates = new Coordinates(0, 0);
        direction = Directions.SOUTH;
    }

    public Coordinates getCordinates() {
        return cordinates;
    }

    public void setCordinates(Coordinates cordinates) {
        this.cordinates = cordinates;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }
}
