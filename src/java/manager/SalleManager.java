/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import org.hibernate.Session;
import bean.Salle;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author ANDRIANANTENAINA
 */
public class SalleManager {
    public void ajouterSalle(String designation){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Salle s = new Salle();
        s.setDesignation(designation);
        session.save(s);
        session.getTransaction().commit();
    }
    
    public void supprimerSalle(int codesal){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Salle s = (Salle) session.load(Salle.class, codesal);
        session.delete(s);
        session.getTransaction().commit();
    }
    
    public List<Salle> getAllData(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Salle> salle = new ArrayList<>();

        try {
            tx = session.beginTransaction();

            // Use HQL to get all employees
            Query query = session.createQuery("FROM Salle ORDER BY codesal ASC");
            salle = query.list();

            // Commit the transaction
            tx.commit();

            System.out.println("Nombre de prof récupérés : " + salle);
            return salle;
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
        return salle;
    }
    
    public void modifierSalle(int idSalle, String description) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();

            // Récupérer le professeur à modifier
            Salle salle = (Salle) session.get(Salle.class, idSalle);

            if (salle != null) {
                // Mettre à jour les propriétés du professeur
                salle.setDesignation(description);
                // Enregistrer les modifications dans la base de données
                session.update(salle);
                tx.commit();
            } else {
                System.out.println("Le professeur avec l'ID " + idSalle + " n'a pas été trouvé.");
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
    
    
    public List<Salle> rechercherProfesseurs(String searchQuery) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Salle> listeProfs = new ArrayList<>();

        try {
            tx = session.beginTransaction();

            // Utiliser HQL pour rechercher les professeurs par code ou nom
            Query query = session.createQuery("FROM occuper where codesal = :codesal and datee = :date");
            query.setParameter("paramsN", "%" + searchQuery + "%");
            try {
                int codeprof = Integer.parseInt(searchQuery);
                query.setParameter("params", codeprof); // Recherche par codeprof (convertir en entier)
            } catch (NumberFormatException e) {
                query.setParameter("params", 0);
            }
            listeProfs = query.list();

            tx.commit();

            System.out.println("Nombre de professeurs trouvés : " + listeProfs.size());
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(); // Gérer l'exception de manière appropriée
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return listeProfs;
    }
    
    
}
