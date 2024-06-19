package com.example.lab_234.Lab3.CustoListView;

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

public class CustomListView extends AppCompatActivity {
    ListView ListFruit;
    ArrayList<Fruits> arrFruits;
    FruitAdapter adapter;
    EditText txtName, txtDescription;
    ImageView imageView;
    Button btnAdd, btnUpdate, btnDelete;
    int selectedPosition = -1;
    int[] imageResources;
    int currentImageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view);

        initializeImageResources();

        View();
        adapter = new FruitAdapter(this, R.layout.fruit, arrFruits);
        ListFruit.setAdapter(adapter);

        txtName = findViewById(R.id.txtName);
        txtDescription = findViewById(R.id.txtDescription);
        imageView = findViewById(R.id.image);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFruit();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFruit();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFruit();
            }
        });

        ListFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                Fruits fruit = arrFruits.get(position);
                txtName.setText(fruit.getName());
                txtDescription.setText(fruit.getDescription());
                imageView.setImageResource(fruit.getImage());
                currentImageIndex = findImageIndex(fruit.getImage(), imageResources);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleImage();
            }
        });
    }

    private void View() {
        ListFruit = findViewById(R.id.listViewFruit);
        arrFruits = new ArrayList<>();
        arrFruits.add(new Fruits("Apple", "A sweet, crisp fruit, commonly red, green, or yellow", R.drawable.apple));
        arrFruits.add(new Fruits("Avocado", "A creamy, green fruit with a large pit and buttery flavor", R.drawable.avocado));
        arrFruits.add(new Fruits("Orange", "A juicy, sweet citrus fruit with a bright orange peel.", R.drawable.orange));
        arrFruits.add(new Fruits("Durian", "A spiky fruit known for its strong odor and creamy flesh.", R.drawable.saurieng));
        arrFruits.add(new Fruits("Watermelon", "A large, juicy fruit with a green rind and sweet, red flesh.", R.drawable.watermelon));
        arrFruits.add(new Fruits("Strawberry", "A sweet, crisp fruit, commonly red, green, or yellow", R.drawable.strawberry));
        arrFruits.add(new Fruits("Pomegranate", "A creamy, green fruit with a large pit and buttery flavor", R.drawable.pomegranates));
        arrFruits.add(new Fruits("Grape", "A juicy, sweet citrus fruit with a bright orange peel.", R.drawable.grape));
        arrFruits.add(new Fruits("Blueberry", "A spiky fruit known for its strong odor and creamy flesh.", R.drawable.blueberry));
    }

    private void addFruit() {
        String name = txtName.getText().toString();
        String description = txtDescription.getText().toString();
        if (name.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please enter both name and description", Toast.LENGTH_SHORT).show();
            return;
        }
        arrFruits.add(new Fruits(name, description, imageResources[currentImageIndex]));
        adapter.notifyDataSetChanged();
        txtName.setText("");
        txtDescription.setText("");
        imageView.setImageResource(R.drawable.tran);
    }

    private void updateFruit() {
        if (selectedPosition == -1) {
            Toast.makeText(this, "Please select a fruit to update", Toast.LENGTH_SHORT).show();
            return;
        }
        String name = txtName.getText().toString();
        String description = txtDescription.getText().toString();
        if (name.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please enter both name and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Fruits fruit = arrFruits.get(selectedPosition);
        fruit.setName(name);
        fruit.setDescription(description);
        fruit.setImage(imageResources[currentImageIndex]);
        adapter.notifyDataSetChanged();
        txtName.setText("");
        txtDescription.setText("");
        imageView.setImageResource(R.drawable.tran);
        selectedPosition = -1;
    }

    private void deleteFruit() {
        if (selectedPosition == -1) {
            Toast.makeText(this, "Please select a fruit to delete", Toast.LENGTH_SHORT).show();
            return;
        }
        arrFruits.remove(selectedPosition);
        adapter.notifyDataSetChanged();
        txtName.setText("");
        txtDescription.setText("");
        imageView.setImageResource(R.drawable.tran);
        selectedPosition = -1;
    }

    private void cycleImage() {
        currentImageIndex = (currentImageIndex + 1) % imageResources.length;
        imageView.setImageResource(imageResources[currentImageIndex]);
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

    private int findImageIndex(int resourceId, int[] resources) {
        for (int i = 0; i < resources.length; i++) {
            if (resources[i] == resourceId) {
                return i;
            }
        }
        return -1;
    }
}