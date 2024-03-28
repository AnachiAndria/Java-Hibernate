/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.OccuperManager;

/**
 *
 * @author ANDRIANANTENAINA
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
//@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres de la requête
        String id = request.getParameter("codesal");
        String date = request.getParameter("date");

        // Utiliser les paramètres pour effectuer la recherche
        OccuperManager occuperManager = new OccuperManager();
        List<String> horaires = occuperManager.rechercherHoraires(Integer.parseInt(id), date);

        // Créer un objet JSON à partir des horaires récupérés
        Gson gson = new Gson();
        String json = gson.toJson(horaires);

        // Envoyer la réponse JSON au client
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
