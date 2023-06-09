package services;

import dao.MatchesDao;
import dao.PlayerDao;
import entity.Match;
import entity.Player;

import java.util.Optional;

public class FinishedMatchesPersistenceService {
    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();
    private final MatchesDao matchesDao = new MatchesDao();
    private final PlayerDao playerDao = new PlayerDao();

    public void persist(CurrentMatch currentMatch) {
        if (currentMatch.getStage() == MatchStage.END) {
            System.out.println(currentMatch);
            Optional<Player> firstPlayerOptional = playerDao.getByName(currentMatch.getFirstPlayer().getName());
            Player firstPlayer;
            if (firstPlayerOptional.isPresent()) {
                firstPlayer = firstPlayerOptional.get();
            } else {
                firstPlayer = playerDao.create(currentMatch.getFirstPlayer());
            }

            Optional<Player> secondPlayerOptional = playerDao.getByName(currentMatch.getSecondPlayer().getName());
            Player secondPlayer;
            if (secondPlayerOptional.isPresent()) {
                secondPlayer = secondPlayerOptional.get();
            } else {
                secondPlayer = playerDao.create(currentMatch.getSecondPlayer());
            }

            Player winner;
            if (currentMatch.getWinner().getName().equalsIgnoreCase(firstPlayer.getName())) {
                winner = firstPlayer;
            } else {
                winner = secondPlayer;
            }

            matchesDao.create(new Match(firstPlayer, secondPlayer, winner));
        }
    }

    public void removeCurrentEndMatch(CurrentMatch currentMatch) {
        if (currentMatch.getStage() == MatchStage.END) {
            ongoingMatchesService.getCurrentMatches().remove(currentMatch.getUuid());
        }
    }
}
