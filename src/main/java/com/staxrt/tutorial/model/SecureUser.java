package com.staxrt.tutorial.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubuntu on 15/05/20.
 */
@Entity(name = "secure_user")
public class SecureUser extends AbstractEntity {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roleLists = new ArrayList();

    @Column
    String userName;
    @Transient
    String password;
    @Column
    String encryptedPass;

    public List<Role> getRoleLists() {
        return roleLists;
    }

    public void setRoleLists(Role role) {
        this.roleLists.add(role);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPass() {
        return encryptedPass;
    }

    public void setEncryptedPass(String encryptedPass) {
        this.encryptedPass = encryptedPass;
    }
}
