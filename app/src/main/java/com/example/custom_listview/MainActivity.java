package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
        itemList = new ArrayList<>();

        // Sample data for list
        itemList.add(new ItemModel(R.drawable.ic_launcher_foreground, "Item 1"));
        itemList.add(new ItemModel(R.drawable.ic_launcher_foreground, "Item 2"));
        itemList.add(new ItemModel(R.drawable.ic_launcher_foreground, "Item 3"));

        // Setting up the adapter
        customAdapter = new CustomAdapter(this, itemList);
        listView.setAdapter(customAdapter);
    }
}
