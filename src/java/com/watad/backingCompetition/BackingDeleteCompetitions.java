package com.watad.backingCompetition;

import com.watad.model.Competition;
import javax.faces.bean.ManagedBean;
import com.watad.Db.CompetitionDB;
@ManagedBean
public class BackingDeleteCompetitions {
    
    private CompetitionDB db = new CompetitionDB();
    public String deleteCompetition(Competition competition){
        db.delete(competition);
        return "competitions";
    }
}
