package services.newScore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTieBreakScoreTest {

    @Test
    public void WonGameOnTieBreakSevenPointsAndDifferenceAtLeastTwo() {
        GameTieBreakScore score = new GameTieBreakScore();

        for (int i = 0; i < 5; i++) {
            score.pointWon(0);
        }
        for (int i = 0; i < 6; i++) {
            score.pointWon(1);
        }
        // second player won game 5 : 7
        assertThat(score.pointWon(1)).isEqualTo(State.PLAYER_TWO_WON);
    }

    @Test
    public void WonGameOnTieBreakAfterSevenPointsWithDifferenceTwo() {
        GameTieBreakScore score = new GameTieBreakScore();

        for (int i = 0; i < 5; i++) {
            score.pointWon(0);
            score.pointWon(1);
        }
        // first player won point and score 7 : 6, game will not finish
        assertThat(score.pointWon(0)).isEqualTo(State.ONGOING);

        // second player won 3 points and difference now 2 points, score 7 : 9
        for (int i = 0; i < 2; i++) {
            score.pointWon(1);
        }
        assertThat(score.pointWon(1)).isEqualTo(State.PLAYER_TWO_WON);

    }


}