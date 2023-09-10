package com.common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory  sessionFactory; 
    static{
        try{
            
    /* session factory was built to mange connection to database 
      and to create .... manuplating queries ;
   */
        sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
