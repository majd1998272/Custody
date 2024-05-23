package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private String userID;
    @Column(name = "RoleID")

    private int roleID;
    @Column(name = "IsActive")

    private int isActive;

    public Users() {
    }

    public Users(String userID, int roleID, int isActive) {
        this.userID = userID;
        this.roleID = roleID;
        this.isActive = isActive;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
