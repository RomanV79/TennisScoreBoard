package Utils;

import entity.Match;

import java.util.List;
import java.util.stream.Collectors;

public class UtilMatches {

    public static List<Match> matchesWithName(List<Match> matches, String name){
        return matches.stream().filter(m->
                (m.getPlayer1().getName().equalsIgnoreCase(name) || m.getPlayer2().getName().equalsIgnoreCase(name)))
                .collect(Collectors.toList());
    }
}
