package com.example.demoprojecttast1.repository;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.demoprojecttast1.EntityModel;
import com.example.demoprojecttast1.apis.ApiServices;
import com.example.demoprojecttast1.apis.RetrofitInstance;
import com.example.demoprojecttast1.database.AppDatabase;
import com.example.demoprojecttast1.models.ApiModel;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class AppRepository {
    private AppDatabase appDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();
    List<EntityModel> getAllData;
    List<ApiModel> getAllImages;
    ApiServices apiServices;

    boolean flag = false;
    boolean isFlag = false;
    int id;

    //Create Databse Connection
    public AppRepository(Context context){
        appDatabase = AppDatabase.getDB(context);
    }

    //Create API Connection
    public AppRepository(){
        apiServices = RetrofitInstance.getRetrofit().create(ApiServices.class);
    }

    // Insert New USers Data into Room Data Base
    public void insertProject(EntityModel entityModel){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                /*if(appDatabase.appDao().isExists(entityModel.getUserName().toString())){
                    appDatabase.appDao().addUsers(entityModel);
                    isFlag = true;
                }*/
                appDatabase.appDao().addUsers(entityModel);
            }
        });
    }

    //Checking the username and password is match to the database or not
    /*public boolean userAuthentication(String user,String password){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                flag = appDatabase.appDao().checkUserAuthentication(user,password);
            }
        });
        return flag;
    }*/
    // login
    public int userAuthIdFind(String user,String password){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                id = appDatabase.appDao().loginAuth(user,password);
            }
        });
        return id;
    }

    // Getting all details from database using id
    public List<EntityModel> getDataID(float id){
        return appDatabase.appDao().getDetails(id);
    }

    // Getting all Users Details
    public List<EntityModel> getAllDAta(){
          getAllData = appDatabase.appDao().getAllData();

        return getAllData;
    }


    public MutableLiveData<List<ApiModel>> getAllImagesFromApi(){
        apiServices = RetrofitInstance.getRetrofit().create(ApiServices.class);
        //For Storing all Images
        MutableLiveData<List<ApiModel>> getAllImages = new MutableLiveData<>();

        apiServices.getAllJson().enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                //Log.e(TAG,"OnResponce"+response.code());
                //if(response.isSuccessful()){
                    getAllImages.setValue(response.body());
                //}else{
                   // getAllImages.setValue(null);
                //}
            }
            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                Log.e(TAG,"OnResponce"+t.getMessage());
                //getAllImages.setValue(null);
            }
        });
        return getAllImages;
    }
}
