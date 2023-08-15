package services.newScore;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MatchScoreTest {

    @Test
    public void winMatch() {
        //match form 3 sets, need win 2 for victory
        MatchScore match = new MatchScore(2);

        // first player won 1st set (24 games), and match ONGOING
        for (int i = 0; i < 23; i++) {
            match.pointWon(0);
        }
        assertThat(match.pointWon(0)).isEqualTo(State.ONGOING);
        log.info("First player won 1st set");
        log.info("Score first player -> {}", match.getPlayerScore(0));
        log.info("Score second player -> {}", match.getPlayerScore(1));

        // first player won 2nd set (next 24 games), and first player win match
        for (int i = 0; i < 23; i++) {
            match.pointWon(0);
        }
        assertThat(match.pointWon(0)).isEqualTo(State.PLAYER_ONE_WON);
        log.info("First player won 2nd set");
        log.info("Score first player -> {}", match.getPlayerScore(0));
        log.info("Score second player -> {}", match.getPlayerScore(1));
    }
}