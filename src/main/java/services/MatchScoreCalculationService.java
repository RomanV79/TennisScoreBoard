package services;

import services.score.PlayerEnum;
import services.score.ScorePointEnum;

public class MatchScoreCalculationService {
    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();

    public void winPoint(CurrentMatch currentMatch, PlayerEnum playerEnum){
        if (playerEnum == PlayerEnum.FIRST_PLAYER) {
            currentMatch.getFirstScore().getScorePoint().nextPoint();
        }
        if (playerEnum == PlayerEnum.SECOND_PLAYER) {
            currentMatch.getSecondScore().getScorePoint().nextPoint();
        }

        System.out.println("Log #6: " + currentMatch.getSecondScore().getScorePoint());

        if (currentMatch.getSecondScore().getScorePoint().equals(ScorePointEnum.WIN)) {

        }
    }
}
