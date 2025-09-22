public class WinningRule implements IRules {
    @Override
    public void applyRule(Game game) {

        System.out.println("Applying Winning Rule...");
        for (IPlayer player : game.getPlayers()) {
            if (player instanceof Human) {
                Human humanPlayer = (Human) player;
                if (humanPlayer.getCurrentPosition() >= game.getBoard().getSize()) {
                    game.setState("ENDED"); 
                    System.out.println(humanPlayer.getName() + " has won the game!");
                }
            } else if (player instanceof Bot) {
                Bot botPlayer = (Bot) player;
                if (botPlayer.getCurrentPosition() >= game.getBoard().getSize()) {
                    game.setState("ENDED");
                    System.out.println(botPlayer.getName() + " has won the game!");
                }
            }
        }
    }
}