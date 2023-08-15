package services.newScore;

public class MatchScore extends Score<Integer> {

    private SetScore currentSet;
    private final int setsForWin;

    public MatchScore(int setsForWin) {
        this.setsForWin = setsForWin;
        this.currentSet = new SetScore();
    }

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    State pointWon(int playerNumber) {
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
}
