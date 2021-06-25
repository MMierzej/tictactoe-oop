package player.ai;

import board.Board;

/**
 * Klasa zapewniająca szkielet klasom implementującym sztuczną inteligencję.
 */
public abstract class AI extends player.Player {
    /**
     * Łańcuch przechowujący informację o poziomie trudności danej instancji AI.
     */
    private final String difficulty;
    /**
     * Wartość używana w algorytmie minimax.
     * Przechowuje informację o tym, w jaki sposób
     * dany obiekt chce wpłynąć na wynik.
     */
    protected boolean maximizing;

    /**
     * Konstruktor obiektu sztucznej inteligencji.
     * @param c indywidualny znak identyfikujący gracza na planszy.
     * @param difficulty poziom trudności instancji sztucznej inteligencji.
     */
    public AI(char c, String difficulty) {
        super(c);
        this.difficulty = difficulty;
    }
    
    /**
     * Wiadomość wysyłana przed wykonaniem ruchu.
     */
    public void moveMessage() {
        System.out.printf("%c making move, level: %s.%n", this.getPlayerChar(), difficulty);
    }

    /**
     * Algorytm minimax.
     * @param board plansza, według której minimax ma ewaluować stan gry.
     * @param maximizing gracz maksymalizujący/minimalizujący wynik.
     * @param maxDepth maksymalna głębokość rekursji, włącznie z obecnym wywołaniem.
     * @return 1: wygrana 'X', 0: remis, -1: wygrana 'O'.
     */
    protected int minimax(Board board, boolean maximizing, int maxDepth) {
        if (maxDepth <= 0) return 0;

        switch (board.getWinner()) {
            case '-':
                return 0;
            case 'X':
                return 1;
            case 'O':
                return -1;
            default:
                break;
        }

        int maxVal = -2;
        int minVal =  2;
        int result;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isFree(i, j)) {
                    board.setAtCoords(i, j, maximizing ? 'X' : 'O');
                    result = minimax(board, !maximizing, maxDepth - 1);
                    maxVal = Math.max(maxVal, result);
                    minVal = Math.min(minVal, result);
                    board.setAtCoords(i, j, ' ');
                }
            }
        }

        return maximizing ? maxVal : minVal;
    }
}
