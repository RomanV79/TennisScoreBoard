package services;

import services.score.PlayerEnum;
import services.score.ScorePointEnum;

import static services.MatchStage.*;
import static services.score.PlayerEnum.*;
import static services.score.ScorePointEnum.*;

public class MatchScoreCalculationService {

    public void winPoint(CurrentMatch currentMatch, PlayerEnum playerEnum){
        ScorePointEnum scorePointEnumFirstPlayer = currentMatch.getFirstScore().getScorePoint();
        ScorePointEnum scorePointEnumSecondPlayer = currentMatch.getSecondScore().getScorePoint();

        if (playerEnum == FIRST_PLAYER) {
            if (currentMatch.getStage() == NORMAL) {
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
            }

            if (currentMatch.getStage() == MatchStage.TIEBREAK){
                currentMatch.getFirstScore().appendTieBreakPoint();
            }

            if (isFirstPlayerWinGame(currentMatch)) {
                currentMatch.getFirstScore().appendGame();
                setZeroPointForAll(currentMatch);
                currentMatch.setServeFirstPlayer(!currentMatch.isServeFirstPlayer());
            }

            if (isFirstPlayerWinSet(currentMatch)) {
                currentMatch.getFirstScore().appendWonSet();
                saveSetResult(currentMatch);
                setZeroGameForAll(currentMatch);
                currentMatch.setStage(NORMAL);
            }
        }

        if (playerEnum == SECOND_PLAYER) {
            if (currentMatch.getStage() == NORMAL) {
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
            }

            if (currentMatch.getStage() == TIEBREAK){
                currentMatch.getSecondScore().appendTieBreakPoint();
            }

            if (isSecondPlayerWinGame(currentMatch)) {
                currentMatch.getSecondScore().appendGame();
                setZeroPointForAll(currentMatch);
                currentMatch.setServeFirstPlayer(!currentMatch.isServeFirstPlayer());
            }

            if (isSecondPlayerWinSet(currentMatch)) {
                currentMatch.getSecondScore().appendWonSet();
                saveSetResult(currentMatch);
                setZeroGameForAll(currentMatch);
                currentMatch.setStage(NORMAL);
            }
        }

        if (currentMatch.getFirstScore().getScoreGame() == 6 && currentMatch.getSecondScore().getScoreGame() == 6) {
            currentMatch.setStage(TIEBREAK);
        }
        if (isMatchEnd(currentMatch)) {
            currentMatch.setStage(END);
            if (currentMatch.getFirstScore().getWonSet() == currentMatch.getSetForWin()) currentMatch.setWinner(currentMatch.getFirstPlayer());
            if (currentMatch.getSecondScore().getWonSet() == currentMatch.getSetForWin()) currentMatch.setWinner(currentMatch.getSecondPlayer());
        }
    }

    private static void countedNextPointFirstPlayer(CurrentMatch currentMatch) {
        currentMatch.getFirstScore().appendPoint();
    }
    private static void countedNextPointSecondPlayer(CurrentMatch currentMatch) {
        currentMatch.getSecondScore().appendPoint();
    }
    private static boolean isFirstPlayerWinGame(CurrentMatch currentMatch) {
        return currentMatch.getFirstScore().getScorePoint() == WIN
                || (currentMatch.getFirstScore().getScoreTieBreak() >= 7
                    && (currentMatch.getFirstScore().getScoreTieBreak() - currentMatch.getSecondScore().getScoreTieBreak()) > 1);
    }
    private static boolean isSecondPlayerWinGame(CurrentMatch currentMatch) {
        return currentMatch.getSecondScore().getScorePoint() == WIN
                || (currentMatch.getSecondScore().getScoreTieBreak() >= 7
                && (currentMatch.getSecondScore().getScoreTieBreak() - currentMatch.getFirstScore().getScoreTieBreak()) > 1);
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
        currentMatch.getFirstScore().setScoreTieBreak(0);
        currentMatch.getSecondScore().setScoreTieBreak(0);
    }
    private void saveSetResult(CurrentMatch currentMatch){
        currentMatch.getFirstScore().getListSet().add(currentMatch.getFirstScore().getScoreGame());
        currentMatch.getSecondScore().getListSet().add(currentMatch.getSecondScore().getScoreGame());
    }
    private static boolean isMatchEnd(CurrentMatch currentMatch){
        return currentMatch.getFirstScore().getWonSet() == currentMatch.getSetForWin()
                || currentMatch.getSecondScore().getWonSet() == currentMatch.getSetForWin();
    }

}
