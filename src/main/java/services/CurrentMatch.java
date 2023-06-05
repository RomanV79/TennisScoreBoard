package services;

import entity.Player;
import services.score.Score;

import java.util.UUID;

public class CurrentMatch {
    private UUID uuid;
    private Player firstPlayer;
    private Player secondPlayer;
    private Score score;
    private final int SET_SCHEME = 3; // потом можно модифицировать для запроса количества сетов при старте матча
    private int setForWin;


    public CurrentMatch() {
    }

    public CurrentMatch(UUID uuid, Player firstPlayer, Player secondPlayer) {
        this.uuid = uuid;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.score = new Score();
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "CurrentMatch{" +
                "uuid=" + uuid +
                ", firstPlayer=" + firstPlayer +
                ", secondPlayer=" + secondPlayer +
                ", score=" + score +
                ", SET_SCHEME=" + SET_SCHEME +
                ", setForWin=" + setForWin +
                '}';
    }
}
