package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;
    Button btnReg, btnSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnReg = findViewById(R.id.btnReg);
        btnReg.setOnClickListener(this);
        btnSign = findViewById(R.id.btnSign);
        btnSign.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnReg){
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            User tempUserForReg = new User();
            tempUserForReg.username= username;
            tempUserForReg.password= password;
            UserDAO userDao = new UserDAO();
            userDao.insertUser(this, tempUserForReg);
            Toast.makeText(this, "Register berhasil", Toast.LENGTH_SHORT).show();

            Intent pindahLogin = new Intent(this, Login.class);
            startActivity(pindahLogin);
        }
        else if (v.getId() == R.id.btnSign){
            Intent pindahLogin = new Intent(this, Login.class);
            startActivity(pindahLogin);
        }

    }

}