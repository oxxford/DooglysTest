public class Controller {
    private RobotModel model;
    private ICommandSource parser;
    private Map map;
    private IOutputDeclarator outputer;

    public Controller(RobotModel model, ICommandSource parser, Map map, IOutputDeclarator outputer) {
        this.model = model;
        this.parser = parser;
        this.map = map;
        this.outputer = outputer;
    }

    /**
     * Reads every command and execute it
     */
    public void executeCommands() {
        CommandTypes type = parser.nextCommandType();

        while (type != null) {
            switch (type) {
                case MOVE: {
                    Coordinates coordinates = parser.nextCoordinates();

                    if (!map.isTrapCell(coordinates.getX(), coordinates.getY()))
                        throw new IllegalArgumentException("Trap cell(" + coordinates.getX() + " " + coordinates.getY() + ")!");

                    model.setCordinates(coordinates);
                    break;
                }
                case TURN: {
                    model.setDirection(parser.nextDirection());
                    break;
                }
            }

            type = parser.nextCommandType();
        }
    }

    /**
     * declares output to respective place
     */
    public void declareOutput() {
        outputer.output(model.getCordinates(), model.getDirection());
    }
}
