package services;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchesService {
    private static final OngoingMatchesService INSTANCE = new OngoingMatchesService();
    private OngoingMatchesService(){}
    private final Map<UUID, CurrentMatch> currentMatches = new ConcurrentHashMap<>();

    public static OngoingMatchesService getInstance() {
        return INSTANCE;
    }

    public void addMatchList(CurrentMatch currentMatch) {
        currentMatches.put(currentMatch.getUuid(), currentMatch);
    }
}
