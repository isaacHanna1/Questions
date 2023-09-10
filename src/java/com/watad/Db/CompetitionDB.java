package com.watad.Db;

import com.common.HibernateUtil;
import static com.watad.Db.UserDB.s;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.watad.model.Competition;

public class CompetitionDB {
    
        
  public static SessionFactory s = HibernateUtil.sessionFactory;
    
  public void addCompetition(Competition competition){
        
        Session session = s.openSession();
         session.beginTransaction();
         session.save(competition);
         session.getTransaction().commit();
         session.close();
  }
  
  public List<Competition> gettingAllCompetition(){
  
      Session session = s.openSession();
        session.beginTransaction();
        List <Competition> allCompetition = (List<Competition>)session.createQuery("from Competition").list();
        session.getTransaction().commit();
        session.close();
        return allCompetition;
    
  }
  public Competition getCompetition(int id){
      Session session = s.openSession();
         session.beginTransaction();
         Competition competition = (Competition) session.get(Competition.class, id);
         session.getTransaction().commit();
         session.close();
         return competition;
      
  }

    public void delete(Competition competition) {
        Session session = s.openSession();
        session.beginTransaction();
        session.delete(competition);
        session.getTransaction().commit();
        session.close();
    }
  
    public void edit(Competition c){
         Session session = s.openSession();
         session.beginTransaction();
         Competition oldCompetitiion = (Competition) session.get(Competition.class, c.getId());
         oldCompetitiion.setCompetitionName(c.getCompetitionName());
         oldCompetitiion.setAvaliable(c.isAvaliable());
         session.update(oldCompetitiion);
         session.getTransaction().commit();
         session.close();
    }
  
}
