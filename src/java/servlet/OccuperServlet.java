package servlet;

import bean.Occuper;
import bean.Prof;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import manager.OccuperManager;
import manager.ProfManager;

@WebServlet(name = "OccuperServlet", urlPatterns = {"/occuper"})
public class OccuperServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("La méthode doGet() de MonServlet est appelée.");
        String id = request.getParameter("id");//<!-- codeocc -->
        String datee = request.getParameter("datee");
        int H1 = (request.getParameter("heur1") == null || request.getParameter("heur1").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur1")) ;
        int H2 = (request.getParameter("heur2") == null || request.getParameter("heur2").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur2")) ;
        int H3 = (request.getParameter("heur3") == null || request.getParameter("heur3").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur3")) ;
        int H4 = (request.getParameter("heur4") == null || request.getParameter("heur4").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur4")) ;
        int H5 = (request.getParameter("heur5") == null || request.getParameter("heur5").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur5")) ;
        int H6 = (request.getParameter("heur6") == null || request.getParameter("heur6").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur6")) ;
        if(request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
            OccuperManager occuperManager = new OccuperManager();
            occuperManager.modifierOccuper(Integer.parseInt(id), datee, H1, H2, H3, H4, H5, H6);
        }
        
        OccuperManager occupermanager = new OccuperManager();
        ProfManager profManager = new ProfManager();
        List<Prof> listeProfs = profManager.getAllData();
        request.setAttribute("listeProfs1", listeProfs);
        
            List<Occuper> listeSalle = occupermanager.getAllData();
            request.setAttribute("listeSalle", listeSalle);
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("occuper.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OccuperManager occuperManager = new OccuperManager();
        
        String id = request.getParameter("id");
        String action = request.getParameter("action");
        String maj = request.getParameter("maj");
        String datee = request.getParameter("datee");
        int H1 = (request.getParameter("heur1") == null || request.getParameter("heur1").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur1")) ;
        int H2 = (request.getParameter("heur2") == null || request.getParameter("heur2").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur2")) ;
        int H3 = (request.getParameter("heur3") == null || request.getParameter("heur3").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur3")) ;
        int H4 = (request.getParameter("heur4") == null || request.getParameter("heur4").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur4")) ;
        int H5 = (request.getParameter("heur5") == null || request.getParameter("heur5").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur5")) ;
        int H6 = (request.getParameter("heur6") == null || request.getParameter("heur6").isEmpty())? 0 : Integer.parseInt(request.getParameter("heur6")) ;
        String toDel = request.getParameter("idSalleToDelete");
        System.out.println(maj);
        
        if(request.getParameter("action")!=null){
            if(request.getParameter("idSalleToDelete") != null || !request.getParameter("idSalleToDelete").isEmpty()){
                occuperManager.supprimerOccuper(Integer.parseInt(toDel));
                
                OccuperManager occupermanager = new OccuperManager();
        ProfManager profManager = new ProfManager();
        List<Prof> listeProfs = profManager.getAllData();
        request.setAttribute("listeProfs1", listeProfs);
        
            List<Occuper> listeSalle = occupermanager.getAllData();
            request.setAttribute("listeSalle", listeSalle);
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("occuper.jsp");
        dispatcher.forward(request, response);
            }
            
        }else if(maj == null || maj.isEmpty()){ //ajout
            if(datee != null || !datee.isEmpty()){
                int codesal = Integer.parseInt(id);
                occuperManager.ajouterOccuper(codesal, datee, H1, H2, H3, H4, H5, H6);

                OccuperManager occupermanager = new OccuperManager();
        ProfManager profManager = new ProfManager();
        List<Prof> listeProfs = profManager.getAllData();
        request.setAttribute("listeProfs1", listeProfs);
        
            List<Occuper> listeSalle = occupermanager.getAllData();
            request.setAttribute("listeSalle", listeSalle);
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("occuper.jsp");
        dispatcher.forward(request, response);
            }
        }
        /*SalleManager salleManager = new SalleManager();

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
        
        List<Salle> listeSalle = salleManager.getAllData();
        request.setAttribute("listeSalle", listeSalle);
        RequestDispatcher dispatcher = request.getRequestDispatcher("occuper.jsp");
        dispatcher.forward(request, response);*/
    }
}
