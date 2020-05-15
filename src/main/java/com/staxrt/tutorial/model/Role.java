package com.staxrt.tutorial.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubuntu on 15/05/20.
 */
@Entity(name = "role")
public class Role extends AbstractEntity{

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<User> userList = new ArrayList<>();

    private String role;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(User user) {
        this.userList.add(user);
    }
}
