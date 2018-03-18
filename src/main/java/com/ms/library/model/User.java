package com.ms.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "librarytableuser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userRole")
    private String userRole;
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "enabled", nullable = false)
    private int enabled = 1;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roles = new ArrayList<Role>();

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public User(String userName, String userPassword, String userRole, int enabled) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.enabled = enabled;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
