package player.ai;

import board.Board;

/**
 * Sztuczna inteligencja o wysokim poziomie trudności.
 * Używa algorytmu minimax, aby w najgorszym przypadku doprowadzić
 * do remisu, a w najlepszym - do wygranej.
 */
public class HardAI extends AI {
    /**
     * Konstruktor obiektu sztucznej inteligencji o wysokim poziomie trudności.
     * @param c znak gracza.
     * @param maximizing min/max algorytmu minimax.
     */
    public HardAI(char c, boolean maximizing) {
        super(c, "hard");
        this.maximizing = maximizing;
    }

    @Override
    public int[] chooseCoordinates(Board board) {
        moveMessage();

        int result;
        int max = -2;
        int min =  2;
        int[] maxCoords = new int[2];
        int[] minCoords = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isFree(i, j)) {
                    board.setAtCoords(i, j, getPlayerChar());
                    result = minimax(board, !maximizing, 9);
                    board.setAtCoords(i, j, ' ');

                    if (max < result) {
                        max = result;
                        maxCoords[0] = i;
                        maxCoords[1] = j;
                    }

                    if (min > result) {
                        min = result;
                        minCoords[0] = i;
                        minCoords[1] = j;
                    }
                }
            }
        }

        return maximizing ? maxCoords : minCoords;
    }
}
