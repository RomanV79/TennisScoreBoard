package services;

import services.score.PlayerEnum;
import services.score.ScorePointEnum;

import static services.score.PlayerEnum.FIRST_PLAYER;
import static services.score.PlayerEnum.SECOND_PLAYER;
import static services.score.ScorePointEnum.*;

public class MatchScoreCalculationService {
    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();

    public void winPoint(CurrentMatch currentMatch, PlayerEnum playerEnum){
        ScorePointEnum scorePointEnumFirstPlayer = currentMatch.getFirstScore().getScorePoint();
        ScorePointEnum scorePointEnumSecondPlayer = currentMatch.getSecondScore().getScorePoint();

        if (playerEnum == FIRST_PLAYER) {
            if (scorePointEnumSecondPlayer != FORTY && scorePointEnumSecondPlayer != ADV){
                countedNextPointFirstPlayer(currentMatch);
            }
            if (scorePointEnumSecondPlayer == FORTY && scorePointEnumFirstPlayer != FORTY && scorePointEnumFirstPlayer != ADV) {
                countedNextPointFirstPlayer(currentMatch);
            }
            if (scorePointEnumSecondPlayer == FORTY && scorePointEnumFirstPlayer == FORTY) {
                currentMatch.getFirstScore().setADV();
            }
            if (scorePointEnumSecondPlayer == FORTY && scorePointEnumFirstPlayer == ADV) {
                currentMatch.getFirstScore().setWIN();
            }
            if (scorePointEnumSecondPlayer == ADV) {
                currentMatch.getSecondScore().setFORTY();
            }


            if (isFirstPlayerWinGame(currentMatch)) {
                currentMatch.getFirstScore().appendGame();
                setZeroPointForAll(currentMatch);
            }

            if (isFirstPlayerWinSet(currentMatch)) {
                currentMatch.getFirstScore().appendWonSet();
                saveSetResult(currentMatch);
                setZeroGameForAll(currentMatch);
            }

        }

        if (playerEnum == SECOND_PLAYER) {
            if (scorePointEnumFirstPlayer != FORTY && scorePointEnumFirstPlayer != ADV){
                countedNextPointSecondPlayer(currentMatch);
            }
            if (scorePointEnumFirstPlayer == FORTY && scorePointEnumSecondPlayer != FORTY && scorePointEnumSecondPlayer != ADV) {
                countedNextPointSecondPlayer(currentMatch);
            }
            if (scorePointEnumFirstPlayer == FORTY && scorePointEnumSecondPlayer == FORTY) {
                currentMatch.getSecondScore().setADV();
            }
            if (scorePointEnumFirstPlayer == FORTY && scorePointEnumSecondPlayer == ADV) {
                currentMatch.getSecondScore().setWIN();
            }
            if (scorePointEnumFirstPlayer == ADV) {
                currentMatch.getFirstScore().setFORTY();
            }

            if (isSecondPlayerWinGame(currentMatch)) {
                currentMatch.getSecondScore().appendGame();
                setZeroPointForAll(currentMatch);
            }

            if (isSecondPlayerWinSet(currentMatch)) {
                currentMatch.getSecondScore().appendWonSet();
                saveSetResult(currentMatch);
                setZeroGameForAll(currentMatch);
            }
        }


    }

    private static void countedNextPointFirstPlayer(CurrentMatch currentMatch) {
        currentMatch.getFirstScore().appendPoint();
    }
    private static void countedNextPointSecondPlayer(CurrentMatch currentMatch) {
        currentMatch.getSecondScore().appendPoint();
    }
    private static boolean isFirstPlayerWinGame(CurrentMatch currentMatch) {
        return currentMatch.getFirstScore().getScorePoint().equals(WIN);
    }
    private static boolean isSecondPlayerWinGame(CurrentMatch currentMatch) {
        return currentMatch.getSecondScore().getScorePoint().equals(WIN);
    }
    private static boolean isFirstPlayerWinSet(CurrentMatch currentMatch) {
        return ((currentMatch.getFirstScore().getScoreGame() == 6 && currentMatch.getSecondScore().getScoreGame() < 5)
                || (currentMatch.getFirstScore().getScoreGame() == 7));
    }
    private static boolean isSecondPlayerWinSet(CurrentMatch currentMatch) {
        return ((currentMatch.getSecondScore().getScoreGame() == 6 && currentMatch.getFirstScore().getScoreGame() < 5)
                || (currentMatch.getSecondScore().getScoreGame() == 7));
    }
    private void setZeroPointForAll(CurrentMatch currentMatch){
        currentMatch.getFirstScore().setScorePoint(ZERO);
        currentMatch.getSecondScore().setScorePoint(ZERO);
    }
    private void setZeroGameForAll(CurrentMatch currentMatch){
        currentMatch.getFirstScore().setScoreGame(0);
        currentMatch.getSecondScore().setScoreGame(0);
    }
    private void saveSetResult(CurrentMatch currentMatch){
        currentMatch.getFirstScore().getListSet().add(currentMatch.getFirstScore().getScoreGame());
        currentMatch.getSecondScore().getListSet().add(currentMatch.getSecondScore().getScoreGame());
    }
}
