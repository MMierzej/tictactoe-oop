package player.ai;

import board.Board;

/**
 * Sztuczna inteligencja o wysokim poziomie trudności.
 * Używa algorytmu minimax, aby w najgorszym przypadku doprowadzić
 * do remisu, a w najlepszym - do wygranej.
 */
public class HardAI extends AI {
    // /**
    //  * Wartość używana w algorytmie minimax.
    //  * Przechowuje informację o tym, w jaki sposób
    //  * dany obiekt chce wpłynąć na wynik.
    //  */
    // private boolean maximizing;

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

        int[] coords = new int[2];

        return coords;
    }
}
