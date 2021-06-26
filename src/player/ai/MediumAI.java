package player.ai;

import java.util.Random;
import board.Board;

/**
 * Sztuczna inteligencja o średnim poziomie trudności.
 * Unika porażki w najbliższym ruchu oraz wykorzystuje okazje
 * wygranej w jednym ruchu. W innych przypadkach wykonuje ruch losowo.
 */
public class MediumAI extends AI {
    /**
     * Obiekt klasy Random, pomagający wykonać ruch
     * w przypadku, gdy nie ma bezpośredniego zagrożenia przegraną,
     * ani bezpośredniej szansy na wygraną.
     */
    private Random rand;

    /**
     * Konstruktor obiektu sztucznej inteligencji o średnim poziomie trudności.
     * @param c znak gracza.
     * @param maximizing min/max w algorytmie minimax.
     */
    public MediumAI(char c, boolean maximizing) {
        super(c, "medium");
        this.maximizing = maximizing;
        rand = new Random();
    }

    @Override
    public int[] chooseCoordinates(Board board) {
        moveMessage();

        boolean allResultsEqual = true;
        int result;
        int prevRes = 2;
        int max = -2;
        int min =  2;
        int[] maxCoords = new int[2];
        int[] minCoords = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isFree(i, j)) {
                    board.setAtCoords(i, j, getPlayerChar());
                    result = minimax(board, !maximizing, 1);
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

                    if (prevRes != 2 && allResultsEqual)
                        allResultsEqual = prevRes == result;

                    prevRes = result;
                }
            }
        }

        if (allResultsEqual) {
            int rx = rand.nextInt(3);
            int ry = rand.nextInt(3);

            while (!board.isFree(rx, ry)) {
                rx = rand.nextInt(3);
                ry = rand.nextInt(3);
            }

            maxCoords[0] = rx;
            maxCoords[1] = ry;
            minCoords[0] = rx;
            minCoords[1] = ry;
        }

        return maximizing ? maxCoords : minCoords;
    }
}
