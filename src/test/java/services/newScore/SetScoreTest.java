package services.newScore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SetScoreTest {

    // imagine one player won 24 points (6 sets by 4 games), sets will be won after 24th game
    @Test
    public void TwentyFourPointsWin() {
        SetScore setScore = new SetScore();

        // win 23 points without win Set
        for (int j = 1; j < 24; j++) {
            assertThat(setScore.pointWon(0)).isEqualTo(State.ONGOING);
        }

        // won 24th point
        assertThat(setScore.pointWon(0)).isEqualTo(State.PLAYER_ONE_WON);
    }

}