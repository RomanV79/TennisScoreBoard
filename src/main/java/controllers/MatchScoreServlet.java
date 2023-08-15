package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.*;
import services.score.PlayerEnum;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/match-score")
public class MatchScoreServlet extends HttpServlet {

    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();
    private final MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();
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

        PlayerEnum playerEnum;
        if (win1 != null) {
            playerEnum = PlayerEnum.FIRST_PLAYER;
            currentMatch.getMatchScore().pointWon(0);
        } else {
            playerEnum = PlayerEnum.SECOND_PLAYER;
            currentMatch.getMatchScore().pointWon(1);
        }


        matchScoreCalculationService.winPoint(currentMatch, playerEnum);
        resp.sendRedirect("match-score?uuid=" + uuid);
        if (currentMatch.getStage() == MatchStage.END) {
            finishedMatchesPersistenceService.persist(currentMatch);
        }
    }

    private static UUID getUuid(HttpServletRequest req) {
        return UUID.fromString(req.getParameter("uuid"));
    }
}
