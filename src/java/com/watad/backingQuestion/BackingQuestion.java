
package com.watad.backingQuestion;
import  com.watad.model.Competition;
import com.watad.Db.QuestionDB;
import com.watad.model.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class BackingQuestion {
    
     QuestionDB DB = new QuestionDB();
     Question question = new Question();
     private List <Competition> allCompetition = new ArrayList();
     
     @ManagedProperty(value="#{BackingEditQuestion}")
     private BackingEditQuestion backingEditQuestion;
     
     @PostConstruct
     public void init(){
         allCompetition = findingAllCompetitions();
     }
     
     public List <Competition> findingAllCompetitions(){
         return  DB.findingAllCompeition();
    }

    public List<Competition> getAllCompetition() {
        return allCompetition;
    }

    public void setAllCompetition(List<Competition> allCompetition) {
        this.allCompetition = allCompetition;
    }

    public BackingEditQuestion getBackingEditQuestion() {
        return backingEditQuestion;
    }

    public void setBackingEditQuestion(BackingEditQuestion backingEditQuestion) {
        this.backingEditQuestion = backingEditQuestion;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public String editQuestion(Question q){
       backingEditQuestion.setQuestion(q);
       return "editQuestion";
    }

    
     
}
