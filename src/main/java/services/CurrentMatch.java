package services;

import entity.Player;
import lombok.Data;
import lombok.ToString;
import services.newScore.MatchScore;

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
    private int setsInMatch;
    private int setForWin;
    private boolean serveFirstPlayer;
    private boolean serveTieBrakeFirstPlayer;
    private MatchScore matchScore;

    public CurrentMatch(UUID uuid, Player firstPlayer, Player secondPlayer, int setsInMatch) {
        this.uuid = uuid;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.setForWin = (setsInMatch + 1) / 2;
        this.matchScore = new MatchScore(setForWin);
        this.serveFirstPlayer = random.nextBoolean();
    }
}
