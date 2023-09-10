package com.watad.BackingUser;

import com.watad.Db.UserDB;
import com.watad.model.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BackingAddNewUser {
    
    UserDB u = new UserDB();
    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
     public String saveUser(){
         
         u.saveUser(user);
         return "user";
     }
    
}
