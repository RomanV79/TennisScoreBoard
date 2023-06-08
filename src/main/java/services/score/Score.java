package services.score;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final List<Integer> listSet;
    private int scoreGame;
    private ScorePointEnum scorePoint;

    public Score() {
        this.listSet = new ArrayList<>();
        this.scoreGame = 0;
        this.scorePoint = ScorePointEnum.ZERO;
    }

    public List<Integer> getListSet() {
        return listSet;
    }

    public ScorePointEnum getScorePoint() {
        return scorePoint;
    }

    public int getScoreGame() {
        return scoreGame;
    }

    public void setScorePoint(ScorePointEnum scorePoint) {
        this.scorePoint = scorePoint;
    }

    public void setScoreGame(int scoreGame) {
        this.scoreGame = scoreGame;
    }

    public void appendPoint(){
        switch (scorePoint) {
            case ZERO -> scorePoint = ScorePointEnum.FIFTEEN;
            case FIFTEEN -> scorePoint = ScorePointEnum.THIRTY;
            case THIRTY -> scorePoint = ScorePointEnum.FORTY;
            case FORTY -> scorePoint = ScorePointEnum.WIN;
        }
    }

    public void appendGame(){
        scoreGame++;
    }
}
