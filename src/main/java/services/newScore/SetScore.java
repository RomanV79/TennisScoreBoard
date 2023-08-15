package services.newScore;

public class SetScore extends Score<Integer> {
    private GameScore<?> currentGame;

    public SetScore() {
        this.currentGame = new GameRegularScore();
    }

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    State pointWon(int playerNumber) {
        State gameState = currentGame.pointWon(playerNumber);

        if (gameState == State.PLAYER_ONE_WON) {
            return gameWon(playerNumber);
        } else if (gameState == State.PLAYER_TWO_WON) {
            return gameWon(playerNumber);
        }

        return State.ONGOING;
    }

    private State gameWon(int playerNumber) {

        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        this.currentGame = new GameRegularScore();

        if (getPlayerScore(playerNumber) == 6 || getPlayerScore(playerNumber) == 7) {

            // won with ADVANTAGE in 2 games
            if (getPlayerScore(playerNumber) - getOppositePlayerScore(playerNumber) > 1) {
                if (playerNumber == 0) {
                    return State.PLAYER_ONE_WON;
                }
                if (playerNumber == 1) {
                    return State.PLAYER_TWO_WON;
                }
            }

            // play tie-brake
            if (getPlayerScore(playerNumber) == 6 && getOppositePlayerScore(playerNumber) == 6) {
                this.currentGame = new GameTieBreakScore();
                return State.ONGOING;
            }

            // won after tie-brake
            if (getPlayerScore(playerNumber) == 7 && getOppositePlayerScore(playerNumber) == 6) {
                this.currentGame = new GameRegularScore();
                if (playerNumber == 0) {
                    return State.PLAYER_ONE_WON;
                }
                if (playerNumber == 1) {
                    return State.PLAYER_TWO_WON;
                }
            }
        }

        return State.ONGOING;
    }

}
