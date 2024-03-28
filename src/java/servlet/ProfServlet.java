package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import bean.Prof;
import javax.servlet.annotation.WebServlet;
import manager.ProfManager;


@WebServlet(name = "ProfServlet", urlPatterns = {"/Prof"})
public class ProfServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("La méthode doGet() de MonServlet est appelée.");
    ProfManager profManager = new ProfManager();
    
    // Récupérer le paramètre de recherche
    String searchQuery = request.getParameter("search");
    
    // Vérifier si un paramètre de recherche est fourni
    if (searchQuery != null && !searchQuery.isEmpty()) {
        // Effectuer la recherche en fonction du code ou du nom du professeur
        List<Prof> listeProfs = profManager.rechercherProfesseurs(searchQuery);
        request.setAttribute("listeProfs", listeProfs);
    } else {
        // Si aucun paramètre de recherche n'est fourni, récupérer tous les professeurs
        List<Prof> listeProfs = profManager.getAllData();
        request.setAttribute("listeProfs", listeProfs);
    }
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("prof.jsp");
    dispatcher.forward(request, response);
}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("La méthode doPost() de MonServlet est appelée.");

        // Récupérer les paramètres de la requête
        String Action = request.getParameter("action");
        String idProf = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String grade = request.getParameter("grade");

        // Utiliser les paramètres pour modifier l'enregistrement dans la base de données
        ProfManager profManager = new ProfManager();
        
        if (request.getParameter("action") != null && request.getParameter("action").equals("supprimer")) {
            // Récupérer l'ID du professeur à supprimer
            int idProfToDelete = Integer.parseInt(request.getParameter("idProfToDelete"));
            profManager.supprimerProf(idProfToDelete);
        }
        else if((idProf == null || idProf.isEmpty()) && (nom == null || nom.isEmpty()) && (prenom == null || prenom.isEmpty())){
            
        }
        else if (idProf == null || idProf.isEmpty()) {
            profManager.ajouterProf(nom, prenom, grade);
        } else {
            profManager.modifierProf(Integer.parseInt(idProf), nom, prenom, grade);
        }


        // Rediriger l'utilisateur vers la page Prof
        List<Prof> listeProfs = profManager.getAllData();
        request.setAttribute("listeProfs", listeProfs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("prof.jsp");
        dispatcher.forward(request, response);
    }

}
