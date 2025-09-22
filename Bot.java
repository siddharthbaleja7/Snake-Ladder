import java.util.Random;

public class Bot implements IPlayer {
    private String name;
    private int currentPosition;
    private Random random;

    public Bot(String name) {
        this.name = name;
        this.currentPosition = 0;
        this.random = new Random();
    }

    @Override
    public void move() {
        System.out.println(name + " (Bot) is making a move...");
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}