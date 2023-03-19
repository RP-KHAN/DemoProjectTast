package com.example.demoprojecttast1.view.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.resources.Compatibility;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.demoprojecttast1.EntityModel;
import com.example.demoprojecttast1.R;
import com.example.demoprojecttast1.databinding.ActivityDashBoardBinding;
import com.example.demoprojecttast1.databinding.ActivitySignUpBinding;
import com.example.demoprojecttast1.models.ApiModel;
import com.example.demoprojecttast1.viewmodel.AppViewModel;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity {

    ActivityDashBoardBinding dashBoardBinding;
    AppViewModel appViewModel;
    ArrayList<EntityModel> usersData;
    ArrayList<ApiModel> getAllImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        appViewModel =new AppViewModel(getApplication());
        appViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(AppViewModel.class);

        dashBoardBinding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(dashBoardBinding.getRoot());

        ProfileFragment profileFragment = new ProfileFragment(this);

        Fragment home = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_frame,home).commit();

        // Go To Home where gridview is waiting
        dashBoardBinding.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment home = new HomeFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_frame,home).commit();
            }
        });

        dashBoardBinding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment profile = new ProfileFragment();
                FragmentTransaction profileTransaction = getSupportFragmentManager().beginTransaction();
                profileTransaction.replace(R.id.home_frame,profile).commit();

                usersData = (ArrayList<EntityModel>) appViewModel.getdata();
            }
        });

        HomeFragment homeFragment = new HomeFragment(DashBoardActivity.this);
    }
}