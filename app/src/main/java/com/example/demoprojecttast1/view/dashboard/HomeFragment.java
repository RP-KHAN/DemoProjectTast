package com.example.demoprojecttast1.view.dashboard;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoprojecttast1.R;
import com.example.demoprojecttast1.adapter.GridAdapter;
import com.example.demoprojecttast1.databinding.FragmentHomeBinding;
import com.example.demoprojecttast1.models.ApiModel;
import com.example.demoprojecttast1.viewmodel.AppViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Tag;

public class HomeFragment extends Fragment {
    FragmentHomeBinding homeBinding;
    ArrayList<ApiModel> allImages;
    GridAdapter gridAdapter;
    Context context;

    // String url;
    //View Model object
    AppViewModel appViewModel;
    public HomeFragment() {
        // Required empty public constructor
    }
    public HomeFragment(Context context){
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeBinding = FragmentHomeBinding.inflate(getActivity().getLayoutInflater());
        view.findViewById(R.id.image_grid).getRootView();
        //AppViewModel appViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance((Application) getContext()).create(AppViewModel.class);

        gridAdapter = new GridAdapter(context,allImages);

        //
        appViewModel = new ViewModelProvider(getActivity()).get(AppViewModel.class);


        appViewModel.getAllImages().observe(getActivity(), new Observer<List<ApiModel>>() {
            @Override
            public void onChanged(List<ApiModel> apiModels) {
               String url = apiModels.get(1).getUrl();
                //System.out.println("IMAGE NAME :"+apiModels.get(0).getUrl());*/
                for(int i =0 ;i<apiModels.size();i++){
                    System.out.println(i);
                }
            }
        });
        return view;
    }
//    private void observerAnyChange(){
//        appViewModel.getAllImages().observe(getActivity(), new Observer<List<ApiModel>>() {
//            @Override
//            public void onChanged(List<ApiModel> apiModels) {
//                /*url = apiModels.get(1).getUrl();
//                System.out.println("IMAGE NAME :"+apiModels.get(0).getUrl());*/
//                for(int i =0 ;i<apiModels.size();i++){
//                    System.out.println(i);
//                }
//            }
//        });
//    }
}