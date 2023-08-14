package services.newScore;

import java.util.ArrayList;
import java.util.List;

public abstract class Score<T> {
    private final List<T> playerScore = new ArrayList<>();

    protected abstract T getZeroScore();

    public Score() {
        playerScore.add(getZeroScore());
        playerScore.add(getZeroScore());
    }

    public T getPlayerScore(int playerNumber) {
        return playerScore.get(playerNumber);
    }

    public T getOppositePlayerScore(int playerNumber) {
        return playerScore.get(playerNumber == 0 ? 1 : 0);
    }

    public void setPlayerScore(int playerNumber, T score) {
        playerScore.set(playerNumber, score);
    }

    public void setOppositePlayerScore(int playerNumber, T score) {
        playerScore.set(playerNumber == 0 ? 1 : 0, score);
    }

    abstract State pointWon(int playerNumber);
}
