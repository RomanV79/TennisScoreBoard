package services.newScore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRegularScoreTest {

    @Test
    public void TestThreeAndFourPointWon() {
        GameRegularScore score = new GameRegularScore();

        // first player won three points, and didn't win game
        for (int i = 0; i < 3; i++) {
            assertThat(score.pointWon(0)).isEqualTo(State.ONGOING);
        }

        // win game if won 4th point
        assertThat(score.pointWon(0)).isEqualTo(State.PLAYER_ONE_WON);
    }


    @Test
    public void TestAdvantage() {
        GameRegularScore score = new GameRegularScore();

        // make FORTY - FORTY
        for (int i = 0; i < 3; i++) {
            score.pointWon(0);
            score.pointWon(1);
        }

        // ADVANTAGE for first player
        assertThat(score.pointWon(0)).isEqualTo(State.ONGOING);
        assertThat(score.getPlayerScore(0)).isEqualTo(GameRegularPlayerPoints.ADVANTAGE);

        // FORTY- FORTY again if second player won points
        assertThat(score.pointWon(1)).isEqualTo(State.ONGOING);
        assertThat(score.getPlayerScore(0)).isEqualTo(GameRegularPlayerPoints.FORTY);
        assertThat(score.getPlayerScore(1)).isEqualTo(GameRegularPlayerPoints.FORTY);

        // second player wons two points and win game
        score.pointWon(1);
        assertThat(score.pointWon(1)).isEqualTo(State.PLAYER_TWO_WON);
    }
}