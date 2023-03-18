package com.example.demoprojecttast1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demoprojecttast1.databinding.ActivityLoginPageBinding;
import com.example.demoprojecttast1.viewmodel.AppViewModel;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginPageBinding loginPageBinding;
    AppViewModel appViewModel;


    AppViewModel appViewModelLogin;

    String userName = "";
    String password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        loginPageBinding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(loginPageBinding.getRoot());

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
                Toast.makeText(LoginActivity.this,"Login is Process",Toast.LENGTH_LONG).show();
                boolean check = appViewModelLogin.checkLogin(userName,password);
                if(check){
                    Intent intent = new Intent(LoginActivity.this,DashBoardActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"Wrong User ID OR password",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}