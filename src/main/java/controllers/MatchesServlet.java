package controllers;

import Utils.UtilMatches;
import dao.MatchesDao;
import entity.Match;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xalan.templates.ElemNumber;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/matches")
public class MatchesServlet extends HttpServlet {
    private final MatchesDao matchesDao = new MatchesDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filterName = req.getParameter("filter_by_player_name");
        List<Match> matches = matchesDao.getAll();
        List<Match> matchesToView;
        if (filterName == null || filterName.equals("")) {
            matchesToView = matches;
        } else {
            filterName = filterName.trim();
            matchesToView = UtilMatches.matchesWithName(matches, filterName);
        }
        Collections.reverse(matchesToView);

        int page = 0;
        int itemPerPage = 5;
        int qntOfPage = matchesToView.size() / itemPerPage + 1;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (matchesToView.size() > itemPerPage) {
            int startN = page * itemPerPage;
//            int el1 = (page + 1) * itemPerPage;
//            int el2 = qntOfPage * itemPerPage - matchesToView.size();
//            System.out.println("qntOfPage = " + qntOfPage);
//            System.out.println("page = " + page);
//            System.out.println("el1 = " + el1);
//            System.out.println("el2 = " + el2);
//            int endN = matchesToView.size() - el1 + el2;
            int endN;
            if (page + 1 != qntOfPage) {
                endN = itemPerPage * (page + 1);
            } else {
                endN = matchesToView.size();
            }
            matchesToView = matchesToView.subList(startN, endN);
        }

        req.setAttribute("qntOfPage", qntOfPage);
        req.setAttribute("currentPage", page);
        req.setAttribute("matches", matchesToView);
        req.getRequestDispatcher("/view/matches.jsp").forward(req, resp);
    }
}
