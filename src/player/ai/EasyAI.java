package player.ai;

import java.util.Random;

import board.Board;

public class EasyAI extends AI {
    private Random rand;

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
