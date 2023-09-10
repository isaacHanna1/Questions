package com.watad.BackingUser;

import com.common.HibernateUtil;
import com.watad.Db.UserDB;
import com.watad.model.User;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BackingUser {
    
    UserDB u = new UserDB();
    @ManagedProperty(value="#{BackingEditUser}")
    private BackingEditUser backingEditUser ;
    
    public List<User> findAllUsers(){
        List <User> allUsers = u.getAllUser(); 
        return  allUsers;   
    }
    public void delete (User user){
        u.deleteUser(user);
    }
    public String edit(User user){
        backingEditUser.setUser(user);
        return "editUser";
    }
    public BackingEditUser getBackingEditUser() {
        return backingEditUser;
    }
    public void setBackingEditUser(BackingEditUser backingEditUser) {
        this.backingEditUser = backingEditUser;
    }
    
    public User findingUserById(int id ){
        return u.getUser(id);
    }
}
