package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CurrentMatch;
import services.FinishedMatchesPersistenceService;
import services.OngoingMatchesService;
import services.newScore.State;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/match-score")
public class MatchScoreServlet extends HttpServlet {

    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();
    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrentMatch currentMatch = ongoingMatchesService.getCurrentMatch(getUuid(req));
        req.setAttribute("currentMatch", currentMatch);
        req.getRequestDispatcher("/view/match-score.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        String win1 = req.getParameter("player-1");
        String win2 = req.getParameter("player-2");
        UUID uuidRow = UUID.fromString(uuid);

        CurrentMatch currentMatch = ongoingMatchesService.getCurrentMatch(uuidRow);

        if (win1 != null) {
            if (currentMatch.getMatchScore().pointWon(0) == State.PLAYER_ONE_WON) {
                currentMatch.setWinner(currentMatch.getFirstPlayer());
                finishedMatchesPersistenceService.persist(currentMatch);
            }
        } else {
            if (currentMatch.getMatchScore().pointWon(1) == State.PLAYER_TWO_WON) {
                currentMatch.setWinner(currentMatch.getSecondPlayer());
                finishedMatchesPersistenceService.persist(currentMatch);
            }
        }

        resp.sendRedirect("match-score?uuid=" + uuid);
    }

    private static UUID getUuid(HttpServletRequest req) {
        return UUID.fromString(req.getParameter("uuid"));
    }
}
