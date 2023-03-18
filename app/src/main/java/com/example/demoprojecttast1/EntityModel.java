package com.example.demoprojecttast1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class EntityModel {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String firstName;
    @ColumnInfo
    String lastName;
    @ColumnInfo
    String userName;
    @ColumnInfo
    String findGender;
    @ColumnInfo
    String password;

    public EntityModel(String firstName, String lastName, String userName, String findGender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.findGender = findGender;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFindGender() {
        return findGender;
    }

    public void setFindGender(String findGender) {
        this.findGender = findGender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
