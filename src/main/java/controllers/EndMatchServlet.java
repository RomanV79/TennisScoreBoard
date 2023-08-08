package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.OngoingMatchesService;

import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/end-match")
public class EndMatchServlet extends HttpServlet {

    private final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getOngoingMatchesService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        ongoingMatchesService.remove(UUID.fromString(uuid));
        resp.sendRedirect("index.jsp");

    }
}
