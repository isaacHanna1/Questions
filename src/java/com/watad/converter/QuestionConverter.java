
package com.watad.converter;
import com.watad.model.Question;
import com.watad.Db.QuestionDB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.watad.model.Question;
import com.watad.Db.QuestionDB;

@FacesConverter(value = "com.watad.converter.QuestionConverter",forClass = Question.class)
public class QuestionConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        
        QuestionDB db = new QuestionDB();
        int id = Integer.parseInt(value);        
        return db.getQuestion(id);
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
    
            return o.toString();
    }
    
}
