package com.example.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ItemModel> {

    private Context context;

    public CustomAdapter(Context context, ArrayList<ItemModel> itemList) {
        super(context, 0, itemList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ItemModel item = getItem(position);

        if (item != null) {
            ImageView imageView = convertView.findViewById(R.id.itemImage);
            TextView textView = convertView.findViewById(R.id.itemText);

            imageView.setImageResource(item.getImageResId());
            textView.setText(item.getText());
        }

        return convertView;
    }
}
