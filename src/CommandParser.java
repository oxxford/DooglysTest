import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandParser implements ICommandSource {
    private CommandTypes commandType;

    private Coordinates coordinates;
    private Directions direction;

    private Scanner scanner;

    public CommandParser(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
    }

    /**
     * if the next command TURN of MOVE
     * @return Directions enum
     */
    @Override
    public CommandTypes nextCommandType() {
        if (!scanner.hasNextLine())
            return null;

        String[] tokens = scanner.nextLine().split(" ");

        switch (tokens[0]) {
            case "MOVE": {
                commandType = CommandTypes.MOVE;

                Integer x = Integer.parseInt(tokens[1]);
                Integer y = Integer.parseInt(tokens[2]);

                coordinates = new Coordinates(x, y);

                break;
            }

            case "TURN": {
                commandType = CommandTypes.TURN;

                switch (tokens[1]){
                    case "NORTH": { direction = Directions.NORTH; break; }

                    case "SOUTH": { direction = Directions.SOUTH; break; }

                    case "WEST": { direction = Directions.WEST; break; }

                    case "EAST": { direction = Directions.EAST; break; }

                    default: throw new IllegalArgumentException("Invalid direction(" + tokens[1] + ")!");
                }

                break;
            }

            default: throw new IllegalArgumentException("Invalid command(" + tokens[0] + ")!");
        }

        return commandType;
    }

    /**
     * Coordinates for next MOVE command
     * @return
     */
    @Override
    public Coordinates nextCoordinates() {
        if (commandType == CommandTypes.TURN)
            throw new IllegalArgumentException("Invalid argument of turning!");

        return coordinates;
    }

    /**
     * Direction for next TURN
     * @return
     */
    @Override
    public Directions nextDirection() {
        if (commandType == CommandTypes.MOVE)
            throw new IllegalArgumentException("Invalid argument of moving!");

        return direction;
    }
}
