package services;

import services.score.PlayerEnum;
import services.score.ScorePointEnum;

public class MatchScoreCalculationService {
    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();

    public void winPoint(CurrentMatch currentMatch, PlayerEnum playerEnum){
        countedNextPoint(currentMatch, playerEnum);

        if (isFirstPlayerWinGame(currentMatch)) {
            currentMatch.getFirstScore().appendGame();
            currentMatch.getFirstScore().setScorePoint(ScorePointEnum.ZERO);
        }
        if (isSecondPlayerWinGame(currentMatch)) {
            currentMatch.getSecondScore().appendGame();
            currentMatch.getSecondScore().setScorePoint(ScorePointEnum.ZERO);
        }

        if (isFirstPlayerWinSet(currentMatch) || isSecondPlayerWinSet(currentMatch)) {
            currentMatch.getFirstScore().getListSet().add(currentMatch.getFirstScore().getScoreGame());
            currentMatch.getSecondScore().getListSet().add(currentMatch.getSecondScore().getScoreGame());

            currentMatch.getFirstScore().setScoreGame(0);
            currentMatch.getSecondScore().setScoreGame(0);
        }





    }

    private static void countedNextPoint(CurrentMatch currentMatch, PlayerEnum playerEnum) {
        if (playerEnum == PlayerEnum.FIRST_PLAYER) {
            currentMatch.getFirstScore().appendPoint();
        }
        if (playerEnum == PlayerEnum.SECOND_PLAYER) {
            currentMatch.getSecondScore().appendPoint();
        }
    }

    private static boolean isFirstPlayerWinGame(CurrentMatch currentMatch) {
        return currentMatch.getFirstScore().getScorePoint().equals(ScorePointEnum.WIN);
    }
    private static boolean isSecondPlayerWinGame(CurrentMatch currentMatch) {
        return currentMatch.getSecondScore().getScorePoint().equals(ScorePointEnum.WIN);
    }

    private static boolean isFirstPlayerWinSet(CurrentMatch currentMatch) {
        return ((currentMatch.getFirstScore().getScoreGame() == 6 && currentMatch.getSecondScore().getScoreGame() < 5)
                || (currentMatch.getFirstScore().getScoreGame() == 7));
    }
    private static boolean isSecondPlayerWinSet(CurrentMatch currentMatch) {
        return ((currentMatch.getSecondScore().getScoreGame() == 6 && currentMatch.getFirstScore().getScoreGame() < 5)
                || (currentMatch.getSecondScore().getScoreGame() == 7));
    }





}
