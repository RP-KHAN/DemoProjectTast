package com.example.demoprojecttast1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.demoprojecttast1.EntityModel;
import com.example.demoprojecttast1.databinding.ActivitySignUpBinding;
import com.example.demoprojecttast1.viewmodel.AppViewModel;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding signUpBinding;
    String firstName,lastName,userName,findGender,password;

    RadioButton getRadioID;
    AppViewModel appViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);

        signUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(signUpBinding.getRoot());

        appViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(AppViewModel.class);

        signUpBinding.backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        signUpBinding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName = signUpBinding.firstName.getText().toString();
                lastName = signUpBinding.lastName.getText().toString();
                userName = signUpBinding.userName.getText().toString();

                findGender = signUpBinding.male.toString();
                password = signUpBinding.editTextTextPassword.toString();

                EntityModel entityModel = new EntityModel(firstName,lastName,userName,findGender,password);

                appViewModel.addUsers(entityModel);

                Toast.makeText(SignUpActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this,DashBoardActivity.class);
                startActivity(intent);
            }
        });
    }
}