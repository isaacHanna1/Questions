
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class test {
    
    public static void main(String[] args) {
            
          Configuration config = new Configuration();
  config.configure();
  // local SessionFactory bean created
  SessionFactory sessionFactory = config.buildSessionFactory();
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  session.getTransaction();
  session.close();
        
    }
}
