package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ANDRIANANTENAINA
 */


public class HibernateUtil{
    
    public static final SessionFactory sessionFactory;
    
    static{
        try{
            sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        }catch(Throwable ex){
            System.err.println("SessionFactory creation failed: " +ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
