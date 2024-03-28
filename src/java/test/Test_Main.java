/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import bean.Occuper;
import bean.Prof;
import com.google.gson.Gson;
import java.util.List;
import manager.OccuperManager;
import util.HibernateUtil;
import manager.ProfManager;
import manager.SalleManager;
/**
 *
 * @author ANDRIANANTENAINA
 */
public class Test_Main { 
    public static void main(String[] args){
        /*ProfManager profManager = new ProfManager();
        List<Prof> listeProfs = profManager.rechercherProfesseurs("andrana");
        System.out.println("test : " + listeProfs);*/
        
        /*OccuperManager occuperManager = new OccuperManager();
        List<String> horaires = occuperManager.rechercherHoraires(2,"2024-03-20");
        // Créer un objet JSON à partir des horaires récupérés
        Gson gson = new Gson();
        String json = gson.toJson(horaires);*/
        // Envoyer la réponse JSON au client
        OccuperManager occupermanager = new OccuperManager();
        occupermanager.getAllData();
        //System.out.println("test : " + occuper);
    }
}
