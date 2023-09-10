package com.watad.backingCompetition;

import com.watad.model.Competition;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.watad.Db.CompetitionDB;

@ManagedBean(name = "BackingEditCompetition")
@SessionScoped
public class BackingEditCompetition {
    
    private Competition competition ;
    private CompetitionDB db = new CompetitionDB();
    
    public Competition getCompetition() {
        return competition;
    }
    public void setCompetition(Competition competition) {
        this.competition = competition;
        System.out.println("hi from "+competition.toString());
    }
    public String editCompetition(){
        db.edit(competition);
        return "competitions";
    }
    
}
