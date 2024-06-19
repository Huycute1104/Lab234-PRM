package com.example.lab_234.Lab4.Lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_234.R;

public class LifeCycle extends AppCompatActivity {
    Button btnMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_life_cycle);
        btnMain = findViewById(R.id.buttonMain);
        btnMain.setOnClickListener((view) ->{
            Intent intent = new Intent(LifeCycle.this, SecondActivity.class);
            startActivity(intent);
        });
        Log.d("AAA", "onCreate Main");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "onStart Second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "onRestart Second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "onResume Second");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}