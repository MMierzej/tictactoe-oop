package player.ai;

public abstract class AI extends player.Player {
    private final String difficulty;

    public AI(char c, String difficulty) {
        super(c);
        this.difficulty = difficulty;
    }
    
    public void moveMessage() {
        System.out.printf("Making move, level: %s.%n", difficulty);
    }
}
