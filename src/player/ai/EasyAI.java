package player.ai;

import java.util.Random;

import board.Board;

/**
 * Sztuczna inteligencja o łatwym poziomie trudności.
 * Wykonuje ruchy losowo.
 */
public class EasyAI extends AI {
    private Random rand;

    /**
     * Konstruktor obiektu sztucznej inteligencji
     * o łatwym poziomie trudności.
     * @param c znak gracza.
     */
    public EasyAI(char c) {
        super(c, "easy");
        rand = new Random();
    }

    @Override
    public int[] chooseCoordinates(Board board) {
        moveMessage();
        int[] coords = new int[2];

        coords[0] = rand.nextInt(3);
        coords[1] = rand.nextInt(3);

        return coords;
    }
}
