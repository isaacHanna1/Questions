package com.watad.backingQuestion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.watad.model.Question;
import com.watad.Db.QuestionDB;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "BackingEditQuestion")
@SessionScoped
public class BackingEditQuestion {
    
    Question question = new Question();
    QuestionDB db = new QuestionDB();
    
    public String editQuestion(){
        db.editCompition(question);
        return "showCompetition";
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    
    
}
