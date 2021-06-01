package player.ai;

public class HardAI extends AI {
    private boolean maximizing;
    
    public HardAI(char c, boolean maximizing) {
        super(c, "hard");
        this.maximizing = maximizing;
    }

    @Override
    public int[] chooseCoordinates(char[][] board) {
        moveMessage();

        int[] coords = new int[2];

        return coords;
    }
}
