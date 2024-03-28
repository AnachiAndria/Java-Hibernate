/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import org.hibernate.Session;
import bean.Prof;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author ANDRIANANTENAINA
 */
public class ProfManager {
    public void ajouterProf(String nom, String prenom, String grade){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Prof p = new Prof();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setGrade(grade);
        session.save(p);
        session.getTransaction().commit();
    }
    public List<Prof> getAllData(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Prof> prof = new ArrayList<>();

        try {
            tx = session.beginTransaction();

            // Use HQL to get all employees
            Query query = session.createQuery("FROM Prof ORDER BY codeprof ASC");
            prof = query.list();

            // Commit the transaction
            tx.commit();

            System.out.println("Nombre de prof récupérés : " + prof);
            return prof;
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
        return prof;
    }
    public List<String>getNomProf(){
        
        return null;
    }
    
    public void supprimerProf(int codeprof){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Prof p = (Prof) session.load(Prof.class, codeprof);
        session.delete(p);
        session.getTransaction().commit();
    }
    
    public void modifierProf(int idProf, String nouveauNom, String nouveauPrenom, String nouveauGrade) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();

            // Récupérer le professeur à modifier
            Prof prof = (Prof) session.get(Prof.class, idProf);

            if (prof != null) {
                // Mettre à jour les propriétés du professeur
                prof.setNom(nouveauNom);
                prof.setPrenom(nouveauPrenom);
                prof.setGrade(nouveauGrade);

                // Enregistrer les modifications dans la base de données
                session.update(prof);
                tx.commit();
            } else {
                System.out.println("Le professeur avec l'ID " + idProf + " n'a pas été trouvé.");
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
    
    public List<Prof> rechercherProfesseurs(String searchQuery) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        List<Prof> listeProfs = new ArrayList<>();

        try {
            tx = session.beginTransaction();

            // Utiliser HQL pour rechercher les professeurs par code ou nom
            Query query = session.createQuery("FROM Prof WHERE codeprof = :params OR nom LIKE :paramsN");
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
