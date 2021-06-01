package player;

import board.Board;

public interface IPlayer {
    int[] chooseCoordinates(Board board);
    char getPlayerChar();
}
