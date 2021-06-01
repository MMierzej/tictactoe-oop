package player;

public abstract class Player implements IPlayer {
    private char playerChar;

    public Player(char c) {
        if (c == 'X' || c == 'O')
            playerChar = c;
        else playerChar = '-';
    }

    public char getPlayerChar() {
        return playerChar;
    }
}