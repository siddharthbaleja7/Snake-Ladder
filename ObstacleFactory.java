import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleFactory {
    private static final Random random = new Random();

    public static List<Snake> createSnakes(int numberOfSnakes, int boardSize) {
        List<Snake> snakes = new ArrayList<>();
        for (int i = 0; i < numberOfSnakes; i++) {
            int start = random.nextInt(boardSize - 2) + 2;
            int end = random.nextInt(start - 1) + 1;
            snakes.add(new Snake(start, end));
        }
        return snakes;
    }

    public static List<Ladder> createLadders(int numberOfLadders, int boardSize) {
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < numberOfLadders; i++) {
            int start = random.nextInt(boardSize - 2) + 1;
            int end = random.nextInt(boardSize - start - 1) + start + 1;
            ladders.add(new Ladder(start, end));
        }
        return ladders;
    }
}