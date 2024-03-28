package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import bean.Prof;
import bean.Salle;
import manager.ProfManager;
import manager.SalleManager;

public class SalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            SalleManager salleManager = new SalleManager();
            // Si aucun paramètre de recherche n'est fourni, récupérer tous les professeurs
            List<Salle> listeSalle = salleManager.getAllData();
            request.setAttribute("listeSalle", listeSalle);
            
            ProfManager profManager = new ProfManager();
            List<Prof> listeProfs = profManager.getAllData();
            request.setAttribute("listeProfs1", listeProfs);
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("salle.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String description = request.getParameter("description");
        String action = request.getParameter("action");
        SalleManager salleManager = new SalleManager();

        if (action != null && action.equals("supprimer")) {
            // Suppression
            int idSalleToDelete = Integer.parseInt(request.getParameter("idSalleToDelete"));
            salleManager.supprimerSalle(idSalleToDelete);
        } else if (id != null && !id.isEmpty()) {
            // Mise à jour
            int idSalle = Integer.parseInt(id);
            salleManager.modifierSalle(idSalle, description);
        } else if (description != null && !description.isEmpty()) {
            // Ajout
            salleManager.ajouterSalle(description);
        }
        
        ProfManager profManager = new ProfManager();
            List<Prof> listeProfs = profManager.getAllData();
            request.setAttribute("listeProfs1", listeProfs);
        List<Salle> listeSalle = salleManager.getAllData();
        request.setAttribute("listeSalle", listeSalle);
        RequestDispatcher dispatcher = request.getRequestDispatcher("salle.jsp");
        dispatcher.forward(request, response);
    }
}
