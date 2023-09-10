
package com.watad.Db;
import static com.watad.Db.QuestionDB.s;
import com.watad.model.Points;
import com.watad.model.Question;
import org.hibernate.Session;

public class PointDB {
    
    
    public void saveInPoint(Points p){
              Session session = s.openSession();
              session.beginTransaction();
              session.save(p);
              session.getTransaction().commit();
              session.close();
    }
}
