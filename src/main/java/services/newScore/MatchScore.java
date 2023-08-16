package services.newScore;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;


@Slf4j
public class MatchScore extends Score<Integer> {

    private final Map<Integer, List<Integer>> gameResultsInSet;
    @Getter
    private SetScore currentSet;
    private final int setsForWin;
    @Getter
    private int serve;

    public MatchScore(int setsForWin) {
        this.gameResultsInSet = new HashMap<>();
        this.setsForWin = setsForWin;
        this.currentSet = new SetScore();
        this.serve = new Random().nextInt(2);
    }

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    public State pointWon(int playerNumber) {
        State setState = currentSet.pointWon(playerNumber);

        if (setState == State.PLAYER_ONE_WON) {
            return setWon(playerNumber);
        }
        if (setState == State.PLAYER_TWO_WON) {
            return setWon(playerNumber);
        }

        return State.ONGOING;
    }

    private State setWon(int playerNumber) {
        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        List<Integer> gameScore = new ArrayList<>();
        gameScore.add(currentSet.getPlayerScore(0));
        gameScore.add(currentSet.getPlayerScore(1));
        log.info("Set is end, history for game -> {}", gameScore);
        gameResultsInSet.put((getPlayerScore(0) + getPlayerScore(1)), gameScore);
        log.info("Set № is finish -> {}", getPlayerScore(0) + getPlayerScore(1));

        if (getPlayerScore(playerNumber) == setsForWin) {
            if (playerNumber == 0) {
                return State.PLAYER_ONE_WON;
            }
            if (playerNumber == 1) {
                return State.PLAYER_TWO_WON;
            }
        }

        this.currentSet = new SetScore();
        return State.ONGOING;
    }

    public Integer getGameResultsInSet(int setNumber, int playerNumber) {
        try {
            return gameResultsInSet.get(setNumber).get(playerNumber);
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public String getCurrentGameScore(int playerNumber) {
        return getCurrentSet().getCurrentGame().getPlayerScore(playerNumber) instanceof GameRegularPlayerPoints
                ? ((GameRegularPlayerPoints) getCurrentSet().getCurrentGame().getPlayerScore(playerNumber)).getPointCode()
                : getCurrentSet().getCurrentGame().getPlayerScore(playerNumber).toString();
    }
}
