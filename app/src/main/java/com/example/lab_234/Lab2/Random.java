package com.example.lab_234.Lab2;

import android.os.Bundle;
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

public class Random extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_random);
        Button btnClick = findViewById(R.id.button);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText minEditText = findViewById(R.id.min);
                EditText maxEditText = findViewById(R.id.max);
                int lowerBound = Integer.parseInt(minEditText.getText().toString());
                int upperBound = Integer.parseInt(maxEditText.getText().toString());
                java.util.Random random = new java.util.Random();
                int number = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                TextView textView = findViewById(R.id.huy);
                textView.setText(number+"");
            }
        });
    }

}