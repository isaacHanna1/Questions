
package com.watad.backingCompetitionInfo;


import javax.faces.bean.ManagedBean;
import java.util.List;
import com.watad.model.User;
import com.watad.model.Competition;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;
import com.watad.model.Question;
import com.watad.Db.QuestionDB;
import com.watad.Db.CompetitionDB;
import com.watad.backingStartCompetition.BackingStartCompetition;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@SessionScoped
public class BackingCompetitionInfo {
    
    private Competition competition = new Competition();
    private List<User> users = new ArrayList<>();
    private List<Question> questions = new ArrayList();
    private QuestionDB QuestionDB = new QuestionDB();

    @ManagedProperty(value = "#{BackingStartCompetition}")
    private BackingStartCompetition backingStartCompetition ;
    
            
            
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        
        this.competition = competition;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void print(){

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUserName());
        }
    }
    public String startCompetition(){
        backingStartCompetition.setCompetition(competition);
        backingStartCompetition.setUsers(users);
        backingStartCompetition.setQuestions(QuestionDB.questionOfCompetition(competition));
        return "startCompetition";
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public BackingStartCompetition getBackingStartCompetition() {
        return backingStartCompetition;
    }

    public void setBackingStartCompetition(BackingStartCompetition backingStartCompetition) {
        this.backingStartCompetition = backingStartCompetition;
    }

   
    
}
