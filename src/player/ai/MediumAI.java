package player.ai;

import java.util.Random;

public class MediumAI extends AI {
    private boolean maximizing;
    private Random rand;

    public MediumAI(char c, boolean maximizing) {
        super(c, "medium");
        this.maximizing = maximizing;
    }

    @Override
    public int[] chooseCoordinates(char[][] board) {
        moveMessage();

        int[] coords = new int[2];
        coords[0] = rand.nextInt(3);
        coords[1] = rand.nextInt(3);

        return coords;
    }
}
