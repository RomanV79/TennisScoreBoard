package services;

import entity.Player;
import services.score.Score;

import java.util.UUID;

public class CurrentMatch {
    private final UUID uuid;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final Score firstScore;
    private final Score secondScore;
    private final int SET_SCHEME = 3; // потом можно модифицировать для запроса количества сетов при старте матча
    private int setForWin;
    private MatchStage stage;

    public CurrentMatch(UUID uuid, Player firstPlayer, Player secondPlayer) {
        this.uuid = uuid;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstScore = new Score();
        this.secondScore = new Score();
        this.setForWin = (SET_SCHEME + 1) / 2;
        this.stage = MatchStage.NORMAL;
    }

    @Override
    public String toString() {
        return "CurrentMatch{" +
                "uuid=" + uuid +
                ", firstPlayer=" + firstPlayer +
                ", secondPlayer=" + secondPlayer +
                ", firstScore=" + firstScore +
                ", secondScore=" + secondScore +
                ", SET_SCHEME=" + SET_SCHEME +
                ", setForWin=" + setForWin +
                '}';
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public Score getFirstScore() {
        return firstScore;
    }

    public Score getSecondScore() {
        return secondScore;
    }

    public MatchStage getStage() {
        return stage;
    }

    public void setStage(MatchStage stage) {
        this.stage = stage;
    }

    public int getSetForWin() {
        return setForWin;
    }
}
