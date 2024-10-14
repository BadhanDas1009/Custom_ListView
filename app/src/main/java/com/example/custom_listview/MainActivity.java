package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ItemModel> itemList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.customListView);
        Button addButton = findViewById(R.id.addButton);

        // Initialize the item list
        itemList = new ArrayList<>();

        // Sample initial data
        itemList.add(new ItemModel(R.drawable.ic_launcher_foreground, "Item 1"));
        itemList.add(new ItemModel(R.drawable.ic_launcher_foreground, "Item 2"));

        // Set up the custom adapter
        customAdapter = new CustomAdapter(this, itemList);
        listView.setAdapter(customAdapter);

        // Add items dynamically
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add a new item to the list
                itemList.add(new ItemModel(R.drawable.ic_launcher_foreground, "New Item"));

                // Notify the adapter that the data has changed so it can refresh the ListView
                customAdapter.notifyDataSetChanged();
            }
        });
    }
}
