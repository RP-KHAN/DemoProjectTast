package com.example.demoprojecttast1.repository;

import android.content.Context;

import com.example.demoprojecttast1.EntityModel;
import com.example.demoprojecttast1.database.AppDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private AppDatabase appDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();
    List<EntityModel> getAllData;

    public AppRepository(Context context){
        appDatabase = AppDatabase.getDB(context);
    }

    public void insertProject(EntityModel entityModel){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.appDao().addUsers(entityModel);
            }
        });
    }

    public Boolean userAuthentication(String user,String password){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                getAllData =  appDatabase.appDao().getAllStudent();

            }
        });
        for(int i=0;i<getAllData.size();i++){
            if(user == getAllData.get(i).getUserName() && password == getAllData.get(i).getPassword()){
                return true;
            }
        }
        return false;
    }
}
