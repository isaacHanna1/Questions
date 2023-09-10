
package com.watad.backingQuestion;

import com.watad.model.Question;
import com.watad.Db.QuestionDB ;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BackingAddQuestion {
    
    private Question question = new Question();
    private QuestionDB db = new QuestionDB();

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public void addQuestion(){
        db.addQuestion(question);
    }
    
}
