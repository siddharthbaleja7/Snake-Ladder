import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<IPlayer> players;
    private Dice dice;
    private List<IRules> rules;
    private String state; 

    //Builder
    private Game(Builder builder) {
        this.board = builder.board;
        this.players = builder.players;
        this.dice = builder.dice;
        this.rules = builder.rules;
        this.state = "RUNNING";
    }

    public void play() {
        System.out.println("Game Started!");
        while (!state.equals("ENDED")) {
            for (IPlayer player : players) {
                if (state.equals("ENDED")) {
                    break; 
                }
                takeTurn(player);
                for (IRules rule : rules) {
                    rule.applyRule(this);
                }
            }
        }
        System.out.println("Game Over!");
    }

    public void takeTurn(IPlayer player) {
        System.out.println("\n--- It's " + player.getName() + "'s turn ---");
        player.move(); 
        int roll = dice.roll();
        System.out.println(player.getName() + " rolled a " + roll);

        int currentPosition = 0;
        if (player instanceof Human) {
            Human humanPlayer = (Human) player;
            currentPosition = humanPlayer.getCurrentPosition();
            int newPosition = currentPosition + roll;
            System.out.println(player.getName() + " moved from " + currentPosition + " to " + newPosition);
            newPosition = board.getFinalPosition(newPosition); 
            humanPlayer.setCurrentPosition(newPosition);
            System.out.println(player.getName() + " is now at position " + humanPlayer.getCurrentPosition());
        } else if (player instanceof Bot) {
            Bot botPlayer = (Bot) player;
            currentPosition = botPlayer.getCurrentPosition();
            int newPosition = currentPosition + roll;
            System.out.println(player.getName() + " moved from " + currentPosition + " to " + newPosition);
            newPosition = board.getFinalPosition(newPosition);
            botPlayer.setCurrentPosition(newPosition);
            System.out.println(player.getName() + " is now at position " + botPlayer.getCurrentPosition());
        }
    }

    public Board getBoard() {
        return board;
    }

    public List<IPlayer> getPlayers() {
        return players;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public static class Builder {
        private Board board;
        private List<IPlayer> players = new ArrayList<>();
        private Dice dice;
        private List<IRules> rules = new ArrayList<>();

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder addPlayer(IPlayer player) {
            this.players.add(player);
            return this;
        }

        public Builder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Builder addRule(IRules rule) {
            this.rules.add(rule);
            return this;
        }

        public Game build() {
            if (board == null || players.isEmpty() || dice == null) {
                throw new IllegalStateException("Board, players, and dice must be set.");
            }
            return new Game(this);
        }
    }
}