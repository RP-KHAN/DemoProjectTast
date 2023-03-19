package com.example.demoprojecttast1.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.demoprojecttast1.EntityModel;
import com.example.demoprojecttast1.models.ApiModel;
import com.example.demoprojecttast1.repository.AppRepository;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

    AppRepository appRepository;
    List<EntityModel> usersalldata;
    List<ApiModel> allImages;
    int id;

    public AppViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
    }

    public void addUsers(EntityModel entityModel){
        appRepository.insertProject(entityModel);;
    }

    /*public boolean checkLogin(String uName,String pass){

        if(appRepository.userAuthentication(uName,pass)){
            return true;
        }
        return false;
    }*/

    // id collector
    public int logincheck(String uName,String pass){
        id = appRepository.userAuthIdFind(uName,pass);
        return id;
    }

    //Getting all details from database using id
    public List<EntityModel> getdetails(float id){
        return appRepository.getDataID(id);
    }

    public List<EntityModel> getdata(){
        usersalldata =  appRepository.getAllDAta();
        return  usersalldata;
    }


    /*public List<ApiModel> getAllImages(){
        allImages = appRepository.getAllImagesFromApi();
        return allImages;
    }*/

//    private MutableLiveData<List<ApiModel>> mApiImage = new MutableLiveData<>();

    public LiveData<List<ApiModel>> getAllImages(){
        return appRepository.getAllImagesFromApi();
    }
}
