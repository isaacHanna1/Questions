
package com.watad.backingStartCompetition;
import com.watad.Db.QuestionDB;
import com.watad.Db.PointDB;
import com.watad.model.Competition;
import com.watad.model.Question;
import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.watad.model.Points;
import com.watad.model.User;
import java.util.Arrays;
import java.util.Collections;

@ManagedBean(name = "BackingStartCompetition")
@SessionScoped
public class BackingStartCompetition {
   
    private int indexOfQuestion = 0;
    private int indexOfUser = 0;
    private List<Question> questions = new ArrayList();
    private List<User> users = new ArrayList();
    QuestionDB qdb = new QuestionDB();
    PointDB pointDB = new PointDB();
    Competition competition = new Competition();
    private Points point = new Points();
    
        
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Question startQuestion(){
            Question q =  questions.get(indexOfQuestion);
            return q;
    }
    public User getCurrentUser(){
        if(indexOfUser <= users.size()-1){
           User u =  users.get(indexOfUser);
           return u;
        }
        else{
            indexOfUser = 0;
            User u =  users.get(indexOfUser);
            return u;
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    public String  nextQuestion(){
        if(indexOfQuestion < questions.size()-1){
               saveQuestion();
               indexOfQuestion++;
               indexOfUser++;
               return "startCompetition";
        }else{
            saveQuestion();
            return "result";
        }
    }
public void saveQuestion(){
        point.setQuestion(startQuestion());
        point.setUser(getCurrentUser());
        point.setCompetition(competition);
        int pointOfQuestion = 0 ;
        if(point.getQuestionResult().equals(startQuestion().getCorrectAnswer())){
            pointOfQuestion = 100;
        }
        System.out.println("the user name is : "+getCurrentUser().getUserName());
        getCurrentUser().setPoint(pointOfQuestion);
        point.setPoint(pointOfQuestion);
        pointDB.saveInPoint(point);
}
    public int getIndexOfQuestion() {
        return indexOfQuestion;
    }

    public void setIndexOfQuestion(int indexOfQuestion) {
        this.indexOfQuestion = indexOfQuestion;
    }

    public int getIndexOfUser() {
        return indexOfUser;
    }

    public void setIndexOfUser(int indexOfUser) {
        this.indexOfUser = indexOfUser;
    }

    public QuestionDB getQdb() {
        return qdb;
    }

    public void setQdb(QuestionDB qdb) {
        this.qdb = qdb;
    }

    public Points getPoint() {
        return point;
    }

    public void setPoint(Points point) {
        this.point = point;
    }
    
    public String whoWin(){
        String win = "";
        int pointsOfUser [] = new int[users.size()];
        
        for (int i = 0; i < users.size(); i++) {
                pointsOfUser[i]=users.get(i).getPoint();
            }
        int max= pointsOfUser[0];
        int index = 0;
        for (int i = 1; i < pointsOfUser.length; i++) {
            if(pointsOfUser[i] > max){
                max = pointsOfUser[i];
                index = i;
            }
        }
        if(index == 0 && pointsOfUser[index]== pointsOfUser[1]){
        return "draw" ;
            }
        return users.get(index).getUserName();
    }
    
}
