import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MoonMap extends Map{
    private boolean scheme[][];

    public MoonMap(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);

        width = scanner.nextInt();
        height = scanner.nextInt();

        scheme = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int c = scanner.nextInt();

                scheme[i][j] = c == 0;
            }
        }
    }

    @Override
    public boolean isTrapCell(int x, int y) {
        if (x >= height || y >= width || x < 0 || y < 0)
            throw new IllegalArgumentException("Invalid coordinates(" + x + " " + y + ")!");
        else
            return scheme[x][y];
    }
}
