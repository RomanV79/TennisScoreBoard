package services;

import dao.MatchesDao;
import dao.PlayerDao;
import entity.Match;
import entity.Player;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class FinishedMatchesPersistenceService {
    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();
    private final MatchesDao matchesDao = new MatchesDao();
    private final PlayerDao playerDao = new PlayerDao();

    public void persist(CurrentMatch currentMatch) {
        log.info("Start persist first player -> {}", currentMatch.getFirstPlayer());
        Player firstPlayer = null;
        try {
            firstPlayer = playerDao.create(currentMatch.getFirstPlayer());
        } catch (Exception e) {
            Optional<Player> player = playerDao.getByName(currentMatch.getFirstPlayer().getName());
            if (player.isPresent()) {
                firstPlayer = player.get();
            }
        }
        log.info("Successful create first player -> {}", firstPlayer);

        log.info("Start persist second player -> {}", currentMatch.getSecondPlayer());
        Player secondPlayer = null;
        try {
            secondPlayer = playerDao.create(currentMatch.getSecondPlayer());
        } catch (Exception e) {
            Optional<Player> player = playerDao.getByName(currentMatch.getSecondPlayer().getName());
            if (player.isPresent()) {
                secondPlayer = player.get();
            }
        }
        log.info("Successful create second player -> {}", secondPlayer);

        Player winner;
        if (currentMatch.getWinner().getName().equalsIgnoreCase(firstPlayer.getName())) {
            winner = firstPlayer;
        } else {
            winner = secondPlayer;
        }

        matchesDao.create(new Match(firstPlayer, secondPlayer, winner));
    }
}
