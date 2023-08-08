package controllers;

import Utils.UtilMatches;
import dao.MatchesDao;
import entity.Match;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/matches")
public class MatchesServlet extends HttpServlet {
    private final MatchesDao matchesDao = new MatchesDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filterName = req.getParameter("filter_by_player_name");

        List<Match> matches;
        if (filterName == null || filterName.trim().equals("")) {
            matches = matchesDao.getAll();
        } else {
            matches = matchesDao.getByPlayerName(filterName);
        }
        Collections.reverse(matches);

        int page = 0;
        int itemPerPage = 5;
        int qntOfPage = matches.size() / itemPerPage + 1;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (matches.size() > itemPerPage) {
            int startN = page * itemPerPage;
            int endN;
            if (page + 1 != qntOfPage) {
                endN = itemPerPage * (page + 1);
            } else {
                endN = matches.size();
            }
            matches = matches.subList(startN, endN);
        }

        req.setAttribute("qntOfPage", qntOfPage);
        req.setAttribute("currentPage", page);
        req.setAttribute("matches", matches);
        req.getRequestDispatcher("/view/matches.jsp").forward(req, resp);
    }
}
