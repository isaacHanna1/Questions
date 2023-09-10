package com.watad.converter;

import com.watad.model.Competition;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.watad.Db.CompetitionDB;
@FacesConverter(value = "com.watad.converter.CompetitionConverter",forClass = Competition.class)
public class CompetitionConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        CompetitionDB db = new CompetitionDB();
        int id = Integer.parseInt(value);        
        return db.getCompetition(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
            return o.toString();
    }
    
}

