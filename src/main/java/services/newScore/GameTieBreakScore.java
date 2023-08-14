package services.newScore;

public class GameTieBreakScore extends GameScore<Integer> {


    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    State pointWon(int playerNumber) {
        Integer playerScore = getPlayerScore(playerNumber);
        

        return State.ONGOING;
    }
}
