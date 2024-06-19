package com.example.lab_234;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_234.Lab2.Lab2;
import com.example.lab_234.Lab3.Lab3;
import com.example.lab_234.Lab4.Lab4;

public class MainActivity extends AppCompatActivity {

    Button lab4, lab2 , lab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lab2 = findViewById(R.id.button);
        lab3 = findViewById(R.id.button2);
        lab4 = findViewById(R.id.button3);

        lab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab2.class);
                startActivity(intent);
            }
        });
        lab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab3.class);
                startActivity(intent);
            }
        });
        lab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab4.class);
                startActivity(intent);
            }
        });
    }
}