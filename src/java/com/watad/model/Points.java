
package com.watad.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Points {
    @Id
    @GeneratedValue
    private int id ;     
    @OneToOne
    private User user ; 
    @OneToOne
    private Question question ;
    @OneToOne
    private Competition competition;
    private String QuestionResult ; 
    private int Point ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getQuestionResult() {
        return QuestionResult;
    }

    public void setQuestionResult(String QuestionResult) {
        this.QuestionResult = QuestionResult;
    }

    public Competition getCompetition() {
        return competition;
    }
    
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
    
    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }
    
    
}
