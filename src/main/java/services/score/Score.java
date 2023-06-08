package services.score;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private List<ScoreSet> listSet;
    private ScoreSet scoreSet;
    private ScoreGame scoreGame;
    private ScorePoint scorePoint;

    public Score() {
        this.listSet = new ArrayList<>();
        this.scoreSet = new ScoreSet();
        this.scoreGame = new ScoreGame();
        this.scorePoint = new ScorePoint();
    }

    public List<ScoreSet> getListSet() {
        return listSet;
    }

    public ScoreSet getScoreSet() {
        return scoreSet;
    }

    public ScoreGame getScoreGame() {
        return scoreGame;
    }

    public ScorePoint getScorePoint() {
        return scorePoint;
    }
}
