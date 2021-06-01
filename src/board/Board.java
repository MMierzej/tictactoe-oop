package board;

/**
 * Klasa implementująca reprezentację planszy.
 * Zapewnia interfejs służący do informowania
 * o stanie rozgrywki.
 */
public class Board {
    /**
     * Reprezentacja planszy w postaci dwuwymiarowej tablicy 3x3 znaków,
     * ' ' oznacza wolne pole, jakikolwiek inny znak oznacza pole zajęte
     * przez gracza identyfikującego się owym znakiem.
     */
    private char[][] board;

    /**
     * @return true, jeśli pole o współrzędnych (x, y) jest puste; false w p.p.
     */
    public boolean isFree(int x, int y) {
        return board[y][x] == ' ';
    }

    /**
     * @return znak wygranego, bądź '-' w przypadku remisu
     * lub nierozstrzygniętej rozgrywki.
     */
    public char getWinner() {
        return '-';
    }

    /**
     * Wyczyszcenie planszy.
     */
    public void reset() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }
}
