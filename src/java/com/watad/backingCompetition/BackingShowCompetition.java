package com.watad.backingCompetition;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.watad.model.Competition;
import javax.faces.bean.SessionScoped;
import com.watad.Db.QuestionDB;
import com.watad.model.Question;
import java.util.List;
@ManagedBean(name = "BackingShowCompetition")
@SessionScoped
public class BackingShowCompetition {
  
    private Competition competition = new Competition();
    private QuestionDB db = new QuestionDB();
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
    
    public List<Question> findingQuestionOfCompetition(){
        
        return  db.questionOfCompetition(competition);
    }
    
}
