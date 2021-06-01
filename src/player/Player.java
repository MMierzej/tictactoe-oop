package player;

/**
 * Szkielet dla klas implementujących graczy.
 */
public abstract class Player implements IPlayer {
    /**
     * Indywidualny znak gracza, jego identyfikator na planszy.
     */
    private char playerChar;

    /**
     * Konstruktor instancji gracza.
     * @param c znak gracza, który identyfikuje go na planszy.
     */
    public Player(char c) {
        if (c == 'X' || c == 'O')
            playerChar = c;
        else playerChar = '-';
    }

    public char getPlayerChar() {
        return playerChar;
    }
}