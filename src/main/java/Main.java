import gamers.Computer;
import gamers.Gamer;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Gamer("Gamer"),
                new Computer("Angry Computer"));
        game.start();
    }
}