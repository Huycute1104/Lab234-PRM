package com.example.lab_234.Lab3;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_234.R;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {

    android.widget.ListView lsMonHoc;
    Button btnAdd, btnUpdate, btnDelete;
    EditText editText;
    ArrayList<String> arrayCourse;
    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        lsMonHoc =(android.widget.ListView)findViewById(R.id.ListViewSubject);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnUpdate= (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        editText =(EditText)findViewById(R.id.txtEditText);

        arrayCourse = new ArrayList<>();
        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("IOS");
        arrayCourse.add("Unity");
        arrayCourse.add("ASP.Net");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(
                ListView.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );
        lsMonHoc.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = editText.getText().toString();
                if(TextUtils.isEmpty(inputValue)){
                    Toast.makeText(
                            ListView.this, "Empty! Add failed", Toast.LENGTH_SHORT).show();
                }
                else if (arrayCourse.contains(inputValue)){
                    Toast.makeText(
                            ListView.this, "Subject already exists!", Toast.LENGTH_SHORT).show();
                }else {
                    arrayCourse.add(inputValue);
                    arrayAdapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        lsMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                editText.setText(arrayCourse.get(i));
                index =i;
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputValue = editText.getText().toString();
                if(TextUtils.isEmpty(inputValue)){
                    Toast.makeText(
                            ListView.this, "Empty! Update failed", Toast.LENGTH_SHORT).show();
                }
                else if (arrayCourse.contains(inputValue)){
                    Toast.makeText(
                            ListView.this, "Subject Not Change!", Toast.LENGTH_SHORT).show();
                }else {
                    arrayCourse.set(index,inputValue);
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(
                            ListView.this, "Updated success!", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputValue = editText.getText().toString();
                if(TextUtils.isEmpty(inputValue)){
                    Toast.makeText(
                            ListView.this, "Empty! Delete failed", Toast.LENGTH_SHORT).show();
                }else {
                    arrayCourse.remove(index);
                    arrayAdapter.notifyDataSetChanged();
                    editText.setText("");
                    Toast.makeText(
                            ListView.this, "Delete success!", Toast.LENGTH_SHORT).show();

                }

            }
        });
//        lsMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                arrayCourse.remove(i);
//                arrayAdapter.notifyDataSetChanged();
//            }
//        });


    }


}