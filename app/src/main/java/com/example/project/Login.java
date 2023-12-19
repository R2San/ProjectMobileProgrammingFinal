package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;
    Button btnSign, btnReg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnReg = findViewById(R.id.btnReg);
        btnReg.setOnClickListener(this);
        btnSign = findViewById(R.id.btnSign);
        btnSign.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            if (v.getId() == R.id.btnSign){
                ArrayList<User> arrUsers = new ArrayList<>();

                UserDAO userDao = new UserDAO();
                arrUsers = userDao.getUsers(this);

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                for(int i=0; i<arrUsers.size();i++) {
                    if (username.compareToIgnoreCase(arrUsers.get(i).username) == 0 &&
                            password.compareToIgnoreCase(arrUsers.get(i).password) == 0) {
                        Intent pindahSplash = new Intent(this, SplashScreen.class);
                        pindahSplash.putExtra("name", username);
                        startActivity(pindahSplash);
                    }
                }
            }
            else if (v.getId() == R.id.btnReg){
                Intent pindahReg = new Intent(this, Register.class);
                startActivity(pindahReg);
            }


    }

}