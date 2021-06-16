package player.ai;

import java.util.Random;
import board.Board;

/**
 * Sztuczna inteligencja o średnim poziomie trudności.
 * Unika porażki w najbliższym ruchu oraz wykorzystuje okazje
 * wygranej w jednym ruchu. W innych przypadkach wykonuje ruch losowo.
 */
public class MediumAI extends AI {
    // /**
    //  * Wartość używana w algorytmie minimax.
    //  * Przechowuje informację o tym, w jaki sposób
    //  * dany obiekt chce wpłynąć na wynik.
    //  */
    // private boolean maximizing;

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
