package player;

import java.util.Scanner;

import board.Board;

/**
 * Klasa, której obiekty reprezentują użytkownika w grze.
 */
public class User extends Player {
    /**
     * Pozwala pobrać wejście od użytkownika.
     */
    private Scanner scan;

    /**
     * Konstruktor obiektu gracza-użytkownika.
     * @param c znak gracza.
     */
    public User(char c) {
        super(c);
        scan = new Scanner(System.in);
    }

    @Override
    public int[] chooseCoordinates(Board board) {
        int[] coords = new int[2];
        String[] input;

        while (true) {
            System.out.print("Enter row and column: ");

            try {
                input = scan.nextLine().trim().split("\\s+");
                coords[0] = Integer.parseInt(input[0]) - 1;
                coords[1] = Integer.parseInt(input[1]) - 1;
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (coords[1] < 0 || coords[1] > 2 || coords[0] < 0 || coords[0] > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (board.isFree(coords[0], coords[1])) {
                return coords;
            } else 
                System.out.println("This cell is occupied! Choose another one.");
        }
    }
}
