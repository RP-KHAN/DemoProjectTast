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
    List<EntityModel> getAllStudent();

    /*@Query("SELECT userName,password where ")
    Boolean checkUserAuthentication(String user,String pass);*/

}
