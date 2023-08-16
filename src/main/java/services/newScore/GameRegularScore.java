package services.newScore;

public class GameRegularScore extends GameScore<GameRegularPlayerPoints> {

    @Override
    protected GameRegularPlayerPoints getZeroScore() {
        return GameRegularPlayerPoints.ZERO;
    }

    @Override
    State pointWon(int playerNumber) {
        GameRegularPlayerPoints playerScore = getPlayerScore(playerNumber);
        if (playerScore.ordinal() <= GameRegularPlayerPoints.THIRTY.ordinal()) {
            // 0:X, 15:X, 30:X
            setPlayerScore(playerNumber, playerScore.next());
        } else if (playerScore == GameRegularPlayerPoints.FORTY) {
            // 40: X
            GameRegularPlayerPoints oppositePlayerScore = getOppositePlayerScore(playerNumber);

            if (oppositePlayerScore == GameRegularPlayerPoints.ADVANTAGE) {
                // 40 : AD
                setOppositePlayerScore(playerNumber, GameRegularPlayerPoints.FORTY);
            } else if (oppositePlayerScore == GameRegularPlayerPoints.FORTY) {
                // 40 : 40
                setPlayerScore(playerNumber, GameRegularPlayerPoints.ADVANTAGE);
            } else {
                // 40 : 0, 40 : 15, 40 : 30 -> wins the game
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            }
        } else if (playerScore == GameRegularPlayerPoints.ADVANTAGE) {
            // ADV : FORTY -> wins the game
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        } else {
            throw new IllegalStateException("Can't call pointWon on ADVANTAGE");
        }

        return State.ONGOING;
    }
}
