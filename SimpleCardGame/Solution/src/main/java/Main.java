import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);
        System.out.println("Player 1, Enter your name");
        String player1 = s.nextLine();
        System.out.println("Player 2, Enter your name");
        String player2 = s.nextLine();

        Deck d = new Deck();
        Game game = new Game(player1, player2, d);
        String winner = game.beginGame();

        System.out.println("The winner is " + winner);
    }
}
