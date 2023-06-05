package services.score;

public class ScoreGame {

    private ScorePoint gameFirstPlayer;
    private ScorePoint gameSecondPlayer;

    public ScoreGame() {
        this.gameFirstPlayer = new ScorePoint();
        this.gameSecondPlayer = new ScorePoint();
    }
}
