package com.example.lab_234.Lab4.SendData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_234.Lab4.Lab4;
import com.example.lab_234.Lab4.Order.Order;
import com.example.lab_234.R;

public class SecondActivity extends AppCompatActivity {
Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        TextView tvDisplay = findViewById(R.id.tvDisplay);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        if (bundle != null) {
            String str = bundle.getString("string");
            int number = bundle.getInt("number");
            String[] cityArr = bundle.getStringArray("array");
            StringBuilder arrString = new StringBuilder();
            for (int i = 0; i < cityArr.length; i++) {
                if (i == cityArr.length - 1)
                    arrString.append(cityArr[i]);
                else arrString.append(cityArr[i]).append(", ");
            }
            User student = (User) bundle.getSerializable("user");
            String result = "MSG: " + str + "\n" + "Number: " + number + "\n" + "Array: " + arrString + "\n" + "Student: " + student.getName() + " - " + student.getId();

            tvDisplay.setText(result);
        }
        button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, Lab4.class);
                startActivity(intent);
            }
        });
    }
}
