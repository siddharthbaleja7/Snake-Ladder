public class Human implements IPlayer {
    private String name;
    private int currentPosition;

    public Human(String name) {
        this.name = name;
        this.currentPosition = 0; 
    }

    @Override
    public void move() {
        System.out.println(name + " is making a move...");
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