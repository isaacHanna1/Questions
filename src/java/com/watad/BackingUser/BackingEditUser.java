
package com.watad.BackingUser;

import com.watad.Db.UserDB;
import com.watad.model.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="BackingEditUser")
@SessionScoped
public class BackingEditUser {
    
    private  User user = new User();
    private UserDB userDB  = new UserDB ();
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String editUser(){
        userDB.editUser(user);
        return "user";
    }
}
