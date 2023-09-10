
package com.watad.Db;

import com.common.HibernateUtil;
import org.hibernate.SessionFactory;
import com.watad.model.Question;
import com.watad.model.Competition;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
public class QuestionDB {
    
  public static SessionFactory s = HibernateUtil.sessionFactory;

    public List<Competition> findingAllCompeition(){
        
        List <Competition> allCompetition = new ArrayList();
        Session session   = s.openSession();
        session.beginTransaction();
        List <Object[]> list = session.createQuery("select c.id , c.competitionName from Competition c").list();
        
        for (int i = 0; i < list.size(); i++) {
            Competition c = new Competition();
            Object[] getIndex = list.get(i);
            c.setId(Integer.parseInt(getIndex[0].toString()));
            System.out.println("the id is "+ c.getId() );
            c.setCompetitionName((getIndex[1].toString()));
            allCompetition.add(c);
        }
        session.getTransaction().commit();
        session.close();
        return allCompetition;
        
    }
    
    public Question getQuestion(int id ){
         Session session = s.openSession();
         session.beginTransaction();
         Question question = (Question) session.get(Question.class, id);
         session.getTransaction().commit();
         session.close();
         return question;
    }

    public void addQuestion(Question question) {
              Session session = s.openSession();
              session.beginTransaction();
              session.save(question);
              session.getTransaction().commit();
              session.close();
    }
    
    public List<Question> questionOfCompetition(Competition competition){
    System.out.println("called 2 called 2 called 2");    
        List <Question> allQuestion = new ArrayList();
        Session session = s.openSession();
        session.beginTransaction();
        List  list = session.createQuery("FROM Question where competition_id = :id")
                .setParameter("id", competition.getId()).list();
        List <Question> questionList = list;
        System.out.println("the size of question list :"+questionList.size());
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println( questionList.get(i).toString());
        }
        return questionList;
    }
    
    public void deleteQuestion(Question question){
              Session session = s.openSession();
              session.beginTransaction();
              session.delete(question);
              session.getTransaction().commit();
              session.close();
    }
    
    public void editCompition(Question question){
        Session session = s.openSession();
              session.beginTransaction();
              session.update(question);
              session.getTransaction().commit();
              session.close();
    }
}
