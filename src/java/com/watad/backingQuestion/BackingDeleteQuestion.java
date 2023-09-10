package com.watad.backingQuestion;
import com.watad.model.Question;
import com.watad.Db.QuestionDB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BackingDeleteQuestion {
    
    
    private QuestionDB dB = new QuestionDB(); 
    public String DeleteQuestion(Question question){
        dB.deleteQuestion(question);
        return "showCompetition";
    }
    
}
