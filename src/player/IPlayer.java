package player;

import board.Board;

/**
 * Interfejs zapewniający niezbędne metody do uczestniczenia w rozgrywce.
 */
public interface IPlayer {
    /**
     * Wybór współrzędnych - wykonanie ruchu przez gracza.
     * @param board plansza, na której gracz wykona ruch.
     * @return para (x, y), taka że x - numer wiersza, y - numer kolumny.
     */
    int[] chooseCoordinates(Board board);

    /**
     * Udostępnienie przez gracza jego indywidualnego znaku,
     * który pozwala identyfikować jego ruchy na planszy.
     * @return znak gracza.
     */
    char getPlayerChar();
}
