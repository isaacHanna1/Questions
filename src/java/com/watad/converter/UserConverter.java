
package com.watad.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.watad.model.User;
import com.watad.Db.UserDB;
@FacesConverter (value = "com.watad.converter.userConverter", forClass = User.class)
public class UserConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        try{
            System.out.println("the value is : "+value);
            UserDB u = new UserDB();
            return u.getUser(Integer.parseInt(value)) ;   
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null ;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
            return o.toString();
    }
    
}
