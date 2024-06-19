package com.example.lab_234.Lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab_234.Lab2.Lab2;
import com.example.lab_234.Lab3.CustoListView.CustomListView;
import com.example.lab_234.Lab3.CustomListiew2.CustomListView2;
import com.example.lab_234.MainActivity;
import com.example.lab_234.R;

public class Lab3 extends AppCompatActivity {
    Button listview, customListview,customListview2,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab3);

        listview = findViewById(R.id.button);
        customListview = findViewById(R.id.button2);
        customListview2 = findViewById(R.id.button3);
        back = findViewById(R.id.back);

        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab3.this, ListView.class);
                startActivity(intent);
            }
        });
        customListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab3.this, CustomListView.class);
                startActivity(intent);
            }
        });
        customListview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab3.this, CustomListView2.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}