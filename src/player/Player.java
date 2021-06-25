package player;

import board.Board;
/**
 * Szkielet dla klas implementujących graczy.
 */
public abstract class Player {
    /**
     * Indywidualny znak gracza, jego identyfikator na planszy.
     */
    private char playerChar;

    /**
     * Konstruktor instancji gracza.
     * @param c znak gracza, który identyfikuje go na planszy.
     */
    public Player(char c) {
        playerChar = c;
    }

    /**
     * Wybór współrzędnych - wykonanie ruchu przez gracza.
     * @param board plansza, na której gracz wykona ruch.
     * @return para (x, y), taka że x - numer wiersza, y - numer kolumny.
     */
    public abstract int[] chooseCoordinates(Board board);

    /**
     * Udostępnienie przez gracza jego indywidualnego znaku,
     * który pozwala identyfikować jego ruchy na planszy.
     * @return znak gracza.
     */
    public char getPlayerChar() {
        return playerChar;
    }
}