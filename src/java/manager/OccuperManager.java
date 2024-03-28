/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import org.hibernate.Session;
import bean.Occuper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author ANDRIANANTENAINA
 */
public class OccuperManager {
    public void ajouterOccuper(int codesal, String date,int h1,int h2,int h3,int h4,int h5,int h6){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Occuper o = new Occuper();
        o.setCodesal(codesal);
        o.setDatee(date);
        o.setH1(h1);
        o.setH2(h2);
        o.setH3(h3);
        o.setH4(h4);
        o.setH5(h5);
        o.setH6(h6);
        
        session.save(o);
        session.getTransaction().commit();
    }
    
    public void supprimerOccuper(int codeprof){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Occuper o = (Occuper) session.load(Occuper.class, codeprof);
        session.delete(o);
        session.getTransaction().commit();
    }
    
    public List<String> rechercherHoraires(int codeSalle, String date) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<String> horaires = null;

        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("SELECT o.h1, o.h2, o.h3, o.h4, o.h5, o.h6 FROM Occuper o WHERE o.codesal = :codesal AND o.datee = :date");
            query.setParameter("codesal", codeSalle);
            query.setParameter("date", date);
            
            // Exécuter la requête et obtenir les résultats sous forme de tableau d'objets
            Object[] results = (Object[]) query.uniqueResult();
            
            // Si les résultats ne sont pas vides, convertissez-les en liste de chaînes
            if (results != null) {
                horaires = Arrays.asList(Arrays.copyOf(results, results.length, String[].class));
            }


            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Log or handle the exception appropriately
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return horaires;
    }
    
    public List<Occuper> getAllData(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Occuper> occuper = new ArrayList<>();

        try {
            tx = session.beginTransaction();

            // Use HQL to get all employees
            Query query = session.createQuery("FROM Occuper ORDER BY datee ASC");
            occuper = query.list();

            // Commit the transaction
            tx.commit();

            System.out.println("Nombre de Occuper récupérés : " + occuper);
            return occuper;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Log or handle the exception appropriately
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        // Return an empty list in case of an exception
        return occuper;
    }
    
    public List<Object[]> getAllDataName(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Object[]> occuper = new ArrayList<>();

        try {
            tx = session.beginTransaction();

            // Use HQL to get all employees
            Query query = session.createQuery("SELECT o.codeocc, o.codesal, o.datee, o.h1, o.h2, o.h3, o.h4, o.h5, o.h6,\n" +
"       p1.nom AS nom_h1, p2.nom AS nom_h2, p3.nom AS nom_h3,\n" +
"       p4.nom AS nom_h4, p5.nom AS nom_h5, p6.nom AS nom_h6\n" +
"FROM OCCUPER o\n" +
"LEFT JOIN PROF p1 ON o.h1 = p1.codeprof\n" +
"LEFT JOIN PROF p2 ON o.h2 = p2.codeprof\n" +
"LEFT JOIN PROF p3 ON o.h3 = p3.codeprof\n" +
"LEFT JOIN PROF p4 ON o.h4 = p4.codeprof\n" +
"LEFT JOIN PROF p5 ON o.h5 = p5.codeprof\n" +
"LEFT JOIN PROF p6 ON o.h6 = p6.codeprof;");
            occuper = query.list();

            // Commit the transaction
            tx.commit();

            //System.out.println("Nombre de Occuper récupérés : " + occuper);
            return occuper;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Log or handle the exception appropriately
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        // Return an empty list in case of an exception
        return occuper;
    }
    
    public void modifierOccuper(int codesal, String datee,int h1,int h2,int h3,int h4,int h5,int h6) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();

            // Récupérer le professeur à modifier
            Occuper occuper = (Occuper) session.get(Occuper.class, codesal);

            if (occuper != null) {
                // Mettre à jour les propriétés du professeur
                occuper.setDatee(datee);
                occuper.setH1(h1);
                occuper.setH2(h2);
                occuper.setH3(h3);
                occuper.setH4(h4);
                occuper.setH5(h5);
                occuper.setH6(h6);

                // Enregistrer les modifications dans la base de données
                session.update(occuper);
                tx.commit();
            } else {
                System.out.println("Le professeur avec l'ID " + occuper + " n'a pas été trouvé.");
            }
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Log ou gérer l'exception de manière appropriée
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    
    
}
