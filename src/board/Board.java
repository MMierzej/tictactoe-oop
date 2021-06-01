package board;

public class Board {
    private char[][] board;

    public boolean isFree(int x, int y) {
        return board[y][x] == ' ';
    }

    public char getWinner() {
        return '-';
    }

    public void reset() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }
}
