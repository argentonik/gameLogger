import enums.Color;
import gamers.Gamer;

public class Game {
    private Gamer firstPlayer;
    private Gamer secondPlayer;

    public Game(Gamer firstPlayer, Gamer secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void start() {
        boolean isAllGamersAlive;
        do {
            // random move selection
            if (Math.random() < 0.5) {
                firstPlayer.makeMove(secondPlayer);
            } else {
                secondPlayer.makeMove(firstPlayer);
            }
            isAllGamersAlive = firstPlayer.isAlive() && secondPlayer.isAlive();
            if (isAllGamersAlive)
                printTotalHealOfGamers();
        } while(isAllGamersAlive);
        printWinner();
    }

    private void printTotalHealOfGamers() {
        System.out.println(Color.RESET + firstPlayer.getName() + ": " + firstPlayer.getHealth() + " health; " + secondPlayer.getName() + ": " +
                secondPlayer.getHealth() + " health.\n" + Color.RESET);
    }

    private void printWinner() {
        System.out.println(Color.RESET + "\n***" + (firstPlayer.isAlive() ? firstPlayer.getName() : secondPlayer.getName()) +
                " won***" + Color.RESET);
    }
}