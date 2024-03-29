package services.newScore;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
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

    @Test
    public void StartGameTieBreakAfterSixSixInSet_AndWonSet() {

        SetScore score = new SetScore();

        // score in set 6:6, that must start GameTieBreak
        score.setPlayerScore(0, 6);
        for (int i = 0; i < 23; i++) {
            score.pointWon(1);
        }
        log.info("Score first player -> {}", score.getPlayerScore(0));
        log.info("Score second player -> {}", score.getPlayerScore(1));
        assertThat(score.pointWon(1)).isEqualTo(State.ONGOING);
        log.info("==== Second player won point for 6:6 ====");
        log.info("Score first player -> {}", score.getPlayerScore(0));
        log.info("Score second player -> {}", score.getPlayerScore(1));

        // 13th game must be GameTieBreak
        assertThat(score.getPlayerScore(0).getClass()).isEqualTo(Integer.class);

        // check winning after 7 points won
        for (int i = 0; i < 6; i++) {
            score.pointWon(0);
        }
        assertThat(score.pointWon(0)).isEqualTo(State.PLAYER_ONE_WON);
        log.info("==== First player won tie-brake after 6:6 ====");
        log.info("Score first player -> {}", score.getPlayerScore(0));
        log.info("Score second player -> {}", score.getPlayerScore(1));


    }

}