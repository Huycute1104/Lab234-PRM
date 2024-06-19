package com.example.lab_234.Lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_234.Lab3.Lab3;
import com.example.lab_234.Lab4.Lab4;
import com.example.lab_234.MainActivity;
import com.example.lab_234.R;

public class Lab2 extends AppCompatActivity {

    Button form, random,r2s,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab2);

        form = findViewById(R.id.button);
        r2s = findViewById(R.id.button2);
        random = findViewById(R.id.button3);
        back = findViewById(R.id.back);

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2.this, Form.class);
                startActivity(intent);
            }
        });
        r2s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2.this, R2SAcademy.class);
                startActivity(intent);
            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2.this, Random.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}