package com.example.demoprojecttast1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demoprojecttast1.databinding.ActivityLoginPageBinding;
import com.example.demoprojecttast1.view.dashboard.DashBoardActivity;
import com.example.demoprojecttast1.view.dashboard.ProfileFragment;
import com.example.demoprojecttast1.viewmodel.AppViewModel;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginPageBinding loginPageBinding;
    AppViewModel appViewModel;
    int id;
    String userName;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginPageBinding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(loginPageBinding.getRoot());
        appViewModel = new AppViewModel(getApplication());
        appViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(AppViewModel.class);


        loginPageBinding.goToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        /*String userName,password;*/
        loginPageBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = loginPageBinding.userName.getText().toString();
                password = loginPageBinding.editTextTextPassword.getText().toString();

                Toast.makeText(LoginActivity.this,"Login is Process",Toast.LENGTH_SHORT).show();

                /*appViewModel.checkLogin((loginPageBinding.userName.getText().toString())
                        ,(loginPageBinding.editTextTextPassword.getText().toString()))*/
                /*if(userName.isEmpty() && password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Empty User ID OR password", Toast.LENGTH_LONG).show();
                }else{
                    if (appViewModel.checkLogin(loginPageBinding.userName.getText().toString(), loginPageBinding.editTextTextPassword.getText().toString())) {
                        Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Successfully Login", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong User ID OR password", Toast.LENGTH_LONG).show();
                    }
                }*/
                id = (appViewModel.logincheck(loginPageBinding.userName.getText().toString(), loginPageBinding.editTextTextPassword.getText().toString()));
//                ProfileFragment idSend = new ProfileFragment(id);

                if(userName.isEmpty() && password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Empty User ID OR password", Toast.LENGTH_LONG).show();
                }else{
                    if (id !=-1){
                        Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
                        startActivity(intent);
                        loginPageBinding.userName.setText("");
                        loginPageBinding.editTextTextPassword.setText("");
                        Toast.makeText(LoginActivity.this, "Successfully Login", Toast.LENGTH_LONG).show();
                    } else {
                        loginPageBinding.userName.setText("");
                        loginPageBinding.editTextTextPassword.setText("");
                        Toast.makeText(LoginActivity.this, "Wrong User ID OR password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}