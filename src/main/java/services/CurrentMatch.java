package services;

import entity.Player;
import lombok.Data;
import lombok.ToString;
import services.score.Score;

import java.util.Random;
import java.util.UUID;

@Data
@ToString
public class CurrentMatch {

    private Random random = new Random();

    private final UUID uuid;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private Player winner;
    private final Score firstScore;
    private final Score secondScore;
    private final int SET_SCHEME = 3; // потом можно модифицировать для запроса количества сетов при старте матча
    private int setForWin;
    private MatchStage stage;
    private boolean serveFirstPlayer;
    private boolean serveTieBrakeFirstPlayer;

    public CurrentMatch(UUID uuid, Player firstPlayer, Player secondPlayer) {
        this.uuid = uuid;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstScore = new Score();
        this.secondScore = new Score();
        this.setForWin = (SET_SCHEME + 1) / 2;
        this.stage = MatchStage.NORMAL;
        this.serveFirstPlayer = random.nextBoolean();
    }
}
