package gamemod;

import java.util.Scanner;

import board.Board;
import player.*;
import player.ai.*;

/**
 * Moderator całej gry.
 */
public class GameMod {
    /**
     * Liczba przechowująca, ile kolejek minęło.
     */
    private int turn = 0;
    /**
     * Plansza, na której toczy się rozgrywka.
     */
    private Board board;
    /**
     * Tablica referencji do obu graczy.
     */
    private Player[] players;
    /**
     * Scanner do wczytywania wejścia od użytkownika.
     */
    private Scanner scan;

    /**
     * Konstruktor moderatora.
     */
    public GameMod() {
        board = new Board();
        players = new Player[2];
    }

    /**
     * Wywołanie moderatora do moderowania nowej gry.
     */
    public void runGame() {
        scan = new Scanner(System.in);

        gameLoop:
        while (true) {
            String[] input;
            char winner;

            while (true) {
                System.out.print("Input command: ");
                input = scan.nextLine().trim().split("\\s+");

                if (input.length == 1 && input[0].equals("exit"))
                    break gameLoop;

                if (input.length == 1 && input[0].equals("replay"))
                    break;

                if (input.length == 3) {
                    if (input[0].equals("play")
                            && (input[1].equals("easy") || input[1].equals("user") || input[1].equals("medium") || input[1].equals("hard"))
                            && (input[2].equals("easy") || input[2].equals("user") || input[2].equals("medium") || input[2].equals("hard"))) {
                        initPlayers(input);
                        break;
                    }
                }

                System.out.println("Bad parameters!");
            }

            while (true) {
                board.printBoard();
                System.out.println();
                winner = board.getWinner();

                if (!(winner == ' ')) {
                    if (winner == '-') System.out.printf("It's a draw!%n");
                    else System.out.printf("%c wins!%n", winner);
                    break;
                }

                int[] coords = players[turn % 2].chooseCoordinates(board);
                board.setAtCoords(coords[0], coords[1], players[turn % 2].getPlayerChar());
                turn++;
            }

            board.reset();
            turn = 0;
        }

        scan.close();
    }

    /**
     * Inicjalizacja obiektów graczy na podstawie wejścia użytkownika.
     * @param input wejście z informacją o trybie gry.
     */
    private void initPlayers(String[] input) {
        switch (input[1]) {
            case "user":
                players[0] = new User('X');
                break;
            case "easy":
                players[0] = new EasyAI('X');
                break;
            case "medium":
                players[0] = new MediumAI('X', true);
                break;
            case "hard":
                players[0] = new HardAI('X', true);
                break;
        }

        switch (input[2]) {
            case "user":
                players[1] = new User('O');
                break;
            case "easy":
                players[1] = new EasyAI('O');
                break;
            case "medium":
                players[1] = new MediumAI('O', false);
                break;
            case "hard":
                players[1] = new HardAI('O', false);
                break;
        }
    }
}
