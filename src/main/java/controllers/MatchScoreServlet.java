package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CurrentMatch;
import services.MatchScoreCalculationService;
import services.OngoingMatchesService;
import services.score.PlayerEnum;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/match-score")
public class MatchScoreServlet extends HttpServlet {

    private OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();
    private final MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();
    CurrentMatch currentMatch;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentMatch = ongoingMatchesService.getCurrentMatch(getUuid(req));
        System.out.println("Log #5: " + currentMatch);
        req.setAttribute("currentMatch", currentMatch);
        req.getRequestDispatcher("/view/match-score.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        String win1 = req.getParameter("player-1");
        String win2 = req.getParameter("player-2");
        UUID uuidRow = UUID.fromString(uuid);

        System.out.println(win1);
        System.out.println(win2);
        System.out.println(uuid);

        PlayerEnum playerEnum;
        if (win1 != null) {
            playerEnum = PlayerEnum.FIRST_PLAYER;
        } else {
            playerEnum = PlayerEnum.SECOND_PLAYER;
        }
        currentMatch = ongoingMatchesService.getCurrentMatch(uuidRow);
        System.out.println("Log #4: " + currentMatch);
        matchScoreCalculationService.winPoint(currentMatch, playerEnum);
        req.setAttribute("currentMatch", currentMatch);
        resp.sendRedirect("match-score?uuid=" + uuid);

    }

    private static UUID getUuid(HttpServletRequest req) {
        return UUID.fromString(req.getParameter("uuid"));
    }
}
