package com.watad.Db;

import com.common.HibernateUtil;
import com.watad.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDB {
    
    public static SessionFactory s = HibernateUtil.sessionFactory;
    
    
    public void saveUser(User user){
         Session session = s.openSession();
         session.beginTransaction();
         session.save(user);
         session.getTransaction().commit();
         session.close();
    }
    
   
public User getUser(int id )   {
         Session session = s.openSession();
         session.beginTransaction();
         User user = (User) session.get(User.class, id);
         session.getTransaction().commit();
         session.close();
         return user;
}
   public void editUser( User newOne){
   
         Session session = s.openSession();
         session.beginTransaction();
         User oldUser = (User) session.get(User.class, newOne.getId());
         oldUser.setUserName(newOne.getUserName());
         session.update(oldUser);
         session.getTransaction().commit();
         session.close();
       
   }

    public List<User> getAllUser() {
        List <User> allUsers = new ArrayList();
        Session session = s.openSession();
        session.beginTransaction();
        List<Object[]> listOfAllUser = session.createQuery("Select u.id , u.userName from User u").list();
        for(Object [] index : listOfAllUser){
            User user = new User ();
            user.setId(Integer.parseInt(index[0].toString()));
            user.setUserName(index[1].toString());
            allUsers.add(user);       
        }
        session.getTransaction().commit();
        session.close();
        return allUsers;
    }
    
    public void deleteUser(User user){
        Session session = s.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
   
}
