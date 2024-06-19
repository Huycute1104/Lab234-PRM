package com.example.lab_234.Lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_234.Lab3.CustoListView.CustomListView;
import com.example.lab_234.Lab3.CustomListiew2.CustomListView2;
import com.example.lab_234.Lab3.Lab3;
import com.example.lab_234.Lab3.ListView;
import com.example.lab_234.Lab4.Lifecycle.LifeCycle;
import com.example.lab_234.Lab4.Order.Order;
import com.example.lab_234.Lab4.SendData.SendData;
import com.example.lab_234.MainActivity;
import com.example.lab_234.R;

public class Lab4 extends AppCompatActivity {
    Button order, sendData,lifeCycle,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab4);

        order = findViewById(R.id.button);
        sendData = findViewById(R.id.button2);
        lifeCycle = findViewById(R.id.button3);
        back = findViewById(R.id.back);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab4.this, Order.class);
                startActivity(intent);
            }
        });
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab4.this, SendData.class);
                startActivity(intent);
            }
        });
        lifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab4.this, LifeCycle.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab4.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}