package com.example.lab_234.Lab3.CustomListiew2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab_234.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CustomListView2 extends AppCompatActivity {
    ListView listUser;
    ArrayList<Users> arrUser;
    UserAdapter adapter;
    EditText txtName, txtDescription;
    ImageView avatar, flag;
    Button btnAdd, btnUpdate, btnDelete;
    int selectedPosition = -1;
    int[] imageResources;
    int avatarIndex = 0;
    int flagIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view2);
        initializeImageResources();
        View();
        adapter = new UserAdapter(this, R.layout.list_row, arrUser);
        listUser.setAdapter(adapter);


        txtName = findViewById(R.id.txtName);
        txtDescription = findViewById(R.id.txtDescription);
        avatar = findViewById(R.id.image);
        flag = findViewById(R.id.flag);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);


        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                Users user = arrUser.get(position);
                txtName.setText(user.getName());
                txtDescription.setText(user.getDescription());
                avatar.setImageResource(user.getAvatar());
                flag.setImageResource(user.getFlag());
                avatarIndex = findIndex(user.getAvatar(), imageResources);
                flagIndex = findIndex(user.getFlag(), imageResources);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser();
            }
        });
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleImage();
            }
        });
        flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleFlag();
            }
        });

    }

    private void View() {
        listUser = findViewById(R.id.listView);
        arrUser = new ArrayList<>();
//        arrUser.add(new Users(R.drawable.pele,R.drawable.brazil,"Pele","h"));
        arrUser.add(new Users(R.drawable.pele, R.drawable.brazil,
                "Pele", "October 23, 1940 (age 72)"));
        arrUser.add(new Users(R.drawable.maradona, R.drawable.arg,
                "Diego Maradona", "October 30, 1960 (age 52)"));
        arrUser.add(new Users(R.drawable.johan, R.drawable.holland,
                "Johan Cruyff", "April 25, 1947 (age 65)"));
        arrUser.add(new Users(R.drawable.ronaldo, R.drawable.brazil,
                "Ronaldo De Lima", "September 22, 1976 (age 36)"));
        arrUser.add(new Users(R.drawable.m10, R.drawable.arg,
                "Lionel Messi", "June 24, 1987 (age 36)"));
        arrUser.add(new Users(R.drawable.cr7, R.drawable.portugal,
                "Cristiano Ronaldo", "February 5, 1985 (age 38)"));
    }

    private void addUser() {
        String name = txtName.getText().toString();
        String description = txtDescription.getText().toString();
        if (name.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please enter both name and description", Toast.LENGTH_SHORT).show();
            return;
        }
        if (avatarIndex == 0 || flagIndex == 0) {
            Toast.makeText(this, "Please choose Image", Toast.LENGTH_SHORT).show();
            return;
        }
        arrUser.add(new Users(imageResources[avatarIndex], imageResources[flagIndex], name, description));  // Use the current selected image
        adapter.notifyDataSetChanged();
        txtName.setText("");
        txtDescription.setText("");
        avatar.setImageResource(R.drawable.avatar);
        flag.setImageResource(R.drawable.tran);
    }

    private void updateUser() {
        if (selectedPosition == -1) {
            Toast.makeText(this, "Please select a user to update", Toast.LENGTH_SHORT).show();
            return;
        }
        String name = txtName.getText().toString();
        String description = txtDescription.getText().toString();
        if (name.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please enter both name and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Users user = arrUser.get(selectedPosition);
        user.setName(name);
        user.setDescription(description);
        user.setAvatar(imageResources[avatarIndex]);
        user.setFlag(imageResources[flagIndex]);

        adapter.notifyDataSetChanged();
        txtName.setText("");
        txtDescription.setText("");
        avatar.setImageResource(R.drawable.avatar);
        flag.setImageResource(R.drawable.tran);
        selectedPosition = -1;
    }

    private void deleteUser() {
        if (selectedPosition == -1) {
            Toast.makeText(this, "Please select a user to delete", Toast.LENGTH_SHORT).show();
            return;
        }
        arrUser.remove(selectedPosition);
        adapter.notifyDataSetChanged();
        txtName.setText("");
        txtDescription.setText("");
        avatar.setImageResource(R.drawable.avatar);
        flag.setImageResource(R.drawable.tran);

        selectedPosition = -1;
    }

    private void cycleImage() {
        avatarIndex = (avatarIndex + 1) % imageResources.length;

        avatar.setImageResource(imageResources[avatarIndex]);
    }

    private void cycleFlag() {
        flagIndex = (flagIndex + 1) % imageResources.length;

        flag.setImageResource(imageResources[flagIndex]);
    }

    private void initializeImageResources() {
        List<Integer> imageResourceList = new ArrayList<>();
        Field[] drawables = R.drawable.class.getFields();

        for (Field field : drawables) {
            try {
                int resourceId = field.getInt(null);
                imageResourceList.add(resourceId);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        imageResources = new int[imageResourceList.size()];
        for (int i = 0; i < imageResourceList.size(); i++) {
            imageResources[i] = imageResourceList.get(i);
        }
    }

    private int findIndex(int resourceId, int[] resources) {
        for (int i = 0; i < resources.length; i++) {
            if (resources[i] == resourceId) {
                return i;
            }
        }
        return -1;
    }
}