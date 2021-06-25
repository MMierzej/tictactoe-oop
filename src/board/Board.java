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
     * Zmienna, pamiętająca liczbę wolnych pól.
     */
    private int free;

    /**
     * Konstruktor planszy do Kołka i krzyżyk.
     */
    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int k = 0; k < 3; k++)
                board[i][k] = ' ';
        free = 9;
    }

    /**
     * @return true, jeśli pole o współrzędnych (x, y) jest puste; false w p.p.
     */
    public boolean isFree(int x, int y) {
        return board[x][y] == ' ';
    }

    /**
     * @param x numer wiersza.
     * @param y numer kolumny.
     * @return wartość w polu (x,y) planszy.
     */
    public char getAtCoords(int x, int y) {
        return board[x][y];
    }

    /**
     * Ustalenie wartości pola na planszy.
     * @param x numer wiersza.
     * @param y numer kolumny.
     * @param c wartość pola.
     * @return true, jeśli pole było wolne. W przeciwnym przypadku: false.
     */
    public void setAtCoords(int x, int y, char c) {
        if ( isFree(x, y) && c != ' ') free--;
        if (!isFree(x, y) && c == ' ') free++;
        board[x][y] = c;
    }

    /**
     * @return znak wygranego, '-' w przypadku remisu,
     * ' ' dla nierozstrzygniętej rozgrywki.
     */
    public char getWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] ==  board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0] == 'X' ? 'X' : 'O';
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] ==  board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i] == 'X' ? 'X' : 'O';
            }
        }

        if (((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0])) && board[1][1] != ' ') {
            return board[1][1] == 'X' ? 'X' : 'O';
        }

        if (free > 0) {
            return ' ';
        }

        return '-';
    }

    /**
     * Wyczyszcenie planszy.
     */
    public void reset() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = ' ';
        free = 9;
    }

    /**
     * Wypisanie wizualnej reprezentacji planszy na konsolę.
     */
    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
