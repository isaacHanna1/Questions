package com.watad.backingCompetition;
import java.util.List;
import com.watad.model.Competition;
import com.watad.Db.CompetitionDB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BackingCompetition {
    
    @ManagedProperty(value = "#{BackingEditCompetition}")
    private BackingEditCompetition backingEditCompetition;
    
    @ManagedProperty(value = "#{BackingShowCompetition}")
    private BackingShowCompetition backingShowCompetition;
    
    CompetitionDB db = new CompetitionDB();
    
    public List<Competition> findingAllCompetition(){
            return db.gettingAllCompetition();
    }

    public BackingEditCompetition getBackingEditCompetition() {
        return backingEditCompetition;
    }

    public void setBackingEditCompetition(BackingEditCompetition backingEditCompetition) {
        this.backingEditCompetition = backingEditCompetition;
    }
    
    public String editCompetition(Competition c){
        backingEditCompetition.setCompetition(c);
        System.out.println(c.toString());
        return "editCompetition";
    }
    
    public  String showCompetitionQuestion(Competition c){
        backingShowCompetition.setCompetition(c);
        return "showCompetition";
    }

    public BackingShowCompetition getBackingShowCompetition() {
        return backingShowCompetition;
    }

    public void setBackingShowCompetition(BackingShowCompetition backingShowCompetition) {
        this.backingShowCompetition = backingShowCompetition;
    }

    
    
}
