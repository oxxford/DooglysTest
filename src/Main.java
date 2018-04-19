import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            RobotModel model = new RobotModel();
            MoonMap map = new MoonMap(new File("map.txt"));
            CommandParser parser = new CommandParser(new File("commands.txt"));
            OutputDeclarator outputer = new OutputDeclarator(new FileOutputStream(new File("report.txt")));

            Controller controller = new Controller(model, parser, map, outputer);

            controller.executeCommands();
            controller.declareOutput();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
