package player;

import board.Board;

/**
 * Klasa, której obiekty reprezentują użytkownika w grze.
 */
public class User extends Player {
    /**
     * Konstruktor obiektu gracza-użytkownika.
     * @param c znak gracza.
     */
    public User(char c) {
        super(c);
    }

    @Override
    public int[] chooseCoordinates(Board board) {
        int[] coords = new int[2];

        return coords;
    }
}
