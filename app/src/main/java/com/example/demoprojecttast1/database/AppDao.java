package com.example.demoprojecttast1.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.demoprojecttast1.EntityModel;

import java.util.List;

@Dao
public interface AppDao {
    @Insert
    void addUsers(EntityModel entityModel);

    @Query("SELECT * FROM users")
    List<EntityModel> getAllData();

    //To Prevent Duplicate UserName
    @Query("SELECT EXISTS(SELECT * FROM users WHERE userName=:userName)")
    boolean isExists(String userName);

    @Query("SELECT id FROM users WHERE userName=:userName AND password=:password")
    int loginAuth(String userName,String password);

    // For Login
    @Query("SELECT EXISTS(SELECT * FROM users WHERE userName=:userName AND password=:password)")
    boolean checkUserAuthentication(String userName,String password);

    @Query("SELECT * FROM users WHERE id =:id")
    List<EntityModel> getDetails(float id);

}
