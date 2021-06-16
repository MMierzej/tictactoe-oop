package player.ai;

/**
 * Klasa zapewniająca szkielet klasom implementującym sztuczną inteligencję.
 */
public abstract class AI extends player.Player {
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
        System.out.printf("Making move, level: %s.%n", difficulty);
    }

    /**
     * Algorytm minimax.
     * @return współrzędne najkorzystniejszego ruchu.
     */
    protected int[] minimax() {
        return new int[2];
    }
}
