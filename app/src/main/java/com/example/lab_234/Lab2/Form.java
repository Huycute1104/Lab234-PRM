package com.example.lab_234.Lab2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_234.R;

public class Form extends AppCompatActivity implements View.OnClickListener  {

    private EditText eUsername;
    private EditText ePassword;
    private TextView tvNotAccountYet;
    private Button btnSignIn;
    private final String REQUIRE = "Require";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);

        // Refer
        eUsername = findViewById(R.id.txtUsername);
        ePassword = findViewById(R.id.txtPassword);
        tvNotAccountYet = findViewById(R.id.tvAlreadyAccount);
        btnSignIn = findViewById(R.id.btnSignUp);

        // Register event
        tvNotAccountYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }
    private boolean checkInput()
    {
        if(TextUtils.isEmpty(eUsername.getText().toString())){
            eUsername.setError(REQUIRE);
            return false;
        }
        if(TextUtils.isEmpty(ePassword.getText().toString())){
            ePassword.setError(REQUIRE);
            return false;
        }
        // valid
        return true;
    }

    private void signIn(){
        //Invalid
        if(!checkInput()){
            return;
        }

        Intent intent = new Intent(this, Lab2.class);
        startActivity(intent);
        finish(); //Close current activity
    }

    private void signUpForm() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSignUp){
            signIn();
        }
        else if (v.getId() == R.id.tvAlreadyAccount ){
            signUpForm();
        }
    }
}