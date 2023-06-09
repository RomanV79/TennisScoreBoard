package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CurrentMatch;
import services.FinishedMatchesPersistenceService;
import services.MatchScoreCalculationService;
import services.OngoingMatchesService;
import services.score.PlayerEnum;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/match-score")
public class MatchScoreServlet extends HttpServlet {

    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();
    private final MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();
    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService();
    CurrentMatch currentMatch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentMatch = ongoingMatchesService.getCurrentMatch(getUuid(req));
        req.setAttribute("currentMatch", currentMatch);
        req.getRequestDispatcher("/view/match-score.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        String win1 = req.getParameter("player-1");
        String win2 = req.getParameter("player-2");
        UUID uuidRow = UUID.fromString(uuid);

        PlayerEnum playerEnum;
        if (win1 != null) {
            playerEnum = PlayerEnum.FIRST_PLAYER;
        } else {
            playerEnum = PlayerEnum.SECOND_PLAYER;
        }
        currentMatch = ongoingMatchesService.getCurrentMatch(uuidRow);
        matchScoreCalculationService.winPoint(currentMatch, playerEnum);
        resp.sendRedirect("match-score?uuid=" + uuid);
        finishedMatchesPersistenceService.persist(currentMatch);
//        finishedMatchesPersistenceService.removeCurrentEndMatch(currentMatch);

    }

    private static UUID getUuid(HttpServletRequest req) {
        return UUID.fromString(req.getParameter("uuid"));
    }
}
