package controllers;

import entity.Player;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CurrentMatch;
import services.OngoingMatchesService;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/new-match")
public class NewMatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/new-match.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerOne = req.getParameter("player-1");
        String playerTwo = req.getParameter("player-2");
        Player firstPlayer = new Player(playerOne.toUpperCase());
        Player secondPlayer = new Player(playerTwo.toUpperCase());
        UUID uuid = UUID.randomUUID();

        CurrentMatch currentMatch = new CurrentMatch(uuid, firstPlayer, secondPlayer);
        OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
        ongoingMatchesService.addMatchList(currentMatch);

        resp.sendRedirect("match-score?uuid=" + uuid);
    }
}
