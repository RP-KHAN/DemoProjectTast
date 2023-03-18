package com.example.demoprojecttast1.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.demoprojecttast1.EntityModel;
import com.example.demoprojecttast1.repository.AppRepository;

public class AppViewModel extends AndroidViewModel {

    AppRepository appRepository;
    public AppViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);
    }

    public void addUsers(EntityModel entityModel){
        appRepository.insertProject(entityModel);
    }

    public boolean checkLogin(String uName,String pass){

        if(uName=="" && pass==""){
            return false;
        }else if(appRepository.userAuthentication(uName,pass)){
            return true;
        }else
            return false;
    }
}
