public interface ICommandSource {
    CommandTypes nextCommandType();
    Coordinates nextCoordinates();
    Directions nextDirection();
}
