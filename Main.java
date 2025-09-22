import java.util.List;

public class Main {
    public static void main(String[] args) {

        int boardSize = 100;
        Board board = new Board(boardSize);

        List<Snake> snakes = ObstacleFactory.createSnakes(5, boardSize);
        for (Snake snake : snakes) {
            board.addEntity(snake);
        }

        List<Ladder> ladders = ObstacleFactory.createLadders(6, boardSize);
        for (Ladder ladder : ladders) {
            board.addEntity(ladder);
        }

        IPlayer humanPlayer = new Human("Sid");
        IPlayer botPlayer = new Bot("Bot");

        Dice dice = new Dice(1, 6);

        IRules winningRule = new WinningRule();
        IRules killRule = new KillRule();

        Game game = new Game.Builder()
                .setBoard(board)
                .addPlayer(humanPlayer)
                .addPlayer(botPlayer)
                .setDice(dice)
                .addRule(winningRule)
                .addRule(killRule)
                .build();

        game.play();
    }
}