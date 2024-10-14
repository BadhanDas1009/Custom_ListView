package com.example.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ItemModel> {

    private Context context;
    private ArrayList<ItemModel> itemList;

    public CustomAdapter(Context context, ArrayList<ItemModel> itemList) {
        super(context, 0, itemList);
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        // Get the current item
        final ItemModel item = getItem(position);

        // Set up the views
        ImageView imageView = convertView.findViewById(R.id.itemIcon);
        TextView textView = convertView.findViewById(R.id.itemText);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);

        // Set the icon and text
        imageView.setImageResource(item.getImageResId());
        textView.setText(item.getText());

        // Handle the delete button click
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove the item from the list
                itemList.remove(position);

                // Notify the adapter that the data has changed
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
