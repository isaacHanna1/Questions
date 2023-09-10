package com.watad.backingCompetition;

import com.watad.model.Competition;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.watad.Db.CompetitionDB;

@ManagedBean
@RequestScoped
public class BackingAddCompetition {
    
    private Competition competition = new Competition();
    private CompetitionDB db = new CompetitionDB();
            
    public String addCompetion(){
        db.addCompetition(competition);
        return "competitions";
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
    
    
}
