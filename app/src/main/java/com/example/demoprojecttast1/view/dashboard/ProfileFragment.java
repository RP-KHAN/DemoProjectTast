package com.example.demoprojecttast1.view.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.demoprojecttast1.EntityModel;
import com.example.demoprojecttast1.R;
import com.example.demoprojecttast1.view.LoginActivity;
import com.example.demoprojecttast1.viewmodel.AppViewModel;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    ArrayList<EntityModel> personDataset;
    AppViewModel appViewModel;
    float id;
    Context context;
    public ProfileFragment() {
    }
    public ProfileFragment(float id){
        this.id = id;
        //personDataset = (ArrayList<EntityModel>) appViewModel.getdetails(id);
    }

    public ProfileFragment(Context context) {
        this.context = context;
    }

    /* private void getPersonData(float id){
         personDataset = (ArrayList<EntityModel>) appViewModel.getdetails(id);
     }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
//        int ids = (int) id;
//        String user_name = personDataset.get(ids).getUserName();
//        Toast.makeText(context,"Process",Toast.LENGTH_LONG);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button logout = view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}