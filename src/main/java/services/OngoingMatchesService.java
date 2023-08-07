package services;

import entity.Player;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchesService {
    private static final OngoingMatchesService INSTANCE = new OngoingMatchesService();
    private final Map<UUID, CurrentMatch> currentMatches = new ConcurrentHashMap<>();

    private OngoingMatchesService() {
    }

    public static OngoingMatchesService getOngoingMatchesService(){
        return INSTANCE;
    }


    public void createNewMatch(UUID uuid, Player firstPlayer, Player secondPlayer) {
        CurrentMatch currentMatch = new CurrentMatch(uuid, firstPlayer, secondPlayer);
        currentMatches.put(uuid, currentMatch);
    }

    public Map<UUID, CurrentMatch> getCurrentMatches() {
        return currentMatches;
    }

    public CurrentMatch getCurrentMatch(UUID uuid) {
        return currentMatches.get(uuid);
    }

}
