import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputDeclarator implements IOutputDeclarator {
    PrintWriter printWriter;

    public OutputDeclarator (OutputStream stream){
        printWriter = new PrintWriter(stream);
    }

    /**
     * Prints output to a printWriter
     */
    @Override
    public void output(Coordinates coordinates, Directions direction) {
        String output = coordinates.getX() + " " + coordinates.getY() + " ";

        switch (direction) {
            case EAST: {
                output += "EAST";
                break;
            }

            case WEST: {
                output += "WEST";
                break;
            }

            case NORTH: {
                output += "NORTH";
                break;
            }

            case SOUTH: {
                output += "SOUTH";
                break;
            }
        }

        printWriter.print(output);
        printWriter.close();
    }
}
